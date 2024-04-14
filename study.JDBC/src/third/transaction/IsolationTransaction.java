package third.transaction;

import org.junit.Test;
import queryResults.UserTable;
import util.ReadMysql;
import util.TransactionUniversal;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 数据库的并发问题
 * 1.脏读：对于两个事务t1和t2，t1读取了已经被t2更新但还没有提交的字段
 * 之后若t2回滚，t1读取的内容就是临时且无效的
 * 2.不可重复读：对于两个事务t1和t2，t1读取了一个字段，然后t2更新了该字段。
 * 之后t1再次读取同一个字段，值就不同了
 * 3.幻读：对于两个事务t1和t2，t1从一个表中读取了一个字段，然后t2在该表中插入了一些新的行。
 * 之后，如果t1再次读取同一个表，就会多出几行
 * <p>
 * 数据库事务的隔离性：数据库系统必须具有隔离并发运行各个事务的能力，使他们不会相互影响
 * 避免各种并发问题
 * 隔离级别越高，数据一致性就越好，但并发性越弱
 * <p>
 * 数据库的四种事务隔离级别：
 * READ UNCOMMITTED（读未提交数据）
 * 允许事务读取未被其他事务提交的变更，脏读，不可重复度和幻读的问题都会出现
 * READ COMMITTED（读已提交数据）
 * 只允许事务读取已经被其他事务提交的变更，可以避免脏读，但不可重复度和幻读问题仍然可能出现
 * REPEATABLE READ（可重读）
 * 确保事务可以多次从一个字段中读取相同的值
 * 在这个事务持续期间，禁止其他事务对这个字段进行更新，可以避免脏读和不可重复读，但幻读的问题仍然存在
 * SERIALIZABLE（串行化）
 * 确保事务可以从一个表中读取相同的行
 * 在这个事务持续期间，禁止其他事务对该表执行插入、更新和删除操作，所有并发问题都可以避免，但性能十分低下
 * <p>
 * Oracle支持的两种事务隔离级别：READ COMMITTED和SERIALIZABLE，默认是READ COMMITTED
 * MySQL支持四种事务隔离级别，默认是REPEATABLE READ
 *
 * 本次测试时，先将隔离级别设置为READ UNCOMMITTED
 * 然后测试transactionSelect()，得到查询结果为2000
 * 再测试transactionUpdate()，执行了修改语句后进入了休眠
 * 趁着休眠的时候再次执行transactionSelect()就会查询到balance变成了8000
 * （明明没有提交数据，但仍然读到了更新后的字段，这就是在READ UNCOMMITTED隔离级别下发生的脏读现象）
 *
 * 在本次测试中，两个测试程序都没有关闭对应的连接资源
 * 因为在关闭连接时会自动提交数据
 * 为了更好的体现在READ UNCOMMITTED隔离级别下，没有提交的数据也会被读到，出现脏读的情况
 * 所以在此省略了关闭资源的操作
 * @author shkstart
 * @date: 2022.10.02
 */
public class IsolationTransaction {
    @Test
    public void transactionSelect() {
        Connection connection = null;
        try {
            connection = ReadMysql.read();

//            查询数据库的隔离级别，4对应的是REPEATABLE READ，1对应的是READ UNCOMMITTED
            System.out.println(connection.getTransactionIsolation());

            /*
            * 因为当前设置的隔离级别是READ UNCOMMITTED
            * 为了避免出现脏读，可以设置数据库的隔离级别为READ COMMITTED
            * 此时再去运行transactionUpdate()
            * 由于连接没有关闭，即关闭了自动提交数据，也没有手动进行提交
            * 此时无论怎么读，都不再会出现脏读现象
            * */
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

//            取消自动提交数据
            connection.setAutoCommit(false);

            String sql = "select user,password,balance from user_table where user = ?";
            UserTable user = TransactionUniversal.aQuery(connection, UserTable.class, sql, "CC");
            System.out.println(user);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void transactionUpdate() throws SQLException, IOException, ClassNotFoundException, InterruptedException {
        Connection connection = ReadMysql.read();

//        取消自动提交数据
        connection.setAutoCommit(false);

        String sql = "update user_table set balance = ? where balance = ?";
        TransactionUniversal.update(connection, sql, 8000, 2000);

        Thread.sleep(15000);
        System.out.println("修改结束");
    }
}

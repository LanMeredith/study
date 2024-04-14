package third.transaction;

import org.junit.Test;
import util.ReadMysql;
import util.ShutMysql;
import util.TransactionUniversal;
import util.Universal;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 事务的学习
 * <p>
 * 数据库事务的介绍：
 * 事务：一组逻辑操作单元，使数据从一种状态变换到另一种状态。
 * -->一组逻辑操作单元，一个或多个DML操作
 * <p>
 * 事务处理（事务操作）：保证所有事务都作为一个工作单元来执行，即便出现了鼓掌，都不能改变这种执行方式
 * 当在一个事务中提交多个操作时，要么所有的事务都被提交，那么这些修改永远的保存下来
 * 要么数据库管理系统将放弃所作的所有修改，整个事务回滚到最初状态
 * <p>
 * 数据一经提交便不可回滚
 * 哪些操作会导致数据的自动提交？
 * -->DDL操作一旦执行，都会自动提交
 * -->DML默认情况下，一旦执行，就会自动提交（DML数据操纵语言，即数据库数据的增删改查操作）
 * ----->我们可以通过set autocommit = false的方式取消DML操作的自动提交
 * -->默认在关闭连接时，会自动的提交数据
 * <p>
 * 为确保数据库中数据的一致性，数据的操纵应当是离散的组成的逻辑单元
 * 当它全部完成时，数据的一致性可以保持
 * 而当这个单元中的一部分操作失败，整个事务应全部视为错误，所有从起始点以后的操作应全部回退到最初状态
 *
 * 事务的ACID属性
 * 原子性（Atomicity）
 * 原子性是指事务是一个不可分割的工作单位，事务中的操作要么都发生，要么都不发生
 * 一致性（Consistency）
 * 事务必须使数据库从一个一致性状态变幻到另一个一致性状态
 * 隔离性（Isolation）（类似于java的线程安全）
 * 事务的隔离性是指一个事务的执行不能被其他事务干扰，即一个事务内部的操作及使用的数据对并发的其他事务是个例的，并发执行的哥哥事务之间不能互相干扰
 * 持久性（Durability）
 * 持久性是指一个事务一旦被提交，它对数据库中数据的改变就是永久性的，接下来的其他操作和数据库故障不应该对其有任何影响
 * @author shkstart
 * @date: 2022.10.02
 */
public class StudyTransaction {
    /**
     * 未考虑数据库事务情况下的转账操作
     * <p>
     * 针对数据表user_table来说
     * AA用户给BB用户转账一百
     * 这个操作要么都执行，即AA转出钱，BB接收钱
     * 要么都不执行，即AA不出钱，BB也不收钱
     * 不能AA出钱了，但是BB没有收到钱
     * <p>
     * update user_table set balance = balance - 100 where user = 'AA';
     * update user_table set balance = balance + 100 where user = 'BB';
     */
    @Test
    public void Transfer() {
        String sqlOut = "update user_table set balance = balance - 100 where user = ?";
        Universal.update(sqlOut, "AA");

//        模拟网络异常，当出现异常的时候，AA转出了一百，但是BB并没有收到钱
        System.out.println(10 / 0);

        String sqlInto = "update user_table set balance = balance + 100 where user = ?";
        Universal.update(sqlInto, "BB");

        System.out.println("转账成功");
    }

    /**
     * 考虑事务的转账操作
     * 换用TransactionUniversal的update()方法
     *
     */
    @Test
    public void transactionTransfer() {
        Connection connect = null;
        try {
            connect = ReadMysql.read();

//            取消数据的自动提交
            connect.setAutoCommit(false);

            String sqlOut = "update user_table set balance = balance - 100 where user = ?";
            TransactionUniversal.update(connect, sqlOut, "AA");

//            模拟异常
//            System.out.println(10 / 0);

            String sqlInto = "update user_table set balance = balance + 100 where user = ?";
            TransactionUniversal.update(connect, sqlInto, "BB");

            System.out.println("转账成功");

//            提交数据
            connect.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            /*
            * 若此时Connection没有被关闭，则还可能会被重复使用，需要恢复其自动提交状态
            * SetAutoCommit(true)
            * 尤其是在使用数据库连接池技术时，执行close()方法前，建议恢复自动提交状态
            * */
            try {
                connect.setAutoCommit(true);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
//            在哪造的在哪关，这里建立的连接，也就在这里关闭
            ShutMysql.shutDown(connect, null);
        }
    }
}

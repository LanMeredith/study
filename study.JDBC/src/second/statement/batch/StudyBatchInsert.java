package second.statement.batch;

import org.junit.Test;
import util.ReadMysql;
import util.ShutMysql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 使用PreparedStatement实现批量数据的操作
 * update、delete本身就具有批量操作的效果
 * 此时的批量操作，主要指的是批量插入
 * <p>
 * 使用PreparedStatement如何实现更高效的批量插入
 * <p>
 * 题目：向goods表中插入1000条数据
 * create table goods(
 * id int primary key auto_increment,
 * name varchar(25)
 * );
 * 方式一：使用Statement实现
 * 获取连接
 * Statement statement = connection.createStatement();
 * for(int i = 1; i < 1000; i++){
 * String sql = "insert into goods(name) values('name_" + i + "')";
 * statement.execute(sql)
 * }
 *
 * @author shkstart
 * @date: 2022.10.02
 */
public class StudyBatchInsert {
    /**
     * 批量插入的方式二：使用PreparedStatement
     * 相较于方法一，sql模板不用重复创建，对内存资源的消耗更小
     *
     * PreparedStatement能最大可能的提高性能：
     * DBServer会对预编译语句提供性能优化，因为预编译语句有可能会被重复调用
     * 语句在被DBServer的编译器编译后的执行代码被缓存下来
     * 下次调用时只要是相同的预编译语句就不需要编译
     * 只要将参数直接传入编译过的语句执行代码中就会得到执行
     *
     * 而在Statement语句中，即使是相同的操作，但因为数据内容不一样。
     * 所以整个语句本身不能匹配，没有缓存语句的意义
     * 事实是没有数据库会对普通语句编译后的执行代码进行缓存
     * 这样没执行一次都要对传入的语句编译一次
     *
     * （语法检查，语义检查，翻译成二进制命令，缓存）
     *
     * PreparedStatement可以防止SQL注入
     */
    @Test
    public void batchInsertOne() {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ReadMysql.read();
            String sql = "insert into goods (name) values (?)";

            statement = connection.prepareStatement(sql);

            for (int i = 1; i <= 1000; i++) {
                statement.setObject(1, "name_" + i);

                statement.execute();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            ShutMysql.shutDown(connection, statement);
        }
    }

    /**
     * 批量插入方法三：
     * 1.addBatch()、executeBatch()、clearBatch()
     * 2.默认情况下，mysql服务器是关闭批处理的，我们需要通过一个参数，让mysql开启批处理的支持
     * 需要在配置文件中
     * 加上rewriteBatchStatements=true声明，写在url后面
     * 3.使用更新的mysql驱动：mysql-connector-java-5.1.37-bin.jar
     */
    @Test
    public void batchInsertTwo() {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ReadMysql.read();
            String sql = "insert into goods (name) values (?)";

            statement = connection.prepareStatement(sql);

            for (int i = 1; i <= 1000; i++) {
                statement.setObject(1, "name_" + i);

//                PreparedStatement还可以攒sql
                statement.addBatch();
//                一千正好可以除尽，如果是除不尽的话，可以在外面加个判断，是否到了最后一条记录，若到了则执行
                if (i % 200 == 0) {
//                    执行batch
                    statement.executeBatch();
//                    清空batch
                    statement.clearBatch();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            ShutMysql.shutDown(connection, statement);
        }
    }

    /**
     * 批量插入方式四：
     */
    @Test
    public void BatchInsertThree() {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ReadMysql.read();

//            设置不允许自动提交数据
            connection.setAutoCommit(false);

            String sql = "insert into goods (name) values (?)";
            statement = connection.prepareStatement(sql);

            for (int i = 1; i <= 1000; i++) {
                statement.setObject(1, "name_" + i);

//                PreparedStatement还可以攒sql，设置攒到两百就执行一次
                statement.addBatch();
//                一千正好可以除尽，如果是除不尽的话，可以在外面加个判断，是否到了最后一条记录，若到了则执行
                if (i % 200 == 0) {
//                    执行batch（因为设置了不允许自动提交数据，所以这里的执行也仍然相当于将数据缓存起来了
                    statement.executeBatch();
//                    清空batch
                    statement.clearBatch();
                }
            }

//            统一把数据进行提交
            connection.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            ShutMysql.shutDown(connection, statement);
        }
    }
}

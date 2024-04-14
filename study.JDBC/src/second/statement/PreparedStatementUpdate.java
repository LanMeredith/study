package second.statement;

import org.junit.Test;
import util.ReadMysql;
import util.ShutMysql;
import util.Universal;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;

/**
 * 使用PreparedStatement替换Statement
 * 实现对数据表的  增删改 查   操作
 * <p>
 * PreparedStatement是Statement的子接口
 * 这个对象是一个预编译的SQL的Statement
 * <p>
 * PreparedStatement除了Statement的拼串与sql注入问题外
 * 还有其他好处：
 * 1.PreparedStatement能够操作Blob的数据，而Statement做不到
 * 2.PreparedStatement可以实现更高效的批量操作
 *
 * @author shkstart
 * @date: 2022.09.17
 */
public class PreparedStatementUpdate {
    /**
     * 通过PreparedStatement操作向数据表中添加记录
     */
    @Test
    public void testInsert() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
//            加载配置文件
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
            Properties pros = new Properties();
            pros.load(is);

//            读取配置信息
            String user = pros.getProperty("user");
            String password = pros.getProperty("password");
            String url = pros.getProperty("url");
            String driverClass = pros.getProperty("driverClass");

//              加载驱动
            Class.forName(driverClass);

//              获取连接
            connection = DriverManager.getConnection(url, user, password);

//              向customers数据表中添加字段，?是占位符，通过这种方法解决Statement的弊端
            String sql = "insert into customers (name,email,birth) value (?,?,?)";
            preparedStatement = connection.prepareStatement(sql);

            /*
            填充占位符（即为预编译sql语句，返回PreparedStatement的实例）
            因为数据库的索引都是从1开始（java从0开始，由数组可见）
            所以这里先传入的数据也要从1开始
            1表示第一个占位符
            */
            preparedStatement.setString(1, "颜铭鹤");
            preparedStatement.setString(2, "2012713669@qq.com");
//            在此处频频报错，因为默认导包是java.util.Date，需要我们手动导包为java.sql.Date才行
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = simpleDateFormat.parse("2000-07-25");
            preparedStatement.setDate(3, new Date(date.getTime()));

//              执行操作
            preparedStatement.execute();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
//              资源的关闭
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    /**
     * 通过PreparedStatement操作向数据表中修改记录
     */
    @Test
    public void testUpdate() {
//        因为需要频繁的获取连接，所以将获取连接部分的代码封装到ReadMysql类的read()中去了
        Connection connection = null;
        PreparedStatement statement = null;
        try {
//            获取连接
            connection = ReadMysql.read();

//            预编译sql语句，返回PreparedStatement的实例
            String sql = "update customers set name = ? where name = ?";
            statement = connection.prepareStatement(sql);

//            填充占位符
            statement.setString(1, "SeedList");
            statement.setString(2, "颜铭鹤");

//            执行操作
            statement.execute();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
//            因为需要频繁的关闭资源连接，所以将此操作封装到ShutMysql类的shutDown()中去了
            ShutMysql.shutDown(connection, statement);
        }
    }

    /**
     * 通过PreparedStatement操作向数据表中删除记录
     * 由于在Universal封装了update()用以更简便的方法完成增删改操作
     * 所以本次测试采用update()完成对数据的删除
     */
    @Test
    public void testDelete() {
        /*
        执行删除操作
        可变形参想传几个进去都可以
        但是传进去的形参数量要与占位符相等
        */
        String sql = "delete from customers where name = ?";
        Universal.update(sql, "颜铭鹤");

//        通用的增删改操作，换个表也一样可以。
//        为了避免重复添加，所以这里先注释掉了。
        /*
        sql = "insert into user_table (user,password,balance) value (?,?,?)";
        Universal.update(sql, "SeedList", "seedList", 15);
        */
    }
}

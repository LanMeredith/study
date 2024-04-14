package sixth.dbutils;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;
import fifth.pool.util.JDBCUtils;
import queryResults.Customer;
import util.ShutMysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * commons-dbutils是Apache组织提供的一个开源JDBC工具类库
 * 它是对JDBC的简单封装
 * 学习成本极低，并且使用dbutils能极大简化JDBC编码的工作量
 * 同时也不会影响程序的性能
 *
 * @author SeedList
 * @date: 2022.10.03
 */
public class StudyQueryRunner {
    /**
     * 测试插入操作（增删改）
     */
    @Test
    public void testInsert() {
        Connection connection = null;
        try {
            QueryRunner runner = new QueryRunner();
            connection = JDBCUtils.getConnectionDruid();

            String sql = "insert customers(name,email,birth) value (?,?,?)";

            int insertCount = runner.update(connection, sql, "鸡哥","cxk@126.com","1997-08-01");
            System.out.println("添加了" + insertCount +"条记录");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            ShutMysql.shutDown(connection, null);
        }
    }

    /**
     * 测试查询
     * BeanHandler：是ResultSetHandler接口的实现类，用于封装表中的一条记录
     */
    @Test
    public void testQueryOne() {
        Connection connection = null;
        try {
            QueryRunner runner = new QueryRunner();
            connection = JDBCUtils.getConnectionDruid();

            String sql = "select id,name,email,birth from customers where id = ?";

//            创建一个结果集处理器
            BeanHandler<Customer> handler = new BeanHandler<>(Customer.class);

            Customer customer = runner.query(connection, sql, handler, 21);
            System.out.println(customer);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
//            关闭连接
            ShutMysql.shutDown(connection, null);
        }
    }

    /**
     * BeanListHandler：是ResultSetHandler接口的实现类，用于封装表中的多条记录构成的集合
     */
    @Test
    public void testQueryTwo() {
        Connection connection = null;
        try {
            QueryRunner runner = new QueryRunner();
            connection = JDBCUtils.getConnectionDruid();

            String sql = "select id,name,email,birth from customers where id < ?";

//            创建一个结果集处理器
            BeanListHandler<Customer> handler = new BeanListHandler<>(Customer.class);

            List<Customer> list = runner.query(connection, sql, handler, 21);

            list.forEach(System.out::println);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
//            关闭连接
            ShutMysql.shutDown(connection, null);
        }
    }

    /**
     * MapHandler：是ResultSetHandler接口的实现类，用于对应表中的一条记录
     * 将字段及相应字段的值作为map中的key和value
     */
    @Test
    public void testQueryThree() {
        Connection connection = null;
        try {
            QueryRunner runner = new QueryRunner();
            connection = JDBCUtils.getConnectionDruid();

            String sql = "select id,name,email,birth from customers where id = ?";

//            创建一个结果集处理器
            MapHandler handler = new MapHandler();

            Map<String, Object> map = runner.query(connection, sql, handler, 21);

            System.out.println(map);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
//            关闭连接
            ShutMysql.shutDown(connection, null);
        }
    }

    /**
     * MapListHandler：是ResultSetHandler接口的实现类，对应表中的多条记录
     * 将字段及相应字段的值作为map中的key和value，讲这些map添加到list中
     */
    @Test
    public void testQueryFour() {
        Connection connection = null;
        try {
            QueryRunner runner = new QueryRunner();
            connection = JDBCUtils.getConnectionDruid();

            String sql = "select id,name,email,birth from customers where id < ?";

//            创建一个结果集处理器
            MapListHandler handler = new MapListHandler();

            List<Map<String, Object>> maps = runner.query(connection, sql, handler, 21);

            maps.forEach(System.out::println);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
//            关闭连接
            ShutMysql.shutDown(connection, null);
        }
    }

    /**
     * ScalarHandler:用于查询表中特殊值的操作
     */
    @Test
    public void testQueryFive() {
        Connection connection = null;
        try {
            QueryRunner runner = new QueryRunner();
            connection = JDBCUtils.getConnectionDruid();

//            查询表中一共有多少条记录
            String sql = "select count(*) from customers";
//            创建一个结果集处理器
            ScalarHandler handler = new ScalarHandler();
            Long count = (Long) runner.query(connection, sql, handler);
            System.out.println("一共有" + count + "条记录");

//            查最大的生日
            sql = "select max(birth) from customers";
            Date birth = (Date) runner.query(connection, sql, handler);
            System.out.println(birth);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
//            关闭连接
            ShutMysql.shutDown(connection, null);
        }
    }

    /**
     * 自定义ResultSetHandler的实现类
     */
    @Test
    public void testQuerySix() {
        Connection connection = null;
        try {
            QueryRunner runner = new QueryRunner();
            connection = JDBCUtils.getConnectionDruid();

            String sql = "select id,name,email,birth from customers where id = ?";

//            自定义一个匿名实现类的非匿名对象
            ResultSetHandler<Customer> handler = new ResultSetHandler<Customer>() {
                /*
                * 这个方法拿到的参数resultSet就是结果集
                * 经过处理后，将处理后的结果返回
                * query拿到的是处理后的结果
                * 在这里因为我返回处理的结果，而是返回了一个自己随便造的匿名对象
                * 所以后续query()查到的也是这个匿名对象
                * */
                @Override
                public Customer handle(ResultSet resultSet) throws SQLException {
                    System.out.println("这个方法被调用了");
                    return new Customer(1, "Seed", "2000725@126.com", new java.sql.Date(657486451359874516L));
                }
            };

            Customer customer = runner.query(connection, sql, handler, 21);
            System.out.println(customer);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            /*
            * 使用dbutils.jar中提供的DbUtils工具类，实现资源的关闭
            * */
            try {
                DbUtils.close(connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}

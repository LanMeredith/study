package util;

import queryResults.Customer;
import queryResults.Order;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;

/**
 * 使用PreparedStatement实现
 * update()实现通用的增删改操作
 * customerQuery()、orderQuery()实现通用的查询操作（仅限于特定数据表）
 * query()实现针对不同的数据表，通用的查询操作
 *
 * @author shkstart
 * @date: 2022.09.29
 */
public class Universal {
    /**
     * 通用的增删改操作
     * 因为不确定会有几个占位符，所以采用可变形参
     * sql中的占位符的个数，与可变形参的长度相同
     * 也因为不知道可变形参分别是什么类型（即不知道占位符要输入的类型）所以类型是Object
     *
     * @return
     */
    public static int update(String sql, Object... args) {
        Connection connect = null;
        PreparedStatement statement = null;
        int value = 0;
        try {
//            1.获取数据库的连接
            connect = ReadMysql.read();

//        2.预编译sql语句，返回PreparedStatement实例
            statement = connect.prepareStatement(sql);

//        3.填充占位符
            for (int i = 0; i < args.length; i++) {
                /*
                此处需要小心参数声明错误
                第一个参数是i+1因为数据库索引是从1开始的
                第二个参数是args[i]，因为在java中，数组索引是从0开始的
                */
                statement.setObject(i + 1, args[i]);
            }

            /*
             * 4.执行
             * statement.execute()
             * 如果执行的是查询操作，则有返回结果
             * 此方法返回的是true，无结果集则返回false
             *
             * 因此换用executeUpdate()（注意，此处要调用的是PreparedStatement的方法，不是Statement的方法）
             * 返回值是int类型
             * 如果是执行SQL数据操作语言（DML），即增删改操作，那么返回被操作的行数
             * 如果是不是则返回零
             * */
            value = statement.executeUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
//        5.关闭资源
            ShutMysql.shutDown(connect, statement);
            return value;
        }
    }

    /**
     * 仅限于Customers数据表的通用的查询操作
     * 由于查询得到的结果可能不止一条，所以采用列表的方式记录
     */
    public static ArrayList<Customer> customerQuery(String sql, Object... args) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<Customer> customers = new ArrayList<>();
        try {
//            获取连接
            connection = ReadMysql.read();

//            预编译sql语句，返回PreparedStatement的实例
            statement = connection.prepareStatement(sql);

//            填充占位符
            for (int i = 0; i < args.length; i++) {
                statement.setObject(i + 1, args[i]);
            }

//            执行并返回一个结果集
            resultSet = statement.executeQuery();

//            获取结果集的元数据
            ResultSetMetaData data = resultSet.getMetaData();

//            通过元数据获取结果集中的列数
            int columnCount = data.getColumnCount();

//            处理结果集
            while (resultSet.next()) {
                /*
                 * 获取当前这条数据的各个字段值
                 * 因为不知道字段有多少列
                 * 所以需要通过ResultSetMateData获取结果集中的列数
                 * */
                Customer results = new Customer();

                for (int i = 0; i < columnCount; i++) {
//                    此处也是i+1，因为获取的是数据库的列的值，自然是按照数据库的规矩，从一开始
                    Object value = resultSet.getObject(i + 1);

//                    获取每个列的列名，通过ResultSetMetaData
                    String columnName = data.getColumnName(i + 1);

                    /*
                     * 给results对象指定的columnName属性，赋值为value。
                     * 通过反射
                     * getDeclaredField()可以获取到指定的成员变量
                     * */
                    Field field = Customer.class.getDeclaredField(columnName);
//                    获取到的属性可能是私有的，将其设置为true方便使用
                    field.setAccessible(true);
//                    将value值传输到order对象的对应属性中
                    field.set(results, value);
                }

//                将填充了内容的对象添加到列表当中
                customers.add(results);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
//            关闭资源
            ShutMysql.shutDown(connection, statement, resultSet);

            return customers;
        }
    }

    /**
     * 仅限于Order数据表的通用的查询操作
     * <p>
     * 针对于表的字段与类的属性名不相同的情况
     * 必须声明sql时，使用类的属性名来命名字段的别名
     * 使用ResultSetMetaData时，需要使用getColumnLabel()来替换getColumnName()来获取列的别名
     *
     * @param sql
     * @param args
     * @return
     */
    public static ArrayList<Order> orderQuery(String sql, Object... args) {
        ArrayList<Order> orders = new ArrayList<>();
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement statement = null;

        try {
//            获取连接
            connection = ReadMysql.read();

//            预编译sql语句，返回PreparedStatement的实例
            statement = connection.prepareStatement(sql);

//            填充占位符
            for (int i = 0; i < args.length; i++) {
                statement.setObject(i + 1, args[i]);
            }

//            执行并返回一个结果集
            resultSet = statement.executeQuery();

//            获取结果集元数据
            ResultSetMetaData data = resultSet.getMetaData();
//            通过元数据获取到数据表的列数
            int count = data.getColumnCount();

//            处理结果集
            while (resultSet.next()) {
//                用于接收结果
                Order order = new Order();

                for (int i = 0; i < count; i++) {
//                    此处也是i+1，因为获取的是数据库的列的值，自然是按照数据库的规矩，从一开始
                    Object value = resultSet.getObject(i + 1);

                    /*
                     * 获取每个列的列名
                     * String orderName = data.getColumnName(i + 1);
                     * 由于下面的问题，所以这里不能获取列的列名，否则仍然会出现找不到对应属性的错误
                     * 我们要换个方法，获取列的别名
                     * 推荐使用getColumnLabel()
                     * 因为它可以获取别名，如果没有起别名的话，将直接获取到列名
                     * 能够替代getColumnName()更好满足需求
                     * */
                    String orderLabel = data.getColumnLabel(i + 1);

                    /*
                     * 给results对象指定的orderName属性，赋值为value。
                     * 在这里会出现一个问题，Order类中的属性是orderId,orderName,orderDate
                     * 而在order数据表中，它的列名是order_id,order_name,order_date
                     * 虽然有一一对应关系，但是在程序上名字的不同会导致找不到对应的属性
                     * 通过反射，用order_id去找orderId必然是没结果的
                     *
                     * 此时需要用到mysql查询中的别名功能
                     * 使用：列名 AS 别名   或   列名 别名
                     * 用了别名之后，返回的结果集将列名将由别名代替，这个时候就可以解决找不到对应属性的问题
                     * */
                    Field field = Order.class.getDeclaredField(orderLabel);
//                    获取到的属性可能是私有的，将其设置为true方便使用
                    field.setAccessible(true);
//                    将value值传输到order对象的对应属性中
                    field.set(order, value);
                }

//                将填充了内容的对象添加到列表当中
                orders.add(order);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
//            关闭资源
            ShutMysql.shutDown(connection, statement, resultSet);
            return orders;
        }
    }

    /**
     * 通过泛型来为不同的数据表匹配上对应的类
     * 任意数据表都可适用的查询方法
     *
     * @param tClass
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public static <T> ArrayList<T> query(Class<T> tClass, String sql, Object... args) {
        ArrayList<T> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
//            获取连接
            connection = ReadMysql.read();

//            预编译sql语句，返回PreparedStatement的实例
            statement = connection.prepareStatement(sql);

//            填充占位符
            for (int i = 0; i < args.length; i++) {
                statement.setObject(i + 1, args[i]);
            }

//            执行并返回一个结果集
            resultSet = statement.executeQuery();

//            获取结果集元数据
            ResultSetMetaData data = resultSet.getMetaData();

//            获取结果集元数据的列数
            int count = data.getColumnCount();

//            处理结果集
            while (resultSet.next()) {

//                因为这是拿来对任意数据表进行通用查询的，所以要利用泛型进行实例化，接收查询结果
                T t = tClass.newInstance();

                for (int i = 0; i < count; i++) {
//                    此处也是i+1，因为获取的是数据库的列的值，自然是按照数据库的规矩，从一开始
                    Object value = resultSet.getObject(i + 1);

//                    获取每个列的别名
                    String tLabel = data.getColumnLabel(i + 1);

//                    查询此列别名在类当中的对应属性
                    Field field = t.getClass().getDeclaredField(tLabel);

//                    获取到的属性可能是私有的，将其设置为true方便使用
                    field.setAccessible(true);

//                    将value值传输到t对象的对应属性中
                    field.set(t, value);
                }

//                将填充了内容的对象添加到列表当中
                list.add(t);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } finally {
//            关闭资源
            ShutMysql.shutDown(connection, statement, resultSet);
            return list;
        }
    }

    /**
     * 只返回一条记录的任意类通用查询语句
     *
     * @param tClass
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public static <T> T aQuery(Class<T> tClass, String sql, Object... args) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        T t = null;

        try {
//            获取连接
            connection = ReadMysql.read();

//            预编译sql语句，返回PreparedStatement的实例
            statement = connection.prepareStatement(sql);

//            填充占位符
            for (int i = 0; i < args.length; i++) {
                statement.setObject(i + 1, args[i]);
            }

//            执行并返回一个结果集
            resultSet = statement.executeQuery();

//            获取结果集元数据
            ResultSetMetaData data = resultSet.getMetaData();

//            获取结果集元数据的列数
            int count = data.getColumnCount();

//            处理结果集
            if (resultSet.next()) {

//            因为这是拿来对任意数据表进行通用查询的，所以要利用泛型进行实例化，接收查询结果
                t = tClass.newInstance();

                for (int i = 0; i < count; i++) {
//                    此处也是i+1，因为获取的是数据库的列的值，自然是按照数据库的规矩，从一开始
                    Object value = resultSet.getObject(i + 1);

//                    获取每个列的别名
                    String tLabel = data.getColumnLabel(i + 1);

//                    查询此列别名在类当中的对应属性
                    Field field = t.getClass().getDeclaredField(tLabel);

//                    获取到的属性可能是私有的，将其设置为true方便使用
                    field.setAccessible(true);

//                    将value值传输到t对象的对应属性中
                    field.set(t, value);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } finally {
//            关闭资源
            ShutMysql.shutDown(connection, statement, resultSet);
            return t;
        }
    }
}

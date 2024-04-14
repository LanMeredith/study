package util;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.*;

/**
 * 考虑上事务的通用操作
 *
 * @author shkstart
 * @date: 2022.10.02
 */
public class TransactionUniversal {
    /**
     * 考虑上事务后写的增删改通用操作方法
     * 连接改由外部提供
     * 因为一个事务有一个或多个DML操作
     * 为了保证这些操作为一个整体，所以只进行一次连接，相当于用一条线将这些操作串起来
     *
     * @return
     */
    public static int update(Connection connect, String sql, Object... args) {
        PreparedStatement statement = null;
        try {
//            1.预编译sql语句，返回PreparedStatement实例
            statement = connect.prepareStatement(sql);

//            2.填充占位符
            for (int i = 0; i < args.length; i++) {
                /*
                * 此处需要小心参数声明错误
                * 第一个参数是i+1因为数据库索引是从1开始的
                * 第二个参数是args[i]，因为在java中，数组索引是从0开始的
                * */
                statement.setObject(i + 1, args[i]);
            }

            /*
             * 3.执行
             * statement.execute()
             * 如果执行的是查询操作，则有返回结果
             * 此方法返回的是true，无结果集则返回false
             *
             * 因此换用executeUpdate()（注意，此处要调用的是PreparedStatement的方法，不是Statement的方法）
             * 返回值是int类型
             * 如果是执行SQL数据操作语言（DML），即增删改操作，那么返回被操作的行数
             * 如果是不是则返回零
             * */
            return statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
//            5.关闭资源
            ShutMysql.shutDown(null, statement);
            return 0;
        }
    }

    /**
     * 考虑事务的查询操作
     * 用于返回数据表中的一条记录
     * 和update方法类似，连接由外部传入
     * @param connection
     * @param tClass
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public static <T> T aQuery(Connection connection, Class<T> tClass, String sql, Object... args) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        T t = null;

        try {
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
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } finally {
//            关闭资源
            ShutMysql.shutDown(null, statement, resultSet);
            return t;
        }
    }
}

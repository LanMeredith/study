package second.statement.query;

import org.junit.Test;
import queryResults.Customer;
import util.ReadMysql;
import util.ShutMysql;
import util.Universal;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 针对Customers数据表进行的查询操作
 * query包下的类全部都是学习查询操作的例子
 *
 * @author shkstart
 * @date: 2022.09.29
 */
public class CustomerForQuery {
    /**
     * 第一次测试
     */
    @Test
    public void testQueryOne() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
//            获取连接
            connection = ReadMysql.read();

            String sql = "select id,name,email,birth from customers where id = ?";

//            预编译sql语句，返回PreparedStatement的实例
            statement = connection.prepareStatement(sql);

//            填充占位符
            statement.setObject(1, 1);

            /*
             * 执行，并返回一个结果集
             * 若是增删改操作，则直接调用execute()完成
             * 查询调用的executeQuery()将返回结果集
             * */
            resultSet = statement.executeQuery();

            /*
             * 处理结果集
             * 此处的next()方法和迭代器中的next()不一样
             *
             * 迭代器中有next()和hasNext()两个方法
             * hasNext()判断是否还有下一个元素
             * next()指针下移，将下移以后集合位置上的元素返回
             *
             * 而此处ResultSet类中的next()功能为：
             * 判断是否下一条是否还有数据，如果有则返回true，并指针下移，否则返回false，直接结束
             * */
            if (resultSet.next()) {
//                获取当前这条数据的各个字段值
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                Date birth = resultSet.getDate(4);

                Customer results = new Customer(id, name, email, birth);
                System.out.println(results);
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
        }
    }

    /**
     * 使用通用方法测试
     */
    @Test
    public void testQueryTwo() {
        String sql = "select id,name,email,birth from customers where id = ? or id = ?";
        ArrayList<Customer> customers = Universal.customerQuery(sql, 3, 16);

//        利用迭代器将列表中的内容输出
        Iterator<Customer> iterator = customers.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

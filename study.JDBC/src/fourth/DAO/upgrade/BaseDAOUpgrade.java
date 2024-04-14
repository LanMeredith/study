package fourth.DAO.upgrade;

import util.ShutMysql;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;

/**
 * DAO：data(base) access object
 *
 * 封装了针对于数据表的通用的操作
 * 不用来造对象，只是用来提供通用的方法的
 * 针对具体的表，提供具体的DAO
 *
 * 这个包下的三个类虽然在DAO大包下也有，但这是针对DAO大包下的升级操作
 * 给BaseDAOI加上个泛型，继承时，子类声明具体对应的类即可
 *
 * @author shkstart
 * @date: 2022.10.02
 */
public abstract class BaseDAOUpgrade<T> {
    /**
     * 因为每个数据表都有专门的操作类
     * 两者是一一对应的关系
     * 所以在子类继承父类时声明对应的类
     * 然后再由此得到对应的tClass
     */
    private Class<T> tClass = null;

    /**
     * 构造代码块会随着构造器的加载而加载
     * 这是父类，当new一个子类的对象的时候
     * 通过构造器，会调用super()
     * 也就是说会随之调用父类的构造器
     * 从而加载以下的代码块
     * 而根据多态的特性，虽然new的是子类对象
     * 但这里的代码块，this仍然是子类对象的this
     * 获取带泛型的父类，也就是子类继承的那个带泛型的父类
     */
    {
//        获取当前BaseDAO子类的继承的父类的泛型
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
//        获取父类的泛型参数，因为可能会有多个，所以这里返回的是个数组
        Type[] types = parameterizedType.getActualTypeArguments();
        /*
        * 泛型的第一个参数
        * （一一对应的关系中，第一个参数就是指的就是父类的泛型）
        * */
        tClass = (Class<T>) types[0];
    }

    /**
     * 考虑上事务的增删改操作
     *
     * @param connect 连接
     * @param sql 查询语句
     * @param args 可变形参，即填充的占位符
     * @return
     */
    public int update(Connection connect, String sql, Object... args) {
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
     * 单条语句的查询
     * 基于DAO大包下的升级操作
     * @param connection 连接
     * @param sql 查询语句
     * @param args 可变形参，即填充的占位符
     * @return 查询结果对应的类
     */
    public T aQuery(Connection connection, String sql, Object... args) {
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
        }
        return t;
    }

    /**
     * 通过泛型来为不同的数据表匹配上对应的类
     * 任意数据表都可适用的查询方法
     * 同时考虑到了事务
     * @param connection 连接
     * @param sql 查询语句
     * @param args 可变形参，即填充的占位符
     * @return 对应结果的类的列表
     */
    public ArrayList<T> query(Connection connection, String sql, Object... args) {
        ArrayList<T> list = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

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
        }
        return list;
    }

    /**
     * 用于查询特殊值的通用方法
     * @param connection 连接
     * @param sql 查询语句
     * @param args 可变形参，即填充的占位符
     * @param <E> 不知道会得到什么结果，所以采用泛型来获取对应的类
     * @return 要么是null，要么是通过泛型取得的对应类
     */
    public <E> E getValue(Connection connection, String sql, Object... args) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                statement.setObject(i + 1, args[i]);
            }
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return (E) resultSet.getObject(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            ShutMysql.shutDown(null, statement, resultSet);
        }
        return null;
    }
}

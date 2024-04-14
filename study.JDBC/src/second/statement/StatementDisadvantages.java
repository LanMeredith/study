package second.statement;

import org.junit.Test;
import util.Universal;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * 在java.sql包中有三个接口分贝定义了对数据库的调用的不同方式
 * <p>
 * Statement：用于执行静态SQl语句并返回它所生成结果的对象
 * <p>
 * PreparedStatement：SQL语句被预编并存储在此对象中，可以使用此对象多次高效的执行该语句
 * <p>
 * CallableStatement：用于执行SQL存储过程
 * <p>
 * 使用Statement的弊端：
 * 需要拼写sql语句
 * 并且存在sql注入问题：输入的用户名和密码不正确也可以对数据库数据进行恶意篡改
 * <p>
 * SQL注入是利用某些系统没有对用户输入的数据进行充分的检查，而在用户输入数据中注入非法的SQL语句段或命令
 * 如
 * SELECT user,password
 * FROM user_table
 * WHERE user = '1' or ' AND password = ' = 1 or '1' = '1'
 * 从而利用系统的SQl引擎完成恶意行为的做法
 * <p>
 * 对于java而言，要防范SQL注入，只要用PreparedStatement（从Statement扩展而来）取代Statement即可
 *
 * @author shkstart
 * @date: 2022.09.17
 */
public class StatementDisadvantages {
    /**
     * 测试statement的弊端，通过调用get方法进行查询，出现了sql注入问题
     */
    @Test
    public void test() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入用户名：");
        String user = scanner.nextLine();
        System.out.print("请输入密码：");
        String password = scanner.nextLine();

        /*
        在这就会出现sql注入问题，当用户名和密码输入如下时，会出现即便用户名和密码不正确的也仍然能够登录的情况
        SELECT user,password
        FROM user_table
        WHERE user = '1' or ' AND password = ' = 1 or '1' = '1'

        设置用户名为1' or
        密码为 = 1 or '1' = '1
        即可欺骗验证

        原因是在这条sql语句中进行了三次判断
        user = '1'  搜索user字段中有无记录为1的
        or  或
        'AND password = ' = 1   比较字符串AND password与1是否相同
        or  或
        '1' = '1'   比较1是否等于1
         */
        String sql = "SELECT user,password FROM user_table WHERE user = '" + user + "' AND password = '" + password + "'";

        StatementDisadvantages sd = new StatementDisadvantages();
        User returnUser = (User) sd.get(sql, User.class);

        if (returnUser != null) {
            System.out.println("登录成功");
        } else {
            System.out.println("用户名不存在或密码错误");
        }
    }

    /**
     * 使用PreparedStatement解决Statement存在的sql注入问题
     * 在这里因为经过了对sql语句的预编译
     * 不会出现查询条件中，and关系经过特定的输入后被修改
     * Statement没有预编译，查询的时候是整条语句传输进去查询，由此出现了sql注入问题
     */
    @Test
    public void testUpdate() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入用户名：");
        String user = scanner.nextLine();
        System.out.print("请输入密码：");
        String password = scanner.nextLine();

        String sql = "SELECT user,password FROM user_table WHERE user = ? AND password = ?";
        User results = Universal.aQuery(User.class, sql, user, password);
        if (results != null) {
            System.out.println("登录成功");
        } else {
            System.out.println("用户名不存在或密码错误");
        }
    }

    /**
     * Statement：用于执行静态SQl语句并返回它所生成结果的对象
     * 使用Statement实现对数据表的查询操作
     *
     * @param sql
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T get(String sql, Class<T> clazz) {
        T t = null;

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
//            加载配置文件
            InputStream is = StatementDisadvantages.class.getClassLoader().getResourceAsStream("jdbc.properties");
            Properties pros = new Properties();
            pros.load(is);

//            读取配置信息
            String user = pros.getProperty("user");
            String password = pros.getProperty("password");
            String url = pros.getProperty("url");
            String driverClass = pros.getProperty("driverClass");

//            加载驱动
            Class.forName(driverClass);

//            获取连接
            conn = DriverManager.getConnection(url, user, password);

            st = conn.createStatement();

            rs = st.executeQuery(sql);

//            获取结果集的元数据
            ResultSetMetaData rsmd = rs.getMetaData();

//            获取结果集的列数
            int columnCount = rsmd.getColumnCount();

            if (!rs.next()) {
                return null;
            } else {
                t = clazz.newInstance();

                for (int i = 0; i < columnCount; ++i) {
                    /*
                    获取列的别名
                    如果是要获取列的名称则用getColumnName()
                    String columnName = rsmd.getColumnName(i + 1);
                     */
                    String columnName = rsmd.getColumnLabel(i + 1);

//                    根据列名获取对应数据表中的数据
                    Object columnVal = rs.getObject(columnName);

//                    将数据表中得到的数据封装进对象
                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(t, columnVal);
                }

                Object var20 = t;
                return (T) var20;
            }
        } catch (Exception var39) {
            var39.printStackTrace();
            return null;
        } finally {
//            关闭资源
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException var38) {
                    var38.printStackTrace();
                }
            }

            if (st != null) {
                try {
                    st.close();
                } catch (SQLException var37) {
                    var37.printStackTrace();
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException var36) {
                    var36.printStackTrace();
                }
            }
        }
    }
}

package first.connection;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 对Connection方法的测试
 * <p>
 * Driver是每个数据库驱动程序类必须实现的接口。
 * MySQL的是com.mysql.jdbc.Driver
 * 主要作用是注册数据源驱动，提供统一的接口
 *
 * @author shkstart
 * @date: 2022.09.14
 */
public class StudyConnection {
    /**
     * 连接方式一
     */
    @Test
    public void test() {
        /*
        * Driver是每个数据库驱动程序类必须实现的接口
        * MySQL的是com.mysql.jdbc.Driver
        * 主要作用是注册数据源驱动，提供统一的接口
        * 可以将光标放置于Driver上，然后使用 Ctrl+H快捷键显示类的继承结构，从而找到我们要new的类具体是哪个
        * */
        Driver driver = null;
        try {
//            这里的是第三方的API
            driver = new com.mysql.jdbc.Driver();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        /*
        JDBC URL用于标识一个被注册的驱动程序，驱动程序管理器通过这个URL选择正确的驱动程序，从而建立到数据库的连接
        JDBC URL的标准由三部分组成，各部分间用冒号分隔
        jdbc:子协议:子名称
        协议：JDBC URL中的协议总是jdbc
        子协议：子协议用于表示一个数据库驱动程序
        子名称：一种标识数据库的方法。子名称可以依不同的子协议而变化，用子名称的目的是为了定位数据库提供足够的信息。
        包含主机名（对应服务器的ip地址），端口号，数据库名

        举例：
        jdbc:mysql://localhost:3306/test    （这个值是固定的）
        jdbc:mysql是协议
        localhost是ip地址
        3306默认是mysql的端口号
        最后的test是指数据库名称，因为我用的数据库名称是study_jdbc
        所以在下行的最后将test改成了study_jdbc
         */
        String url = "jdbc:mysql://localhost:3306/study_jdbc";

        /*
        Map的实现类Properties
        在study.collection模块中有StudyProperties类，可以进行大致了解
        Properties：常用来处理配置文件。key和value都是String类型

        将用户名和密码封装在Properties中
        在StudyProperties类中使用了getProperty方法，可以获取到文件中的name与password数据
        而这里的操作相当于输入密码。
         */
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "study");

        Connection connection = null;

        try {
            connection = driver.connect(url, info);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        System.out.println(connection);
    }

    /**
     * 连接方式二
     * 对方式一的迭代
     * 使得在程序中不会出现第三方的API，具有更好的可移植性。
     */
    @Test
    public void testOne() throws Exception {
//        利用反射动态的获取Driver的实现类对象
        Class aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();

//        提供要连接的数据库
        String url = "jdbc:mysql://localhost:3306/study_jdbc";

//        提供连接需要的用户名和密码
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "study");

//        获取连接
        Connection connect = driver.connect(url, info);
        System.out.println(connect);
    }

    /**
     * 连接方式三
     * 使用DriverManger替换Driver
     */
    @Test
    public void testTwo() throws Exception {
//        提供三个的连接的基本信息
        String url = "jdbc:mysql://localhost:3306/study_jdbc";
        String user = "root";
        String password = "study";

//        获取Driver的实现类对象
        Class aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();

//        注册驱动
        DriverManager.registerDriver(driver);

//        获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }

    /**
     * 连接方式四
     * 可以只是加载驱动，而不再显示的注册驱动了
     */
    @Test
    public void testThree() throws Exception {
//        提供三个的连接的基本信息
        String url = "jdbc:mysql://localhost:3306/study_jdbc";
        String user = "root";
        String password = "study";

        /*
        获取Driver实现类的对象
        这一步也可以省略。
        在jar的包下，有java.sql.Driver文件。
        这就是在获取连接时，帮我们获取到Driver实现类的对象的操作

        但仅限于mysql，换个数据库就可能不能省略了。
        所以非必要不能省略。
         */
        Class.forName("com.mysql.jdbc.Driver");

        /*
        相较于方式三，可以省略如下操作：
        Driver driver = (Driver) aClass.newInstance();
        注册驱动
        DriverManager.registerDriver(driver);
        为什么可以省略上述操作？
        因为在mysql的Driver实现类中，声明了如下的操作：
        static {
            try {
                DriverManager.registerDriver(new Driver());
            } catch (SQLException var1) {
                throw new RuntimeException("Can't register driver!");
            }
        }
         */

//        获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }

    /**
     * 方法五：（final版）
     * 将数据库连接需要的四个基本信息，声明在配置文件中
     * 通过读取配置文件的方式，获取连接
     * <p>
     * 这种方式的好处：
     * 实现了数据与代码的分离，实现了解耦
     * 可移植性好
     * 修改配置信息不需要对原有程序进行重新打包
     */
    @Test
    public void testFour() throws Exception {
//        加载配置文件
        InputStream inputStream = StudyConnection.class.getClassLoader().getResourceAsStream("jdbc.properties");

        Properties properties = new Properties();
        properties.load(inputStream);

//        读取配置信息
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driverClass = properties.getProperty("driverClass");

        /*
        加载驱动
        和方式三一样省略掉了如下代码
        Driver driver = (Driver) aClass.newInstance();
        注册驱动
        DriverManager.registerDriver(driver);
        省略理由也是一样的
         */
        Class.forName(driverClass);

//        获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }
}

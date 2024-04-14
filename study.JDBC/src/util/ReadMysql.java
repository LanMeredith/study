package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 在学习过程中，需要频繁的读取配置文件以进行数据库连接操作
 * 为了方便，将读取配置文件的操作封装到这个类当中
 * @author shkstart
 * @date: 2022.09.28
 */
public class ReadMysql {
    public static Connection read() throws IOException, SQLException, ClassNotFoundException {
//        加载配置文件
        InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        Properties pros = new Properties();
        pros.load(inputStream);

//        读取配置信息
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

//        加载驱动
        Class.forName(driverClass);
//        返回连接
        return DriverManager.getConnection(url, user, password);
    }
}

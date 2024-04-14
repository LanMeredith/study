package fifth.pool.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author SeedList
 * @date: 2022.10.03
 */
public class JDBCUtils {

    /**
     * 创建一个C3P0数据库连接池
     * 池子就一个，连接可以有很多
     * 这样可以不用造很多池子，只提供一个连接池
     * 这里之所以没有读取配置文件的操作
     * 是因为C3P0的配置文件默认就叫c3p0-config.xml
     * 会自己去找这个对应的配置文件
     */
    private static ComboPooledDataSource cpds = new ComboPooledDataSource("StudyC3P0");

    /**
     * 我们只想要一个数据库连接池
     * 但是DBCP数据库连接池在创建之前需要读取配置文件
     * 有几步繁琐的操作将会导致连接池反复创建
     * 为了解决这种情况，只创建一个数据库连接池
     * 所以采用了静态代码块的方法
     */
    private static DataSource DBCPDataSource;

    /**
     * 静态代码块随着类的加载只执行一次
     * 在静态代码块中读取配置文件，然后完成DBCP数据库连接池的创建
     * 这样一来就能和C3P0一样只创建一个数据库连接池
     */
    static {
        try {
//            读取配置文件
            Properties properties = new Properties();
            InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream("dbcp.properties");
            properties.load(stream);
//            工厂模式，因为BasicDataSource不提供读取配置文件造对象的方法
            DBCPDataSource = BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 跟上面的DBCPDataSource一样
     * 我们只想要一个数据库连接池
     */
    private static DataSource druidDataSource;

    static {
        try {
//            读取配置文件
            Properties properties = new Properties();
            InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
            properties.load(stream);

//            工厂模式，因为BasicDataSource不提供读取配置文件造对象的方法
            druidDataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用C3P0的数据库连接池技术获取连接
     * @return 返回连接
     * @throws SQLException
     */
    public static Connection getConnectionC3P0() throws SQLException {
        return cpds.getConnection();
    }

    /**
     * 使用DBCP的数据库连接池技术获取连接
     * @return
     * @throws Exception
     */
    public static Connection getConnectionDBCP() throws SQLException {
        return DBCPDataSource.getConnection();
    }

    /**
     * 使用Druid的数据库连接池技术获取连接
     * @return
     * @throws SQLException
     */
    public static Connection getConnectionDruid() throws SQLException {
        return druidDataSource.getConnection();
    }
}

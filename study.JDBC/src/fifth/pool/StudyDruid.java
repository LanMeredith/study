package fifth.pool;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * 德鲁伊数据库连接池技术
 * @author SeedList
 * @date: 2022.10.03
 */
public class StudyDruid {
    @Test
    public void testGetConnection() throws Exception {
//        读取配置文件
        Properties properties = new Properties();
        InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
        properties.load(stream);

//        工厂模式，因为BasicDataSource不提供读取配置文件造对象的方法
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}

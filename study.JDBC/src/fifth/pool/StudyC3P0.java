package fifth.pool;

import com.mchange.v2.c3p0.DataSources;
import org.junit.Test;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * C3P0数据库连接池技术
 * @author SeedList
 * @date: 2022.10.03
 */
public class StudyC3P0 {
    /**
     * 方式一
     * @throws PropertyVetoException
     * @throws SQLException
     */
    @Test
    public void testGetConnection() throws PropertyVetoException, SQLException {

//        获取C3P0数据库连接池
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass("com.mysql.jdbc.Driver");
        cpds.setJdbcUrl("jdbc:mysql://localhost:3306/study_jdbc?characterEncoding=UTF-8&rewriteBatchStatements=true");
        cpds.setUser("root");
        cpds.setPassword("study");

//        设置初始时数据库连接池中的连接数
        cpds.setInitialPoolSize(10);

        Connection connection = cpds.getConnection();
        System.out.println(connection);

//        销毁C3P0数据库连接池（一般情况下不做这个操作）
//        DataSources.destroy(cpds);
    }

    /**
     * 使用配置文件
     * 这里之所以没有读取配置文件的操作
     * 是因为C3P0的配置文件默认就叫c3p0-config.xml
     * 会自己去找这个对应的配置文件
     */
    @Test
    public void testGetConnectionUpgrade() throws SQLException {
        ComboPooledDataSource cpds = new ComboPooledDataSource("StudyC3P0");
        Connection connection = cpds.getConnection();
        System.out.println(connection);
    }
}

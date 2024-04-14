package util;

import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 在学习过程中，需要频繁的进行连接的关闭
 * 为了方便，将关闭操作封装到这个类当中
 *
 * @author shkstart
 * @date: 2022.09.28
 */
public class ShutMysql {
    /**
     * 资源的关闭
     *
     * @param connection
     * @param statement
     */
    public static void shutDown(Connection connection, Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * 资源的关闭二
     * 涉及到了查询操作，结果集ResultSet的关闭
     *
     * @param connection
     * @param statement
     */
    public static void shutDown(Connection connection, Statement statement, ResultSet resultSet) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * 使用dbutils.jar中提供的DbUtils工具类，实现资源的关闭
     * @param connection
     * @param statement
     * @param resultSet
     */
    public static void DbUtilsShutDown(Connection connection, Statement statement, ResultSet resultSet) {
//        无需判断是否为null，DbUtils.close()里判断了
        try {
            DbUtils.close(connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

//        无需判断是否为null，也无需try catch因为DbUtils.closeQuietly()里完成了
        DbUtils.closeQuietly(statement);
    }
}

package second.statement.blob;

import org.junit.Test;
import util.ReadMysql;
import util.ShutMysql;
import util.Universal;

import java.io.*;
import java.sql.*;

/**
 * @author shkstart
 * @date: 2022.10.01
 */
public class StudyBlob {
    /**
     * 对customers数据表添加一条记录，同时设置photo
     * 在数据表中photo是二进制大型对象
     * 一般来讲设置这种属性都是用流进行操作的
     * 所以这里使用了FileInputStream
     * 最后当然也要关闭资源
     */
    @Test
    public void insert() {
        String sql = "insert into customers(name,email,birth,photo) values(?,?,?,?)";
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File("src\\statement\\blob\\TitanFall.jpg"));
            Universal.update(sql, "颜铭鹤", "ymh@qq.com", "2000-06-24", inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 对blob类型的记录进行查询
     * 因为Universal的查询方法返回的是列表或单个对应的类的对象
     * 不能单独获取photo属性
     * 所以这里重复了查询操作
     * <p>
     * 对于blob类型的数据，通过流将其保存下来
     */
    @Test
    public void query() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        InputStream stream = null;
        FileOutputStream outputStream = null;
        try {
            connection = ReadMysql.read();
            String sql = "select name,photo from customers where id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, 21);

            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                System.out.println(name);

//                将Blob类型的字段下载下来，以文件的方式保存在本地
                Blob photo = resultSet.getBlob("photo");
                stream = photo.getBinaryStream();
                outputStream = new FileOutputStream("src\\statement\\blob\\queryTitanFall.jpg");
                byte[] buffer = new byte[1024];
                int len;
                while ((len = stream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, len);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            ShutMysql.shutDown(connection, statement, resultSet);
            if (statement != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

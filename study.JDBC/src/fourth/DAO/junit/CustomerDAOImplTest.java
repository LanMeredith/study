package fourth.DAO.junit;

import fourth.DAO.CustomerDAOImpl;
//import org.junit.jupiter.api.Test;
import org.junit.Test;
import queryResults.Customer;
import util.ReadMysql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 * @author shkstart
 * @date: 2022.10.02
 */
class CustomerDAOImplTest {

    CustomerDAOImpl dao = new CustomerDAOImpl();

    @Test
    void insert() {
        Connection connection = null;
        try {
            connection = ReadMysql.read();
            /*
             * 在这里虽然写明了id
             * 但是实际在执行添加操作的时候
             * customers数据表的id是主键自增的
             * 根本不用customer对象的id进行添加
             * */
            Customer customer = new Customer(1, "ymh", "123@qq.com", new Date(12345648978L));
            dao.insert(connection, customer);
            System.out.println("添加成功");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    @Test
    void deleteById() {
        Connection connection = null;
        try {
            connection = ReadMysql.read();
            dao.deleteById(connection, 23);
            System.out.println("删除成功");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    @Test
    void updateById() {
        Connection connection = null;
        try {
            connection = ReadMysql.read();
            Customer customer = new Customer(1, "ymh", "123@qq.com", new Date(12345648978L));
            dao.updateById(connection, customer);
            System.out.println("修改成功");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    @Test
    void getCustomerById() {
        Connection connection = null;
        try {
            connection = ReadMysql.read();
            Customer customer = dao.getCustomerById(connection, 1);
            System.out.println(customer);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    @Test
    void getAll() {
        Connection connection = null;
        try {
            connection = ReadMysql.read();
            List<Customer> list = dao.getAll(connection);

            for (Customer customer :
                    list) {
                System.out.println(customer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    @Test
    void getCount() {
        Connection connection = null;
        try {
            connection = ReadMysql.read();
            Long count = dao.getCount(connection);
            System.out.println(count);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    @Test
    void getMaxBirth() {
        Connection connection = null;
        try {
            connection = ReadMysql.read();
            Date birth = dao.getMaxBirth(connection);
            System.out.println(birth);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
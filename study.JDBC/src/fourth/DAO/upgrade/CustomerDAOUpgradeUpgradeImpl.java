package fourth.DAO.upgrade;

import queryResults.Customer;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * 具体实现的专针对于Customer数据表的操作方法
 * 想要操作其他的数据表，只要提供对应的专用的规范接口以及实现接口的操作类
 * <p>
 * 这个包下的三个类虽然在DAO大包下也有，但这是针对DAO大包下的升级操作
 *
 * @author shkstart
 * @date: 2022.10.02
 */
public class CustomerDAOUpgradeUpgradeImpl extends BaseDAOUpgrade<Customer> implements CustomerDAOUpgrade {

    @Override
    public void insert(Connection connection, Customer customer) {
        String sql = "insert into customers(name,email,birth) value (?,?,?)";
        update(connection, sql, customer.getName(), customer.getEmail(), customer.getBirth());
    }

    @Override
    public void deleteById(Connection connection, int id) {
        String sql = "delete from customers where id = ?";
        update(connection, sql, id);
    }

    @Override
    public void updateById(Connection connection, Customer customer) {
        String sql = "update customers set name = ?,email = ?,birth = ? where id = ?";
        update(connection, sql, customer.getName(), customer.getEmail(), customer.getBirth(), customer.getId());
    }

    /**
     * 在DAO大包中，aQuery方法调用传入了一个参数Customer.class
     * 而这是专门针对customers数据表的操作，再传入参数就有些多余了
     *
     * @param connection 连接
     * @param id         id
     * @return 查询结果
     */
    @Override
    public Customer getCustomerById(Connection connection, int id) {
        String sql = "select id,name,email,birth from customers where id = ?";
        Customer customer = aQuery(connection, sql, id);
        return customer;
    }

    @Override
    public List<Customer> getAll(Connection connection) {
        String sql = "select id,name,email,birth from customers";
        ArrayList<Customer> list = query(connection, sql);
        return list;
    }

    @Override
    public Long getCount(Connection connection) {
        String sql = "select count(*) from customers";
        return getValue(connection, sql);
    }

    @Override
    public Date getMaxBirth(Connection connection) {
        String sql = "select max(birth) from customers";
        return getValue(connection, sql);
    }
}

package fourth.DAO.upgrade;

import queryResults.Customer;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * 此接口用于规范针对于customers表的常用操作
 *
 * 这个包下的三个类虽然在DAO大包下也有，但这是针对DAO大包下的升级操作
 * @author shkstart
 * @date: 2022.10.02
 */
public interface CustomerDAOUpgrade {
    /**
     * 将customer对象添加到数据库中
     * @param connection 连接
     * @param customer 这是专用于customers数据表的操作
     */
    void insert(Connection connection, Customer customer);

    /**
     * 根据指定的ID删除表中的一条记录
     * @param connection 连接
     * @param id 指定的id
     */
    void deleteById(Connection connection, int id);

    /**
     * 针对于内存中的customer对象，去修改数据表中的记录
     *  @param connection 连接
     * @param customer 专用于customers表的操作
     */
    void updateById(Connection connection, Customer customer);

    /**
     * 针对指定的id查询得到对应的Customer对象
     * @param connection 连接
     * @param id id
     * @return 查询结果
     */
    Customer getCustomerById(Connection connection, int id);

    /**
     * 查询表中所有记录构成的集合
     * @param connection 连接
     * @return customers表的所有记录组成的列表
     */
    List<Customer> getAll(Connection connection);

    /**
     * 返回数据表中，数据的条目数
     * MySQL中，count()的返回值是Long类型的
     * @param connection 连接
     * @return 数目的条数
     */
    Long getCount(Connection connection);

    /**
     * 返回数据表中最大的生日
     * @param connection 连接
     * @return 时间
     */
    Date getMaxBirth(Connection connection);
}

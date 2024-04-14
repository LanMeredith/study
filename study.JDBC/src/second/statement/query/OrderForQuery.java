package second.statement.query;

import org.junit.Test;
import queryResults.Customer;
import queryResults.Order;
import util.Universal;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author shkstart
 * @date: 2022.09.30
 */
public class OrderForQuery {
    /**
     * 通过Universal的orderQuery方法查询
     */
    @Test
    public void testQueryOne() {
        /*
         * 因为order是关键字，所以需要用反引号包起来
         * 又因为数据库中order表中的列名和JAVA中的我写的Order类的属性名不能直接对应上，所以需要使用别名
         *
         * sql中取别名有两种方法
         * 列名 AS 别名
         * 列名 别名
         * 这里使用的第二种方法
         * */
        String sql = "select order_id orderId,order_name orderName,order_date orderDate from `order` where order_id = ?";
        ArrayList<Order> orders = Universal.orderQuery(sql, 1);

//        利用迭代器将列表中的内容输出
        Iterator<Order> iterator = orders.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     * 通过Universal的任意类通用方法查询
     */
    @Test
    public void testQueryTwo() {
        String sql = "select order_id orderId,order_name orderName,order_date orderDate from `order` where order_id < ?";
        ArrayList orderList = Universal.query(Order.class, sql, 12);

        Iterator iterator = orderList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

//        换个表也一样可以查询出对应的结果
        sql = "select id,name,email from customers where id = ? or id = ?";
        ArrayList customerList = Universal.query(Customer.class, sql, 3, 16);
        Iterator iteratorOne = customerList.iterator();
        while (iteratorOne.hasNext()) {
            System.out.println(iteratorOne.next());
        }
    }
}

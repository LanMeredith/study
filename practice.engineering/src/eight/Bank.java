package eight;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author shkstart
 * @create 2021-08-28-9:32
 */
public class Bank {
    private ArrayList<Customer> customers;
    private static Bank instance = new Bank();

    private Bank() {
        customers = new ArrayList(5);
    }

    /**
     * 单例模式的饿汉式
     */
    public static Bank getBanking() {
        return instance;
    }

    /*
     * 单例模式的懒汉式写法：
     * private static Bank instance = null;
     *
     * if(instance == null){
     *   synchronized(Bank.class){
     *       if(instance == null){
     *           instance = new Bank();
     *       }
     *   }
     * }
     * return instance;
     * */

    public void addCustomer(String firstName, String lastName) {
        Customer customer = new Customer(firstName, lastName);
        customers.add(customer);
    }

    public int size() {
        return customers.size();
    }

    public Customer get(int index) {
        return customers.get(index);
    }

    public Iterator getCustomers() {
        return customers.iterator();
    }
}

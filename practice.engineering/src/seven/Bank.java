package seven;

/**
 * @author shkstart
 * @create 2021-08-28-9:32
 */
public class Bank {
    private Customer[] customers;
    private int numberOfCustomer = 0;
    private static Bank instance = new Bank();

    private Bank() {
        this.customers = new Customer[5];
    }

//    单例模式的饿汉式
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
        customers[numberOfCustomer++] = customer;
    }

    public int  getNumOfCustomers() {
        return numberOfCustomer;
    }

    public Customer getCustomer(int index) {
        return customers[index];
    }
}

package six;

/**
 * @author shkstart
 * @create 2021-08-28-9:32
 */
public class Bank {
    private Customer[] customers;
    private int numberOfCustomer = 0;

    public Bank() {
        this.customers = new Customer[5];
    }

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

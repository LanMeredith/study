package eight;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author shkstart
 * @create 2021-08-24-22:15
 */
public class Customer {
    private String firstName;
    private String lastName;
    private ArrayList<Account> accounts;
    private int NumOfAccounts = 0;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        accounts = new ArrayList(5);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void add(Account account) {
        accounts.add(account);
    }

    public Account get(int index) {
        return accounts.get(index);
    }

    public int size() {
        return accounts.size();
    }

    public Iterator getAccounts() {
        return accounts.iterator();
    }
}

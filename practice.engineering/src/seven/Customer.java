package seven;

/**
 * @author shkstart
 * @create 2021-08-24-22:15
 */
public class Customer {
    private String firstName;
    private String lastName;
    private Account[] account;
    private int NumOfAccounts = 0;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        account = new Account[5];
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void addAccount(Account account) {
        this.account[NumOfAccounts++] = account;
    }

    public Account getAccount(int index) {
        return account[index];
    }

    public int getNumOfAccounts() {
        return NumOfAccounts;
    }
}

package six;

/**
 * @author shkstart
 * @create 2021-08-24-22:15
 */
public class Customer {
    private String firstName;
    private String lastName;
    private SavingsAccount savingAccount = null;
    private CheckingAccount checkingAccount = null;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Account getSaving() {
        return savingAccount;
    }

    public void setSaving(SavingsAccount savingAccount) {
        this.savingAccount = savingAccount;
    }

    public Account getChecking() {
        return checkingAccount;
    }

    public void setChecking(CheckingAccount checkingAccount) {
        this.checkingAccount = checkingAccount;
    }
}

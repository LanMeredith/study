package seven;

/**
 * @author shkstart
 * @create 2021-08-28-9:45
 */
public class SavingAccount extends Account {
    private double interestRate;

    public SavingAccount(double balance,double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }
}

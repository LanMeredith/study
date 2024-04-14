package six;

/**
 * @author shkstart
 * @create 2021-08-28-9:45
 */
public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }
}

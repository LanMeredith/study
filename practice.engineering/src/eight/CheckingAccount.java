package eight;

/**
 * @author shkstart
 * @create 2021-08-28-9:45
 */
public class CheckingAccount extends Account {
    private double overdraftProtection;

    /**
     * java中使用Math.abs来获取一个值的绝对值
     *
     * @param amt
     * @return
     */
    @Override
    public void withdraw(double amt) throws OverdraftException{
        if (amt > balance) {
            if (overdraftProtection < 0) {
                throw new OverdraftException("no overdraft protection");
            } else {
                if (overdraftProtection < Math.abs(balance - amt)) {
                    throw new OverdraftException("Insufficient funds for overdraft protection", amt - balance - overdraftProtection);
                } else {
                    overdraftProtection -= (amt - balance);
                    balance = 0;
                }
            }
        } else {
            balance -= amt;
        }
    }

    public CheckingAccount(double balance) {
        super(balance);
    }

    public CheckingAccount(double balance, double overdraftProtection) {
        super(balance);
        this.overdraftProtection = overdraftProtection;
    }
}

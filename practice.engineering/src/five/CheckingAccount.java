package five;

/**
 * @author shkstart
 * @create 2021-08-28-9:45
 */
public class CheckingAccount extends Account{
    private double  overdraftProtection;

    /**
     * java中使用Math.abs来获取一个值的绝对值
     * @param amt
     * @return
     */
    @Override
    public boolean withdraw(double amt) {
        if (amt > balance) {
            if (overdraftProtection > 0 && overdraftProtection > Math.abs(balance - amt)) {
                balance = 0;
                overdraftProtection -= (amt - balance);
                return true;
            } else {
                return false;
            }
        } else {
            balance -= amt;
            return true;
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

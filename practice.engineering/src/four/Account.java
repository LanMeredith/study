package four;

/**
 * @author shkstart
 * @create 2021-08-21-23:42
 */
public class Account {
    /**
     * 银行账户当前余额
     */
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    /**
     * 获取账户余额
     * @return balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * 加余额
     * @param amt
     */
    public boolean deposit(double amt) {
        balance += amt;
        return true;
    }

    /**
     * 减余额
     * @param amt
     */
    public boolean withdraw(double amt) {
        if (amt > balance) {
            return false;
        } else {
            balance -= amt;
            return true;
        }
    }
}

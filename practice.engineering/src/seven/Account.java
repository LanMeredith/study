package seven;

/**
 * @author shkstart
 * @create 2021-08-21-23:42
 */
public class Account {
    /**
     * 银行账户当前余额
     * protected对于子类，本包下的其他类可以随意使用，但是对于其他包下的类不允许使用
     */
    protected double balance;

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

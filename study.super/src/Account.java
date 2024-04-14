/**
 * @author SeedList
 * @package PACKAGE_NAME
 * @createTime 2023/6/17 20:17
 * @Description 写一个名为 Account 的类模拟账户。
 * 该类包括的属性：
 * 账号 id，余额 balance，年利率 annualInterestRate
 * 包含的方法：访问器方法（getter 和setter 方法）
 * 返回月利率的方法 getMonthlyInterest()，取款方法 withdraw()，存款方法deposit()
 */
public class Account {
    /**
     * id 账号
     * balance 余额
     * annualInterestRate 年利率
     */
    private int id;
    private double balance;
    private double annualInterestRate;

    public Account(int id, double balance, double annualInterestRate) {
        super();
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    /**
     * @param
     * @return double
     * @author SeedList
     * @createTime 2023/6/17 20:18
     * @Name getMonthlyInterest
     * @throw
     * @Description 返回月利率
     */
    public double getMonthlyInterest() {
        return annualInterestRate / 12;
    }

    /**
     * @param amount
     * @return void
     * @author SeedList
     * @createTime 2023/6/17 20:18
     * @Name withdraw
     * @throw
     * @Description 取款
     */
    public void withdraw(double amount) {
        balance = balance - amount;
    }

    /**
     * @param amount
     * @return void
     * @author SeedList
     * @createTime 2023/6/17 20:17
     * @Name deposit
     * @throw
     * @Description 存款
     */
    public void deposit(double amount) {
        balance = balance + amount;
    }
}

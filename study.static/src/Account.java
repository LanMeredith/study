/**
 * @author SeedList
 * @package PACKAGE_NAME
 * @createTime 2023/6/17 20:14
 * @Description 编写一个类实现银行账户的概念，包含的属性有“账号”
 * “密码”、“存款余额”、“利率”、“最小余额”，定义封装这些属性的方法。
 * 账号要求自动生成
 * 编写主类：使用银行账户，输入输出三个储户的上述信息。
 */
public class Account {
    /**
     * id 账号
     * password 密码
     * balance 存款余额
     * interestRate 利率
     * minMoney 最小余额
     * init 用于自动生成id使用的
     */
    private int id;
    private String password;
    private double balance;

    private static double interestRate;
    private static double minMoney = 1.0;
    private static int init = 1001;

    public Account() {
        id = init++;
    }

    public Account(String password, double balance) {
        this();
        this.password = password;
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interestRate) {
        Account.interestRate = interestRate;
    }

    public static double getMinMoney() {
        return minMoney;
    }

    public static void setMinMoney(double minMoney) {
        Account.minMoney = minMoney;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account [id=" + id + ", password=" + password + ", balance=" + balance + "]";
    }
}

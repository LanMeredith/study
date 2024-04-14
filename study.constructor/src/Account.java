/**
 * @author SeedList
 * @package PACKAGE_NAME
 * @createTime 2023/6/17 20:01
 * @Description 这里是构造方法的练习
 * 编写一个模拟账户
 */
public class Account {
    /**
     * id 账号
     * balance 余额
     * annuallnterestRate 年利率
     */
    private int id;
    private double balance;
    private double annuallnterestRate;

    public Account() {

    }

    public Account(int id, double balance, double annuallnterestRate) {
        this.id = id;
        this.balance = balance;
        this.annuallnterestRate = annuallnterestRate;
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

    public double getAnnuallnterestRate() {
        return annuallnterestRate;
    }

    public void setAnnuallnterestRate(double annuallnterestRate) {
        this.annuallnterestRate = annuallnterestRate;
    }

    /**
     * @param amount
     * @return void
     * @author SeedList
     * @createTime 2023/6/17 20:02
     * @Name withdraw
     * @throw
     * @Description 在提款方法withdraw中，需要判断用户余额是否能够满足提款数额的要求，如果不能，应给出提示
     */
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("当前账户：" + id);
            System.out.println("余额不足，提款失败！！！");
            System.out.println();
//            return关键字在此用于结束方法
            return;
        }
        balance -= amount;
        System.out.println("当前账户：" + id);
        System.out.println("成功取出：" + amount + "元");
        System.out.println("剩余余额：" + balance + "元");
        System.out.println();
    }

    /**
     * @param amount
     * @return void
     * @author SeedList
     * @createTime 2023/6/17 20:02
     * @Name deposit
     * @throw
     * @Description 存钱
     */
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("当前账户：" + id);
            System.out.println("成功存款：" + amount + "元，剩余余额：" + balance + "元");
            System.out.println();
        }
    }
}

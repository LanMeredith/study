/**
 * @author SeedList
 * @package PACKAGE_NAME
 * @createTime 2023/6/17 20:18
 * @Description 创建 Account类的一个子类 CheckAccount代表可透支的账户，
 * 该账户中定义一个属性overdraft代表可透支限额
 * 在 CheckAccount 类中重写 withdraw 方法，其算法如下：
 * 如果（取款金额<账户余额），
 * 可直接取款
 * 如果（取款金额>账户余额），
 * 计算需要透支的额度
 * 判断可透支额 overdraft 是否足够支付本次透支需要，如果可以
 * 将账户余额修改为 0，冲减可透支金额
 * 如果不可以
 * 提示用户超过可透支额的限额
 */
public class CheckAccount extends Account {
    private double overdraft;

    public CheckAccount(int id, double balance, double annualInterestRate, double overdraft) {
        super(id, balance, annualInterestRate);
        this.overdraft = overdraft;
    }

    /**
     * @param amount
     * @return void
     * @author SeedList
     * @createTime 2023/6/17 20:20
     * @Name withdraw
     * @throw
     * @Description 取款
     */
    @Override
    public void withdraw(double amount) {
        if (amount <= getBalance()) {
            super.withdraw(amount);
            System.out.println("您的账户当前余额：" + getBalance());
            System.out.println("您的可透支额：" + overdraft);
            System.out.println("——————————————————————————————");
        } else {
            if (overdraft >= amount - getBalance()) {
                overdraft = overdraft - (amount - getBalance());
                super.withdraw(getBalance());
                System.out.println("您的账户当前余额：" + getBalance());
                System.out.println("您的可透支额：" + overdraft);
                System.out.println("——————————————————————————————");
            } else {
                System.out.println("超出可透支额！");
                System.out.println("——————————————————————————————");
            }
        }
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }
}

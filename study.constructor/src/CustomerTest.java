/**
 * @author SeedList
 * @package PACKAGE_NAME
 * @createTime 2023/6/17 20:04
 * @Description 针对模拟账户编写一个测试程序
 * 一：创建一个Customer，名叫：Jane Smith，他有一个账户193056277，余额为2000元，年利率1.23%
 * 二：对Jane Smith操作：
 * 存入100元，再取出960元，再取出2000元
 * 打印Jane Smith的基本信息
 */
public class CustomerTest {
    public static void main(String[] args) {
        Customer cust = new Customer("Jane", "Smith");

        Account acct = new Account(193056277, 2000, 0.0123);

        cust.setAccount(acct);
//        先获取到账户，然后再调用存钱的方法，存入一百元
        cust.getAccount().deposit(100);
//        取出九百六
        cust.getAccount().withdraw(960);
//        取出两千元
        cust.getAccount().withdraw(2000);

        System.out.println("Customer[" + cust.getLastName() + "," + cust.getFirstName() + "] has a account: id is "
                + cust.getAccount().getId() + "annualInterestRate is " + cust.getAccount().getAnnuallnterestRate() * 100
                + "% , balance is " + cust.getAccount().getBalance());
    }
}

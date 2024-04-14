/*
 * This class creates the program to test the banking classes.
 * 这个类创建程序来测试银行类
 * It creates a new Bank, sets the Customer (with an initial balance),
 * 它创建一个新的银行，设置客户（具有初始余额）
 * and performs a series of transactions with the Account object.
 * 并使用 Account 对象执行一系列交易
 */
package four;


/**
 * @author Hasee
 */
public class TestBanking {

  public static void main(String[] args) {
    boolean results;

    System.out.println("Creating the customer Jane Smith.");
    Customer customer = new Customer("Jane", "Smith");

//     创建一个有 500.00 余额的帐户
    System.out.println("Creating her account with a 500.00 balance.");
    customer.setAccount(new Account(500));

//    提款 150.00
    results = customer.getAccount().withdraw(150);
    System.out.println("Withdraw 150.00 " + results);

//    存款 22.50
    results = customer.getAccount().deposit(22.5);
    System.out.println("Deposit 22.50 " + results);

//    提款 47.62
    results = customer.getAccount().withdraw(47.62);
    System.out.println("Withdraw 47.62 " + results);

//    提款 400
    results = customer.getAccount().withdraw(400);
    System.out.println("Withdraw 400 " + results);

//     打印出最终账户余额
    System.out.println("Customer [Smith, Jane] has a balance of " + customer.getAccount().getBalance());
  }
}

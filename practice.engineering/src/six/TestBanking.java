package six;
/*
 * This class creates the program to test the banking classes.
 * It creates a new Bank, sets the Customer (with an initial balance),
 * and performs a series of transactions with the Account object.
 * 这个类创建程序来测试银行类。它创建一个新的 Bank，设置 Customer（具有初始余额），并使用 Account 对象执行一系列交易。
 */

public class TestBanking {

    public static void main(String[] args) {
        Bank bank = new Bank();
        Customer customer;
        Account account;

        // Create two customers and their accounts
        bank.addCustomer("Jane", "Simms");
        customer = bank.getCustomer(0);
        customer.setSaving(new SavingsAccount(500.00, 0.05));
        customer.setChecking(new CheckingAccount(200.00, (SavingsAccount) customer.getSaving()));
        account = customer.getChecking();

        bank.addCustomer("Owen", "Bryant");
        customer = bank.getCustomer(1);
        customer.setChecking(new CheckingAccount(200.00));

        // Test the checking account of Jane Simms (with overdraft protection)      测试 Jane Simms 的支票账户（有透支保护）
        customer = bank.getCustomer(0);
        System.out.println("Customer [" + customer.getLastName()
                + ", " + customer.getFirstName() + "]"
                + " has a checking balance of "
                + customer.getChecking().getBalance()
                + " and a savings balance of "
                + customer.getSaving().getBalance());
        System.out.println("Checking Acct [Jane Simms] : withdraw 150.00 succeeds? "
                + account.withdraw(150.00));
        System.out.println("Checking Acct [Jane Simms] : deposit 22.50 succeeds? "
                + account.deposit(22.50));
        System.out.println("Checking Acct [Jane Simms] : withdraw 147.62 succeeds? "
                + account.withdraw(147.62));
        System.out.println("Customer [" + customer.getLastName()
                + ", " + customer.getFirstName() + "]"
                + " has a checking balance of "
                + account.getBalance()
                + " and a savings balance of "
                + customer.getSaving().getBalance());
        System.out.println();

        // Test the checking account of Owen Bryant (without overdraft protection)
        customer = bank.getCustomer(1);
        account = customer.getChecking();
        System.out.println("Customer [" + customer.getLastName()
                + ", " + customer.getFirstName() + "]"
                + " has a checking balance of "
                + account.getBalance());
        System.out.println("Checking Acct [Owen Bryant] : withdraw 100.00 succeeds? "
                + account.withdraw(100.00));
        System.out.println("Checking Acct [Owen Bryant] : deposit 25.00 succeeds? "
                + account.deposit(25.00));
        System.out.println("Checking Acct [Owen Bryant] : withdraw 175.00 succeeds? "
                + account.withdraw(175.00));
        System.out.println("Customer [" + customer.getLastName()
                + ", " + customer.getFirstName() + "]"
                + " has a checking balance of "
                + account.getBalance());
        System.out.println();
    }
}

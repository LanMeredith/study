package five;
/*
 * This class creates the program to test the banking classes.
 * It creates a set of customers, with a few accounts each,
 * and generates a report of current account balances.
 */

import java.text.NumberFormat;

public class TestBanking {

    public static void main(String[] args) {
        NumberFormat currency_format = NumberFormat.getCurrencyInstance();
        Bank bank = new Bank();
        Customer customer;

        // Create several customers and their accounts
        bank.addCustomer("Jane", "Simms");
        customer = bank.getCustomer(0);
        customer.addAccount(new SavingAccount(500.00, 0.05));
        customer.addAccount(new CheckingAccount(200.00, 400.00));

        bank.addCustomer("Owen", "Bryant");
        customer = bank.getCustomer(1);
        customer.addAccount(new CheckingAccount(200.00));

        bank.addCustomer("Tim", "Soley");
        customer = bank.getCustomer(2);
        customer.addAccount(new SavingAccount(1500.00, 0.05));
        customer.addAccount(new CheckingAccount(200.00));

        bank.addCustomer("Maria", "Soley");
        customer = bank.getCustomer(3);
        // Maria and Tim have a shared checking account     玛丽亚和蒂姆有一个共享的支票账户
        customer.addAccount(bank.getCustomer(2).getAccount(1));
        customer.addAccount(new SavingAccount(150.00, 0.05));

        // Generate a report    生成报告
        System.out.println("\t\t\tCUSTOMERS REPORT");
        System.out.println("\t\t\t================");

        for (int cust_idx = 0; cust_idx < bank.getNumOfCustomers(); cust_idx++) {
            customer = bank.getCustomer(cust_idx);

            System.out.println();
            System.out.println("Customer: "
                    + customer.getLastName() + ", "
                    + customer.getFirstName());

            for (int acct_idx = 0; acct_idx < customer.getNumOfAccounts(); acct_idx++) {
                Account account = customer.getAccount(acct_idx);
                String account_type = "";

//                Determine the account type        确定账户类型
                /*
                Step 1:
                Use the instanceof operator to test what type of account
                we have and set account_type to an appropriate value, such
                as "Savings Account" or "Checking Account".
                使用 instanceof 运算符测试我们拥有的帐户类型并将 account_type 设置为适当的值，
                例如“储蓄帐户”或“支票帐户”。
                */
                if (account instanceof SavingAccount) {
                    account_type = "Savings Account";
                } else {
                    account_type = "Checking Account";
                }

//                 Print the current balance of the account     打印当前账户余额
                /*
                Step 2:
                Print out the type of account and the balance.
                Feel free to use the currency_format formatter
                to generate a "currency string" for the balance.
                打印出账户类型和余额。随意使用货币格式格式化程序为余额生成“货币字符串”。
                */
                System.out.println(account_type + ": current balance is ￥" + account.getBalance());
            }
        }
    }
}

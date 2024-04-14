package seven;


/**
 * @author shkstart
 * @create 2021-08-28-14:45
 */
public class CustomerReport {
    public void generateReport() {
        Bank bank = Bank.getBanking();
        Customer customer;
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

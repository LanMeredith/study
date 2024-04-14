package eight;
/*
 * This class creates the program to test the banking classes.
 * It creates a set of customers, with a few accounts each,
 * and generates a report of current account balances.
 */

public class TestBanking {

    public static void main(String[] args) {
        Bank bank = Bank.getBanking();
        Customer customer;
        CustomerReport report = new CustomerReport();

        // Create several customers and their accounts
        bank.addCustomer("Jane", "Simms");
        customer = bank.get(0);
        customer.add(new SavingAccount(500.00, 0.05));
        customer.add(new CheckingAccount(200.00, 400.00));

        bank.addCustomer("Owen", "Bryant");
        customer = bank.get(1);
        customer.add(new CheckingAccount(200.00));

        bank.addCustomer("Tim", "Soley");
        customer = bank.get(2);
        customer.add(new SavingAccount(1500.00, 0.05));
        customer.add(new CheckingAccount(200.00));

        bank.addCustomer("Maria", "Soley");
        customer = bank.get(3);
        // Maria and Tim have a shared checking account
        customer.add(bank.get(2).get(1));
        customer.add(new SavingAccount(150.00, 0.05));

        // Generate a report
        report.generateReport();
    }
}

/**
 * @author SeedList
 * @package PACKAGE_NAME
 * @createTime 2023/6/17 20:16
 * @Description
 */
public class AccountTest {
    public static void main(String[] args) {
        Account a1 = new Account();
        Account a2 = new Account("password", 2000);
        System.out.println(a1);
        System.out.println(a2);

        Account.setInterestRate(0.034);
        Account.setMinMoney(100);
        System.out.println(a1.getInterestRate());
        System.out.println(a2.getInterestRate());
        System.out.println(a1.getMinMoney() == a2.getMinMoney());
    }
}

/**
 * @author SeedList
 * @package PACKAGE_NAME
 * @createTime 2023/6/17 20:04
 * @Description 这里是构造方法的练习
 * 编写一个模拟账户
 */
public class Customer {
    /**
     * firstName 姓
     * lastName 名
     */
    private String firstName;
    private String lastName;
    private Account account;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

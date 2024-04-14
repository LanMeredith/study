/**
 * @author SeedList
 * @package PACKAGE_NAME
 * @createTime 2023/6/17 20:04
 * @Description �����ǹ��췽������ϰ
 * ��дһ��ģ���˻�
 */
public class Customer {
    /**
     * firstName ��
     * lastName ��
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

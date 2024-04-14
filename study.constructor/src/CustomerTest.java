/**
 * @author SeedList
 * @package PACKAGE_NAME
 * @createTime 2023/6/17 20:04
 * @Description ���ģ���˻���дһ�����Գ���
 * һ������һ��Customer�����У�Jane Smith������һ���˻�193056277�����Ϊ2000Ԫ��������1.23%
 * ������Jane Smith������
 * ����100Ԫ����ȡ��960Ԫ����ȡ��2000Ԫ
 * ��ӡJane Smith�Ļ�����Ϣ
 */
public class CustomerTest {
    public static void main(String[] args) {
        Customer cust = new Customer("Jane", "Smith");

        Account acct = new Account(193056277, 2000, 0.0123);

        cust.setAccount(acct);
//        �Ȼ�ȡ���˻���Ȼ���ٵ��ô�Ǯ�ķ���������һ��Ԫ
        cust.getAccount().deposit(100);
//        ȡ���Ű���
        cust.getAccount().withdraw(960);
//        ȡ����ǧԪ
        cust.getAccount().withdraw(2000);

        System.out.println("Customer[" + cust.getLastName() + "," + cust.getFirstName() + "] has a account: id is "
                + cust.getAccount().getId() + "annualInterestRate is " + cust.getAccount().getAnnuallnterestRate() * 100
                + "% , balance is " + cust.getAccount().getBalance());
    }
}

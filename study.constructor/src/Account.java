/**
 * @author SeedList
 * @package PACKAGE_NAME
 * @createTime 2023/6/17 20:01
 * @Description �����ǹ��췽������ϰ
 * ��дһ��ģ���˻�
 */
public class Account {
    /**
     * id �˺�
     * balance ���
     * annuallnterestRate ������
     */
    private int id;
    private double balance;
    private double annuallnterestRate;

    public Account() {

    }

    public Account(int id, double balance, double annuallnterestRate) {
        this.id = id;
        this.balance = balance;
        this.annuallnterestRate = annuallnterestRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnuallnterestRate() {
        return annuallnterestRate;
    }

    public void setAnnuallnterestRate(double annuallnterestRate) {
        this.annuallnterestRate = annuallnterestRate;
    }

    /**
     * @param amount
     * @return void
     * @author SeedList
     * @createTime 2023/6/17 20:02
     * @Name withdraw
     * @throw
     * @Description ������withdraw�У���Ҫ�ж��û�����Ƿ��ܹ�������������Ҫ��������ܣ�Ӧ������ʾ
     */
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("��ǰ�˻���" + id);
            System.out.println("���㣬���ʧ�ܣ�����");
            System.out.println();
//            return�ؼ����ڴ����ڽ�������
            return;
        }
        balance -= amount;
        System.out.println("��ǰ�˻���" + id);
        System.out.println("�ɹ�ȡ����" + amount + "Ԫ");
        System.out.println("ʣ����" + balance + "Ԫ");
        System.out.println();
    }

    /**
     * @param amount
     * @return void
     * @author SeedList
     * @createTime 2023/6/17 20:02
     * @Name deposit
     * @throw
     * @Description ��Ǯ
     */
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("��ǰ�˻���" + id);
            System.out.println("�ɹ���" + amount + "Ԫ��ʣ����" + balance + "Ԫ");
            System.out.println();
        }
    }
}

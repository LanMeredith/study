/**
 * @author shkstart
 * @create 2022-09-07-8:56
 */
public class EmployeeTest {
    public static void main(String[] args) {
        Manager manager = new Manager("杨帆", 193056318, 1, 20000);
        manager.work();

        CommonEmployee ce = new CommonEmployee();
        ce.work();
    }
}

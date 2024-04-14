import java.util.Scanner;

/**
 * @author SeedList
 * @package PACKAGE_NAME
 * @createTime 2023/6/17 20:11
 * @Description
 */
public class EncapsulationTest {
    public static void main(String[] args) {
        System.out.println("请输入年龄：");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();

        Encapsulation b = new Encapsulation();
        b.setAge(i);
        System.out.println(b.getAge());
    }
}

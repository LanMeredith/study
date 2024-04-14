package practice.three;

import java.util.Scanner;

/**
 * 从键盘上输入一个整数值，并处理输入无效数值时产生的异常
 * @author shkstart
 * @create 2021-07-29-13:54
 */
public class ObtainInteger {
    public static void main(String[] args) {
        try {
            OI();
        } catch (InvalidValuesException e) {
            e.printStackTrace();
        }
    }

    public static void OI() throws InvalidValuesException {
        Scanner scanner = new Scanner(System.in);
        int i;
        if (scanner.hasNextInt()) {
            i = scanner.nextInt();
            System.out.println(i);
        } else {
            throw new InvalidValuesException("请不要输入无效字符");
        }
    }
}

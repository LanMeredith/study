package practice.two;

import java.util.Scanner;

/**
 * 创建类Computer，该类中有一个计算两个数的最大公约数的方法，如果向该方法传递负整数，该方法就会抛出自定义异常
 * @author shkstart
 * @create 2021-07-25-15:52
 */
public class Computer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个数值");
        int i = scanner.nextInt();
        System.out.println("请输入第二个数值");
        int j = scanner.nextInt();
        try {
            int result = common(i, j);
            System.out.println("这两个数的最大公约数是" + result);
        } catch (NegativeIntegerException e) {
            e.printStackTrace();
        }
    }

//    计算最大公约数的方法
    public static int common(int i, int j) throws NegativeIntegerException{
        if ((i < 0) || (j < 0)) {
            throw new NegativeIntegerException("不得传入负整数");
        }
        if (i > j) {
            int tmpe;
            tmpe = j;
            j = i;
            i = tmpe;
        }
//        最大公约数结果
        int result = 1;
        for (int k = 2; k < i; k++) {
            if ((i % k == 0) && (j % k == 0)) {
                result *= k;
                i /= k;
                j /= k;
            }
        }
        return result;
    }
}

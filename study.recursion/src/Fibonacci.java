import java.util.Scanner;

/**
 * 斐波那契数列
 * 一个数等于前两个数之和
 * 要求：计算斐波那契数列的第n个值，并将整个数列全部打印出来
 * @author shkstart
 * @date: 2022.09.12
 */
public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请问要求数列第几个位置的值");
        int i = scanner.nextInt();

        Fibonacci fibonacci = new Fibonacci();
        System.out.println("数列在第" + i + "个位置的值是：" + fibonacci.fibonacciTest(i));
        System.out.println("这是完整的数列：");
        fibonacci.fibonacciPrint(i);
    }

    /**
     * 计算数列在第i个位置的值
     * @param i
     * @return
     */
    public int fibonacciTest(int i) {
        if (i == 1) {
            return i;
        } else if (i == 2) {
            return 1;
        } else {
            return fibonacciTest(i - 1) + fibonacciTest(i - 2);
        }
    }

    /**
     * 打印数列
     * @param i
     */
    public void fibonacciPrint(int i) {
        for (int j = 0; j < i; j++) {
            System.out.print(fibonacciTest(j + 1) + "\t");
        }
    }
}

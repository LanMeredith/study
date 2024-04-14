package practice.four;

import java.util.Scanner;

/**
 * 写一个方法void triangle(int a, int b, int c)
 * 判断三个参数是否能构成一个三角形，若不能则抛出IllegalArgumentException异常
 * 显示异常信息“a,b,c不能构成三角形”
 * 如果可以则显示三角形的三个边长。
 * 在主方法中得到命令行输入的三个整数，调用此方法，并捕获异常
 * @author shkstart
 * @create 2021-07-29-14:29
 */
public class TriangleJudge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        triangle(a, b, c);
    }

    public static void triangle(int a, int b, int c) throws IllegalArgumentException{
        boolean isTriangle = (a + b > c) && (a + c > b) && (b + c > a);
        if (!isTriangle) {
            throw new IllegalArgumentException("a,b,c不能构成三角形");
        }
        System.out.println("a，b，c可以构成三角形");
    }
}

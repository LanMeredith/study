package practice;

/**
 * 已知有一个数列，f(0) = 1, f(1) = 4, f(n+2) = 2 * f(n+1) + f(n)
 * 其中n是大于零的正整数，求f(10)的值
 *
 * @author shkstart
 * @date: 2022.09.12
 */
public class One {
    public static void main(String[] args) {
        System.out.println(functionOne(10));
    }

    public static int functionOne(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 4;
        } else {
            return 2 * functionOne(n - 1) + functionOne(n - 2);
        }
    }
}

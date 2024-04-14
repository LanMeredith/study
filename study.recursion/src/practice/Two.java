package practice;

/**
 * 已知有一个数列，f(20) = 1, f(21) = 4, f(n+2) = 2 * f(n+1) + f(n)
 * 其中n是大于零的正整数，求f(10)的值
 * @author shkstart
 * @date: 2022.09.12
 */
public class Two {
    public static void main(String[] args) {
        System.out.println(functionTwo(10));
    }

    /**
     * 已知f(20)和f(21)的数
     * 递归要向已知方向进行
     * @param n
     * @return
     */
    public static int functionTwo(int n) {
        if (n == 21) {
            return 4;
        } else if (n == 20) {
            return 1;
        } else {
            return functionTwo(n + 2) - 2 * functionTwo(n + 1);
        }
    }
}

/**
 * 递归方法
 * 递归方法：在一个方法内部调用它本身
 * 方法递归包含了一种隐式的循环，它会重复执行某段代码，但这种重复执行无需循环控制
 * 递归一定要向已知方向递归，否则这种递归就会变成无穷递归，类似于死循环。
 * @author shkstart
 * @date: 2022.09.12
 */
public class Recursion {
    public static void main(String[] args) {
        int sum = GetSum(100);
        System.out.println(sum);
    }

    /**
     * 计算1-100之间所有整数的和
     * 在else的返回值中进行了递归
     * 第一次进行方法的时候，返回n_1=100，再有GetSum(n-1)的调用
     * 返回n_2=99，再有GetSum(n-1)的调用，直到n=1时返回1，就此终止
     * @param n
     * @return
     */
    public static int GetSum(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + GetSum(n - 1);
        }
    }
}

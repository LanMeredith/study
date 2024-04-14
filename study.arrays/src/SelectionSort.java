import java.util.Arrays;
import java.util.Scanner;

/**
 * @author SeedList
 * @package PACKAGE_NAME
 * @createTime 2023/6/17 19:58
 * @Description 数组的选择排序法
 */
public class SelectionSort {
    public static void main(String[] args) {
        System.out.print("n=");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

//        a数组的长度为n
        int[] a = new int[n];
        System.out.println("排序前");
        for (int i = 0; i < n; i++) {
//            产生0~100的随机数填充入a[i]的位置
            a[i] = (int) (Math.random() * 100);
            System.out.print(a[i] + "  ");
        }
        System.out.println();

//        最大值的位置
        int max;
//        n-1轮选择排序
        for (int i = 0; i < n - 1; i++) {
            max = 0;
            for (int j = 1; j < n - i; j++) {
                if (a[max] < a[j]) {
                    max = j;
                }
            }
//            如果a[max]不是这组数的中的最后一个，则与它交换
            if (max != n - 1 - i) {
                int tmpe = a[max];
                a[max] = a[n - 1 - i];
                a[n - 1 - i] = tmpe;
            }
        }
        System.out.println(Arrays.toString(a));
    }
}

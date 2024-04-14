package study.arraySort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 选择排序法
 * 从欲排序的数据中，按指定的规则找出某一元素
 * 再依照规定交换位置后达到排序的目的
 * 因为相较于冒泡排序法少了许多交换的过程，所以执行时间也少了许多
 * @author shkstart
 * @create 2021-11-01-21:41
 */
public class SelectiveSorting {
    public static void main(String[] args) {
//        生成指定长度的随机数,长度为len
        System.out.print("n=");
        Scanner sc = new Scanner(System.in);
        int[] a = new int[sc.nextInt()];
        int len = a.length;
        System.out.println("排序前");
        for (int i = 0; i < len; i++) {
//			产生0~100的随机数填充入a[i]的位置
            a[i] = (int) (Math.random() * 100);
            System.out.print(a[i] + "  ");
        }
        System.out.println();

//		最大值的位置
        int max;
//		n-1轮选择排序
        for (int i = 0; i < len - 1; i++) {
//            因此每次大循环后都需要在剩下的数中重新寻找最大值，所以需要让max归零
            max = 0;
//            在本次循环中，找出剩下的数中的最大值
            for (int j = 1; j < len - i; j++) {
                if (a[max] < a[j]) {
                    max = j;
                }
            }
//			如果a[max]不是这组数的中的最后一个，则与它交换，即为将最大值放在尾部
            if (max != len - 1 - i) {
                int tmpe = a[max];
                a[max] = a[len - 1 - i];
                a[len - 1 - i] = tmpe;
            }
        }
        System.out.println(Arrays.toString(a));
    }
}

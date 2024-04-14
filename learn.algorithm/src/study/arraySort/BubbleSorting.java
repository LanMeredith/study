package study.arraySort;

import java.util.Arrays;

/**
 * 冒泡排序法
 * @author shkstart
 * @create 2021-10-30-14:22
 */
public class BubbleSorting {
    public static void main(String[] args) {
        int[] arr = new int[]{34, 5, 22, -98, 6, -76, 0, -3, 9};
        boolean isFlag = true;

//			数组中一共有n个数字，使用冒泡排序需要排列n-1次
        for (int i = 0; i < arr.length - 1 && isFlag; i++) {
//            先假定本次大循环不会调序，即为序列有序，所以设置为false，若调序则更改为true，可进入下次大循环
            isFlag = false;
//				每一次排序时，一共要比较n-1次，又因为每一次排列都会让最大的元素排列到最后，所以只需要对剩下的元素进行排序
            for (int j = 0; j < arr.length - 1 - i; j++) {
//					比较n和n+1两个数
                if (arr[j] > arr[j + 1]) {
                    isFlag = true;
//					将较大的数给临时存放起来
                    int tmpe = arr[j];
//					将较小的数调整到n的位置
                    arr[j] = arr[j + 1];
//					临时存放的数调整到n+1的位置
                    arr[j + 1] = tmpe;
                }
            }
        }

        System.out.println("arr数组的排序为：");
        System.out.println(Arrays.toString(arr));
    }
}

package study.arraySort;

import java.util.Arrays;

/**
 * 插入排序
 * 需要进行n-1趟排序
 * 指针从1开始向后移动，每次循环需要用指针与前面的数据进行比较，找到合适的位置插入进去
 * 以[5,3,7,6]为例
 * 指针指向3，与前面的数比较，发现5更大，则让更大的数后延，然后让指针指向的数插入到相应的位置
 * 第一趟循环后[3,5,7,6]
 * 第二趟循环则指针指向7，用7与前面的数比较
 * 每趟循环，指针前的数都是排列好的，所以只要找到相应的位置插入进去即可
 * @author shkstart
 * @create 2021-11-01-21:48
 */
public class InsertionSorting {
    public static void main(String[] args) {
        int j;
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
//			产生0~100的随机数填充入a[i]的位置
            arr[i] = (int) (Math.random() * 100);
            System.out.print(arr[i] + "  ");
        }
        System.out.println();

//        指针从1开始后移
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
//            用指针指向的数与指针前的数比较，如[1,5,3]中3要插入到1和5中间，则让5后延
            for (j = i; j > 0 && temp < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
//            判断是否需要插入，若j!=i则表示指针指向的数不是最大的，要插入到指针前的数据中去
            if (j != i) {
                arr[j] = temp;
            }
        }

        System.out.println("arr数组的排序为：");
        System.out.println(Arrays.toString(arr));
    }
}

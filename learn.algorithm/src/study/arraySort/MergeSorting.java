package study.arraySort;

import java.util.Arrays;

/**
 * 归并排序是利用  归并  的思想实现的排序方法
 * 该算法采用了经典的  分治  策略
 * 分治法：将问题分成一些小的问题，然后递归求解
 * 而治的阶段则是将分的阶段得到的各答案“修补”在一起
 * 即分而治之
 *
 * 归并排序需要一个额外的空间，即用作中转的temp数组
 * @author shkstart
 * @create 2021-11-04-14:05
 */
public class MergeSorting {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 10, 8, 22, 21, 5, 12, 34, 28, 11};
//        归并排序要一个额外的空间，即用作中转的temp数组
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1,temp);

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 分+合方法
     * @param arr 原始数组
     * @param left 左索引
     * @param right 右索引
     * @param temp 中转数组
     */
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
//            左递归
            mergeSort(arr, left, mid, temp);
//            右递归
            mergeSort(arr, mid + 1, right, temp);
//            递归完成后进行合并
            merge(arr, left, mid, right, temp);
        }
    }

    /**
     * （一）先把左右两边（有序）的数据按照规则填充到temp数组直到左右两边的有序列表有一边处理完毕为止
     * （二）把剩余数据的一边的数据依次全部填充到temp
     * （三）将temp数组的元素拷贝到arr
     * notice：不是每次都会拷贝所有
     * @param arr
     * @param left
     * @param mid
     * @param right
     * @param temp
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;

//        （一）先把左右两边（有序）的数据按照规则填充到temp数组直到左右两边的有序列表有一边处理完毕为止
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }

//        （二）把剩余数据的一边的数据依次全部填充到temp
        while (i <= mid || j <= right) {
            if (i <= mid) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }

        /*
        将temp数组的元素拷贝到arr
        notice：不是每次都会拷贝所有
        explain：
        合并方法中进行的是“治”，合并的是被分成几组的数据
        上述代码中对两组数据进行了合并
        此时进行的是让合并后的结果对原数组相应的元素进行替换
        以两个元素合并成一组为例，这一组即temp中只有两个有效元素
        而arr原数组中有更多的元素个数，要找到相应的位置才可进行替换
        left就是操作元素在arr原数组中的初始索引，
         */
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft++] = temp[t++];
        }
    }
}

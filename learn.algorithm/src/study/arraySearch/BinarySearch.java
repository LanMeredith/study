package study.arraySearch;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 二分查找法
 * 前提要求是对有序数组进行操作
 *
 * （1）先得到该数组的中间下标
 * mid = (left + right) / 2
 *
 * （2）让要查找的数findVal与arr[mid]相比较
 * 如果findVal > arr[mid]则向右递归查找
 * findVal < arr[mid]则向左递归查找
 * 如果findVal = arr[mid]则向左右查找是否有其他相同的值
 * 若有其他相同的值，则添加到列表中
 * @author shkstart
 * @create 2021-11-05-17:34
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 5, 6, 7, 8, 9, 12, 45, 91, 108, 108, 108};
        ArrayList<Integer> list = new ArrayList<>();
        list = binary(arr, 0, arr.length - 1, 108, list);
        for (int i :
                list) {
            if (i == -1) {
                System.out.println("数组中无此元素");
            } else {
                System.out.println("该元素在数组中的位置是：" + i);
            }
        }
    }

    /**
     * 二分查找法
     * @param arr 原始数组
     * @param left 要索引部分头部
     * @param right 要索引部分尾部
     * @param findVal 要查找的值
     * @param list 返回的list列表，里面装的是查找结果
     * @return
     */
    public static ArrayList<Integer> binary(int[] arr, int left, int right, int findVal, ArrayList<Integer> list) {
        if (left > right || findVal < arr[left] || findVal > arr[right]) {
//            满足以上任一条件则表示数组中无此元素
            list.add(-1);
        } else {
//            中间值mid
            int mid = (left + right) / 2;

//            findVal大于arr[mid]则进行右递归，小于则左递归
            if (findVal > arr[mid]) {
                binary(arr, mid + 1, right, findVal, list);
            } else if (findVal < arr[mid]) {
                binary(arr, left, mid - 1, findVal, list);
            } else {
//                等于的话，向左右判断是否还有其他元素相等，若有则添加
                list.add(mid);
                for (int i = mid - 1; i > 0 && findVal == arr[i]; i--) {
                    list.add(i);
                }
                for (int i = mid + 1; i < arr.length && findVal == arr[i]; i++) {
                    list.add(i);
                }
            }
        }

//        对list进行升序排序然后再返回
        Collections.sort(list);
        return list;
    }
}

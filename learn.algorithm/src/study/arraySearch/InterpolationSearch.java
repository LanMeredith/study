package study.arraySearch;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 插值查找法
 * 和二分查找法大致是相同的，只不过插值查找对mid索引的分式进行了修改
 * mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
 *
 * notice：
 * （1）对于数据量较大，关键字分布比较均匀的查找表来说，采用插值查找速度更快
 * （2）关键字分布不均匀的情况下，该方法未必好于二分查找法
 * @author shkstart
 * @create 2021-11-05-18:28
 */
public class InterpolationSearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 5, 7, 8, 12, 45, 78, 123, 456, 789};
        ArrayList<Integer> list = new ArrayList<>();
        list = interpolation(arr, 0, arr.length - 1, 3, list);
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
     * 插值查找法
     * @param arr 原始数组
     * @param left 要索引部分头部
     * @param right 要索引部分尾部
     * @param findVal 要查找的值
     * @param list 返回的list列表，里面存储的是查找结果
     * @return
     */
    public static ArrayList<Integer> interpolation(int[] arr, int left, int right, int findVal, ArrayList<Integer> list) {
        if (left > right || findVal < arr[left] || findVal > arr[right]) {
//            满足以上任一条件则表示数组中无此元素
            list.add(-1);
        } else {
//            中间值mid
            int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);

//            findVal大于arr[mid]则进行右递归，小于则左递归
            if (findVal > arr[mid]) {
                interpolation(arr, mid + 1, right, findVal, list);
            } else if (findVal < arr[mid]) {
                interpolation(arr, left, mid - 1, findVal, list);
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

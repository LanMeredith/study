package study.arraySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 斐波那契查找法的递归实现
 *
 * @author shkstart
 * @create 2021-11-05-19:46
 */
public class FibonacciSearchRecursive {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 4, 5, 6, 6, 6, 7};
        int[] temp = tempArr(arr);
        int k = fibK(arr);
        int[] fib = fib(k);
        ArrayList<Integer> list = new ArrayList<>();
        list = fibonacci(temp, fib, k, 0, arr.length - 1, 6, list);
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
     * 得到斐波那契数数组
     * @param k 斐波那契数数组长度
     * @return 斐波那契数数组
     */
    public static int[] fib(int k) {
        int[] fibArr = new int[k];
        if (k == 1) {
            fibArr[0] = 1;
        } else if (k == 2) {
            fibArr[0] = 1;
            fibArr[1] = 1;
        } else {
            fibArr[0] = 1;
            fibArr[1] = 1;
            for (int i = 2; i < k; i++) {
                fibArr[i] = fibArr[i - 1] + fibArr[i - 2];
            }
        }
        return fibArr;
    }

    /**
     * @param k 指定位置
     * @return 斐波那契数数组在指定k位置上的值
     */
    public static int fibNum(int k) {
        if (k == 0 || k == 1) {
            return 1;
        } else {
            return fibNum(k - 1) + fibNum(k - 2);
        }
    }

    /**
     * 计算出k值，让fibNum(k)-1恰好大于或等于原始数组长度
     * 方便生成指定长度的斐波那契数数组
     * @param arr 原始数组
     * @return
     */
    public static int fibK(int[] arr) {
        int k = 0;
        while (arr.length - 1 > fibNum(k) - 1) {
            k++;
        }
        return k;
    }

    /**
     * 得到扩充后的临时数组
     * @param arr 原始数组
     * @return
     */
    public static int[] tempArr(int[] arr) {
//        首先得到k值
        int k = fibK(arr);
//        得到对应长度的斐波那契数组
        int[] fib = fib(k + 1);
//        得到原始数组的长度
        int len = arr.length;
//        创建一个长度为fib[k]的扩充数组temp
        int[] temp = Arrays.copyOf(arr, fib[k]);
        for (int i = len; i < temp.length; i++) {
            temp[i] = arr[len - 1];
        }
        return temp;
    }

    /**
     * 斐波那契查找法
     * @param temp 临时数组，我们将对临时数组进行操作
     * @param fib 斐波那契数数组
     * @param k 斐波那契分割数值的下标
     * @param left 要查找区域的左索引
     * @param right 要查找区域的右索引
     * @param findVal 要查找数组
     * @param list 用于存储查找结果
     * @return
     */
    public static ArrayList<Integer> fibonacci(int[] temp, int[] fib, int k, int left, int right, int findVal, ArrayList<Integer> list) {
//        如果满足其中任一条件，则表示数组中无此元素
        if (left > right || findVal < temp[left] || findVal > temp[right]) {
            list.add(-1);
        } else {
//            斐波那契查找法与二分查找法、插值查找法的区别在于mid
            int mid = left + fib[k - 1] - 1;
            if (findVal < temp[mid]) {
//            左递归
                fibonacci(temp, fib, --k, left, mid - 1, findVal, list);
            } else if (findVal > temp[mid]) {
//                右递归
                fibonacci(temp, fib, k - 2, mid + 1, right, findVal, list);
            } else {
//                如果找到了要查找值，则判断找到的位置mid是否超过了right
                if (mid <= right) {
//                    如果没超过，则需要向左向右查找是否有其他与findVal相等的元素
                    list.add(mid);
                    for (int i = mid - 1; i > 0 && findVal == temp[i]; i--) {
                        list.add(i);
                    }
                    for (int i = mid + 1; i < temp.length && findVal == temp[i]; i++) {
                        list.add(i);
                    }
                } else {
//                    如果超过了right，说明mid已经来到了原始数组的尾部，需要向左查找是否有其他与findVal相等的元素
                    list.add(right);
                    for (int i = right - 1; i > 0 && findVal == temp[i]; i--) {
                        list.add(i);
                    }
                }
            }
        }

        Collections.sort(list);
        return list;
    }
}

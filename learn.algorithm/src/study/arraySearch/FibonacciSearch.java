package study.arraySearch;

import java.util.Arrays;

/**
 * 斐波那契查找法
 * 原理和插值查找法、二分查找法相似
 * mid的位置改变，不再是中间值或者插值
 * 而是位于黄金分割点附近，即mid=left+fib[k-1]-1
 * @author shkstart
 * @create 2021-11-05-18:42
 */
public class FibonacciSearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 7, 9, 45, 120};
        int mid = fibonacci(arr, 0, arr.length - 1, 120);
        System.out.println(mid);
    }

    /**
     * 通过循环来完成斐波那契查找算法
     * @param arr 原始数组
     * @param left 要查找区间的左索引
     * @param right 要查找区间的右索引
     * @param findVal 要查找的数
     * @return
     */
    public static int fibonacci(int[] arr, int left, int right, int findVal) {
//        创建一个斐波那契数数组fib
        int[] fib = new int[20];
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i < 20; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        /*
        k是斐波那契数数组的脚标
        因为原始数组的长度不一定刚好等于fib[k]-1
        所以需要让数组长度增加至fib[k]-1
        这里k的值只要能使得fib[k]-1恰好大于或等于原始数组长度即可
         */
        int k = 0;
        while (arr.length - 1 > fib[k] - 1) {
            k++;
        }

        /*
        不建议直接对原始数组进行操作，从而创建一个临时数组进行扩大
        临时数组temp长度为fib[k]，不足的部分会用0填充
        将填充数改成arr[right]
         */
        int[] temp = Arrays.copyOf(arr, fib[k]);
        for (int i = right + 1; i < temp.length; i++) {
            temp[i] = arr[right];
        }

        /*
        对于斐波那契查找法，与二分查找法和插值查找法的区别点也在于mid
        斐波那契查找法的mid公式是mid = left + fib[k - 1] - 1
         */
        int mid = -1;
        while (left <= right && findVal >= temp[left] && findVal <= temp[right]) {
            mid = left + fib[k - 1] - 1;
//            左递归
            if (findVal < temp[mid]) {
                /*
                所有元素=前部分+mid+后部分
                fib[k] = fib[k - 1] + fib[k - 2]
                由于要查找的部位的长度改变了，所以斐波那契分隔数值的下标也要改变
                前部分的长度是fib[k-1]-1
                 */
                right = mid - 1;
                k--;
            } else if (findVal > temp[mid]) {
                /*
                右递归
                后部分的长度是fib[k-2]-1
                 */
                left = mid + 1;
                k -= 2;
            } else {
                /*
                如果是向右遍历的话，right就不会变化，仍然代表arr.length-1
                如果是向左遍历的话，那么无论如何都不会mid>arr.length-1的情况
                 */
                if (mid <= right) {
                    return mid;
                } else {
                    return right;
                }
            }
        }
        return mid;
    }
}

import java.util.Arrays;

/**
 * @author SeedList
 * @package PACKAGE_NAME
 * @createTime 2023/6/17 19:54
 * @Description 数组的快速排序方法, 其中用到了递归方法
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] data = {9, 265, 1254, 12, -152, 15, 0, -54, -45};
        System.out.println("排序前：" + Arrays.toString(data));
//        subsort(data,0,data.length-1);
//        直接调用quicksort方法
        quicksort(data);
        System.out.println("排序后：" + Arrays.toString(data));
    }

    public static void quicksort(int[] data) {
//        调用subsort方法
        subsort(data, 0, data.length - 1);
    }

    /**
     * @param data
     * @param start
     * @param end
     * @return void
     * @author SeedList
     * @createTime 2023/6/17 19:56
     * @Name subsort
     * @throw
     * @Description start是数组的开头下标，end是数组的结尾下标
     */
    private static void subsort(int[] data, int start, int end) {
        if (start < end) {
//            以数组下标为零的内容为标准，小于此的调整到左边，大于此的调整到右边
            int base = data[start];
//            从两端开始，这里是前端
            int low = start;
//            从两端开始，这里是后端
            int high = end + 1;
            while (low < high) {
                /*
                 * 前端数小于数组结尾下标，这样可以保证从前到后遍历整个数组
                 * 并且要数组下标low+1后减去base小于零（意为其小于或等于base）
                 * */
                while (low < end && data[++low] - base <= 0) {
                }

                /*
                 * 后端数大于数组开头下标，这样可以保证从后往前遍历整个数组
                 * 并且要求high-1后减去base大于等于零（意为其大于或等于base）
                 * */
                while (high > start && data[--high] - base >= 0) {
                }

                if (low < high) {
//                    进行调换后进行下一次循环
                    swap(data, low, high);
                }
            }
            swap(data, start, high);

//            递归调用
            subsort(data, start, high - 1);
            subsort(data, high + 1, end);
        }
    }

    /**
     * @param data
     * @param i
     * @param j
     * @return void
     * @author SeedList
     * @createTime 2023/6/17 19:55
     * @Name swap
     * @throw
     * @Description 方法的形参的传递机制：值传递
     * 一：形参：方法定义时，声明的小括号内的参数
     * 二：实参：调用一个方法时，实际传递给形参的值叫做实参
     * <p>
     * 值传递机制：
     * 如果参数使基本数据类型，此时实参给形参的是实参真实存储的数据值
     * 如果参数是引用数据类型，此时实参给形参的是实参存储数据的地址值
     */
    private static void swap(int[] data, int i, int j) {
        int tmpe = data[i];
        data[i] = data[j];
        data[j] = tmpe;
    }
}

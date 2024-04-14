package study.arraySort;

import java.util.Arrays;

/**
 * 快速排序法
 * 基本思想：
 * 通过一趟排序将要排序的数据分割成独立的两部分
 * 其中一部分的所有数据都比另外一部分的所有数据小
 * 然后再按此方法对这两部分数据分别进行快速排序
 * 整个排序过程可以递归进行，以此达到整个数据变成有序序列
 *
 * @author shkstart
 * @create 2021-11-03-13:00
 */
public class QuickSorting {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 10, 8, 22, 21, 5, 12, 34, 28, 11};
//        quickSortCentre(arr, 0, arr.length - 1);
        quickSoreStart(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 获取到要排序部分的头部start和尾部end
     * 我们将获取中间数作为基数
     */
    public static void quickSortCentre(int[] arr, int start, int end) {
        if (start < end) {
//            中间位置
            int centre = (start + end) / 2;
//            中间位置指向的基数
            int base = arr[centre];
//            左指针
            int left = start;
//            右指针
            int right = end;

//            循环的前提是左右指针不得交错,交错意味着分组完成
            while (left < right) {
//                左指针不得超过要排序部位的尾部,并且左指针指向的数据要小于或等于基数，每次循环左指针右移
                while (left <= end && arr[left] <= base) {
                    left++;
                }
//                右指针不得越过排序部位的头部，并且右指针指向的数据要大于或等于基数，每次循环右指针左移
                while (right >= start && arr[right] >= base) {
                    right--;
                }

//                如果左右指针没有发生交互，则意味着需要对他们指向的元素进行调换，以进一步完成分组
                if (left < right) {
                    int temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                }
            }

            /*
            循环结束意味着分组大致完成，但是要判断指向基数的centre是否大于right
            cause：
            以21 5 12 34这组数据为例，当centre指向21，right指向12，left指向34时，分组大致完成
            此时需要让centre指向的元素与right指向的元素互换
            互换结束后，还需要更新基数元素所在的位置，即为更新centre
            而以12 21 34这组数据威力，当centre指向21，right指向12，left指向34时，分组大致完成
            此时就不需要让centre指向的元素与right指向的元素互换
             */
            if (centre < right) {
                arr[centre] = arr[right];
                arr[right] = base;
                centre = right;
            }

            /*
            完成上述步骤后，centre往前都是比基数小的元素，往后都是比基数大的元素
            以start至centre-1为一组进行递归，以centre+1至end为一组进行递归
             */
            quickSortCentre(arr, start, centre - 1);
            quickSortCentre(arr, centre + 1, end);
        }
    }

    /**
     * 我们用数组的第一个元素作为基数
     * @param arr
     * @param start
     * @param end
     */
    public static void quickSoreStart(int[] arr, int start, int end) {
        if (start < end) {
            int number = arr[start];
            int left = start;
//            此处end+1是为了方便后续的--right
            int right = end + 1;

            while (left < right) {
                /*
                此处不可用<=或>=的原因在于其后的++left或--right
                当我们的left = end时，其后的arr[++left]就会出现数组脚标越界的问题
                 */
                while (left < end && arr[++left] <= number) { }
                while (right > start && arr[--right] >= number) { }

                if (left < right) {
                    int temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                }
            }

            arr[start] = arr[right];
            arr[right] = number;

            quickSoreStart(arr, start, right - 1);
            quickSoreStart(arr, right + 1, end);
        }
    }
}

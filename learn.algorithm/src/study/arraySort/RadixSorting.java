package study.arraySort;

import java.util.Arrays;

/**
 *基数排序
 * 基数排序属于“分配式排序”又称“桶子法”或bin sort
 * 顾名思义，它是通过键值的各个位的值
 * 将要排序的元素分配至某些“桶“中，达到排序的作用
 * <p>
 * 基数排序属于稳定性的排序，基数排序法是效率高的稳定性排序法
 * <p>
 * 基数排序是桶排序的扩展
 * <p>
 * 实现：
 * 将所有待比较数值统一为同样的数位长度
 * 数位较短的数前面补零，然后从最低位开始，依次进行一次排序
 * 这样从最低位排序一直到最高位排序完成以后，数列就变成一个有序序列
 * <p>
 * notice：
 * 基数排序是在用空间换时间，可能会因为数据太大而内存不足导致报错OutOfMemoryError
 * @author shkstart
 * @create 2021-11-04-22:25
 */
public class RadixSorting {
    public static void main(String[] args) {
        int[] arr = new int[]{2, -10, 8, 22, -21, 5, 12, 34, 28, -11};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void radixSort(int[] arr) {
        /*
        定义一个二维数组，表示十个桶，每个桶就是一个一维数组
        为了防止在放入数据的时候，发生数据溢出
        所以对每个一维数组（桶）大小定义成arr.length
        由此可见基数排序就是用空间换时间

        为了记录每个桶中实际存放了多少个数据
        我们定义了一个一维数组counts来记录各个桶的每次放入的数据的个数
        counts[0]记录的就是bucket[0]桶中存放的数据个数
         */
        int[][] bucket = new int[10][arr.length];
        int[] counts = new int[10];

        /*
        考虑到负数的情况，我们需要先得到最小数，然后让所有数都加上这个最小数的绝对值，即让最小数变为0
        通过遍历整个数组的方式获得到这个数组的最大值，再得到最大值的位数digits
         */
        int mintemp = 0;
        int maxtemp = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[maxtemp] < arr[i]) {
                maxtemp = i;
            }
            if (arr[mintemp] > arr[i]) {
                mintemp = i;
            }
        }
        int min = arr[mintemp];
        int max = arr[maxtemp];
        for (int i = 0; i < arr.length; i++) {
            arr[i] += Math.abs(min);
        }
        int digits = (max + "").length();

//        最大值有多少位，就执行多少次
        for (int i = 0, n = 1; i < digits; i++, n *= 10) {
//            让arr数组中的元素按规则存入桶中
            for (int j = 0; j < arr.length; j++) {
                /*
                定义digit来表示arr[j]在位数上的值
                我们以234为例，个位上为4，digit=4，十位上为3，digit=3
                通过计算可以发现个位数为arr[j] / 1 % 10
                十位数arr[j] / 10 % 10
                百位数arr[j] / 100 % 10
                改变的只有n，所以在第一层循环中添加一个n，n随着第一层循环而以十倍增
                _____________________________________________
                另一种思路是：
                将一个数据转换成字符串，通过charAt()获取指定位上的数
                234是一个三位数，str.length = 3
                当i为0时获取的是它的个位数，即为str.charAt(digits - i - 1)
                不过charAt()获取到的是字符，再通过Character.getNumericValue()转成数据类型
                如果这个数的位数小于最大数的数位
                以4为例，一位数明显小于三位数，那么在我们获取十位数时，将它的十位数视为0
                int digit;
                String str = arr[j] + "";
                if (str.length() > i) {
                    digit = Character.getNumericValue(str.charAt(str.length() - i - 1));
                } else {
                    digit = 0;
                }
                 */
                int digit = arr[j] / n % 10;

                /*
                digit得到的是该数的位数，也就是对应的桶
                counts[digit]表示这个桶中存储的元素个数
                数据存进桶里后，需要更新桶中存储的元素个数
                 */
                bucket[digit][counts[digit]] = arr[j];
                counts[digit]++;
            }

//            从桶中取数据，这是原数组arr的下标
            int index = 0;
            for (int j = 0; j < counts.length; j++) {
                if (counts[j] != 0) {
                    for (int k = 0; k < counts[j]; k++) {
                        arr[index++] = bucket[j][k];
                    }
                    counts[j] = 0;
                }
            }
        }

//        因为前面对所有数都加上了min的绝对值，所以现在要减去最小数的绝对值，恢复arr数组的原样
        for (int i = 0; i < arr.length; i++) {
            arr[i] -= Math.abs(min);
        }
    }
}

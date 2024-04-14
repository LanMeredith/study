import java.util.Arrays;

/**
 * @author SeedList
 * @package PACKAGE_NAME
 * @createTime 2023/6/17 19:49
 * @Description 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{34, 5, 22, -98, 6, -76, 0, -3, 9};
        int[] str = {32, 18, 23, 7, 15, 6, 2};
        boolean isFlag = true;

        /*
         * 冒泡排序法
         * 数组中一共有n个数字，使用冒泡排序需要排列n-1次
         * 每一次排序时，一共要比较n-1次，又因为每一次排列都会让最大的元素排列到最后，所以只需要对剩下的元素进行排序
         * 比较n和n+1两个数
         * 将较大的数给临时存放起来
         * 将较小的数调整到n的位置
         * 临时存放的数调整到n+1的位置
         * */
        for (int i = 0; i < arr.length - 1 && isFlag; i++) {
//            每一次排序时，一共要比较n-1次，又因为每一次排列都会让最大的元素排列到最后，所以只需要对剩下的元素进行排序
            for (int j = 0; j < arr.length - 1 - i; j++) {
                isFlag = false;
//					比较n和n+1两个数
                if (arr[j] > arr[j + 1]) {
                    isFlag = true;
//                    将较大的数给临时存放起来
                    int tmpe = arr[j];
//                    将较小的数调整到n的位置
                    arr[j] = arr[j + 1];
//					临时存放的数调整到n+1的位置
                    arr[j + 1] = tmpe;
                }
            }
        }

//        打印数组的方法一
        System.out.println("arr数组的排序为：");
        System.out.println(Arrays.toString(arr));
//        打印数组的方法二：无法直接打印出一个数组，设置循环，将数组中的数一个个打印出来
        for (int k = 0; k < arr.length; k++) {
//            “\t"是指tab
            System.out.print(arr[k] + "\t");
        }
        System.out.println();

        /*
         * 反转上面的数组arr，需要新建一个数组，方法一：
         * 设置一个新的数组，长度等于arr数组的长度
         * 这里是不需要对arr数组长度进行减一的
         * */
        int[] arr_2 = new int[arr.length];
//        这里是不需要对arr数组长度进行减一的
        for (int x = 0; x < arr.length; x++) {
            arr_2[arr.length - 1 - x] = arr[x];
        }
        System.out.println("arr_2数组的内容为：");
        System.out.println(Arrays.toString(arr_2));

        /*
         * 反转上面的数组arr，不需要新建数组，方法二：
         * 先将前一位置内容储存入tmpe中
         * 将前一位置内容替换成末一位置内容
         * 再用tmpe替换了末一位置内容
         * */
        for (int z = 0; z < arr.length / 2; z++) {
//            先将前一位置内容储存入tmpe中
            int tmpe = arr[z];
//            将前一位置内容替换成末一位置内容
            arr[z] = arr[arr.length - 1 - z];
//            再用tmpe替换了末一位置内容
            arr[arr.length - 1 - z] = tmpe;
        }
        System.out.println("此时可见arr数组的内容为：");
        System.out.println(Arrays.toString(arr));

        /*
         * 使用Arrays.sort方法实现排序
         * */
        Arrays.sort(str);
        System.out.println("str数组的排序为：");
        System.out.println(Arrays.toString(str));
    }
}

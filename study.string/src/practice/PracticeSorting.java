package practice;

import java.util.Arrays;

/**
 * 对字符串中字符进行自然顺序排序。
 * 提示：
 * 1）字符串变成字符数组。
 * 2）对数组排序，选择，冒泡，Arrays.sort();
 * 3）将排序后的数组变成字符串。
 * @author shkstart
 * @create 2021-01-12-18:26
 */
public class PracticeSorting {
    public static void main(String[] args) {
        String str_1 = "我是中国人";
        String str_2 = "我爱中国";
        String str_3 = "我为我身为一个中国人而感到自豪";
        String str_4 = "诡秘之主";
        char[] arr_1 = str_1.toCharArray();
        char[] arr_2 = str_2.toCharArray();
        char[] arr_3 = str_3.toCharArray();
        char[] arr_4 = str_4.toCharArray();
        System.out.println(BubbleSort(arr_1));
        System.out.println(SelectiveSortingMethod(arr_2));
        System.out.println(QuicksortMethod(arr_3,0, arr_3.length-1));
        Arrays.sort(arr_4);
        System.out.println(arr_4);
    }


//    冒泡排序法
    public static char[] BubbleSort(char[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    char tmpe = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmpe;
                }
            }
        }
        return arr;
    }

    //    选择排序法
    public static char[] SelectiveSortingMethod(char[] arr) {
        int max;
        for (int i = 0; i < arr.length - 1; i++) {
            max = 0;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[max] < arr[j]) {
                    max = j;
                }
            }
            if (max != arr.length - 1 - i) {
                char tmpe = arr[max];
                arr[max] = arr[arr.length - 1 - i];
                arr[arr.length - 1 - i] = arr[max];
            }
        }
        return arr;
    }

    //    快速排序法
    public static char[] QuicksortMethod(char[] arr, int start, int end) {
        if(start < end){
            char base = arr[start];
            int low = start;
            int high = end + 1;
            while(true){
                while(low < end && arr[++low] - base <= 0);
                while(high > start && arr[--high] - base >= 0);
                if(low < high) {
                    char tmpe = arr[low];
                    arr[low] = arr[high];
                    arr[high] = tmpe;
                }else {
                    break;
                }
            }
            char tmpe = arr[start];
            arr[start] = arr[high];
            arr[high] = tmpe;
            QuicksortMethod(arr, start, high -1);
            QuicksortMethod(arr, high + 1, end);
        }
        return arr;
    }
}

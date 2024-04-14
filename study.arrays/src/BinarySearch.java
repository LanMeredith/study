import java.util.Arrays;
import java.util.Scanner;

/**
 * @author SeedList
 * @package 
 * @createTime 2023/6/17 19:48
 * @Description 二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] data = {789, 321, 567, 432, 345, 543, 123546};

        Arrays.sort(data);
        System.out.println("排序过后data数组：" + Arrays.toString(data));

//        定义一个头值，定义一个尾值，尾值是数组长度减一，因为数组下标从零开始
        int button = 0;
        int top = data.length - 1;
        System.out.println("请输入要查找的值：");
        Scanner temp = new Scanner(System.in);
//        要输入的值赋值给number
        int number = temp.nextInt();
//        这是中间值
        int mid;

        while (button <= top) {
//            每次循环先求出新首尾的中间值
            mid = (button + top) / 2;
            if (data[mid] == number) {
                System.out.println("已找到，在" + mid + "位置");
                break;
            } else if (data[mid] < number) {
//                如果要查找值大于中间值的话，那么将首位定在中间值往后的一个位置
                button = mid + 1;
            } else {
//                如果要查找值小于中间值的话，那么将尾位定在中间值往前一个位置
                top = mid - 1;
            }
        }

//        如果没有找到的话，那么在剩下最后一个值的时候，首位会比中间值更大，尾位会比中间值更小，如此一来首位就要大于尾位
        if (top < button) {
            System.out.println("未找到");
        }
    }
}

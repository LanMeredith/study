package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 请从键盘随机输入十个整数，并按照倒序从大到小的顺序显示出来
 * @author shkstart
 * @create 2021-01-27-15:50
 */
public class Three {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            int j = sc.nextInt();
            list.add(j);
        }
        Collections.sort(list);
        Collections.reverse(list);
        System.out.println(list);
    }
}

package practice;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 写出使用Iterator 和 增强for 循环遍历List<String>的代码,使用上泛型
 * @author shkstart
 * @create 2021-02-08-18:57
 */
public class Six {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("徐隆威");
        list.add("邓金亮");
        list.add("杨帆");
        list.add("颜铭鹤");
        list.add("袁经睿");
        list.add("谢传鹏");

        System.out.println("使用增强for循环遍历");
        for (String str:
             list) {
            System.out.println(str);
        }

        System.out.println();
        System.out.println("使用Iterator循环遍历");
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

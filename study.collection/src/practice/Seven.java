package practice;

import java.util.*;

/**
 * 提供一个方法，用于遍历获取HashMap<String,String>中的所有value，并存放在List中返回。考虑上集合中泛型的使用
 * @author shkstart
 * @create 2021-02-08-19:04
 */
public class Seven {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("一号床","徐隆威");
        map.put("二号床","邓金亮");
        map.put("三号床","杨帆");
        map.put("四号床","颜铭鹤");
        map.put("五号床","袁经睿");
        map.put("六号床","谢传鹏");

        List<String> list = traverse(map);

        System.out.println("验证返回的List");

        for (String str :
                list) {
            System.out.println(str);
        }
    }

    public static List<String> traverse(Map<String,String> map){
        System.out.println("遍历Map的value集");
        Collection<String> values = map.values();
        ArrayList<String> list = new ArrayList<>();
        for (String i:
                values) {
            System.out.println(i);
            list.add(i);
        }
        return list;
    }
}

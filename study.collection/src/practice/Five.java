package practice;

import java.util.*;

/**
 * 如何遍历Map的key集，value集,key-value集，使用上泛型
 * @author shkstart
 * @create 2021-02-08-18:27
 */
public class Five {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"徐隆威");
        map.put(2,"邓金亮");
        map.put(3,"杨帆");
        map.put(4,"颜铭鹤");
        map.put(5,"袁经睿");
        map.put(6,"谢传鹏");

        System.out.println("遍历Map的key集");
        Set<Integer> keySet = map.keySet();
        for (int i:
             keySet) {
            System.out.println(i);
        }

        /*
        方式二
        Iterator<Integer> iterator = keySet.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        */

        System.out.println("遍历Map的value集");
        Collection<String> values = map.values();
        for (String i:
             values) {
            System.out.println(i);
        }

        /*
        Iterator<String> iterator = values.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        */

        System.out.println("遍历Map的key-value集");
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for (Map.Entry<Integer,String> i:
             entries) {
            System.out.println(i.getKey() + "-" + i.getValue());
        }
        /*
        Iterator<Map.Entry<Integer, String>> iterator = entries.iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer,String> entry = iterator.next();
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }


        for (int i:
                keySet) {
            System.out.println(i + "-" + map.get(i));
        }


        Iterator<Integer> iterator = keySet.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next() + "-" + map.get(iterator.next());
        }
        */
    }
}

package practice;

import org.junit.Test;

import java.util.ArrayList;

/**
 * 小小的面试题
 * 区分List和Collection中的remove()方法
 * @author shkstart
 * @create 2021-01-20-14:32
 */
public class One {
    @Test
    public void test(){
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);
    }

    private static void updateList(ArrayList list){
//        这里调用的是这个Object remove(int index)移除指定index位置的元素并返回此元素
        list.remove(2);
//        若是想删除元素2，则按照如下写
        list.remove(new Integer(2));
    }
}

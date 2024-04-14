import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * JDK5.0提供了foreach循环迭代访问Collection和数组
 * @author shkstart
 * @create 2021-01-19-20:16
 */
public class StudyForeach {
    /**
     * 遍历集合
     */
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add("颜铭鹤");
        coll.add(193056277);
        coll.add("2000-07-25");
        coll.add(new Date());
        coll.add("加油");

//        for(集合元素的类型 局部变量 : 集合对象)
//        内部仍然调用了迭代器
        for(Object obj : coll){
            System.out.println(obj);
        }
    }

    /**
     * 遍历数组
     */
     @Test
    public void test2(){
        int[] arr = new int[]{1,2,1,2,2,1,2,1,5};
        for(int i : arr) {
            System.out.println(i);
        }
     }

    /**
     * 练习题
     */
    @Test
    public void test3(){
        String[] arr = new String[]{"GG","GG","GG"};
        for (String i : arr){
            i = "MM";
        }
        for (String i : arr){
            System.out.println(i);
        }
    }
}

import org.junit.Test;

import java.util.*;

/**
 * Collections是操作Set、List和Map等集合的工具类
 * test1是常用方法
 * test2是同步控制
 * <p>
 * 面试题：Collection和Collections的区别？
 *
 * @author shkstart
 * @create 2021-01-27-13:58
 */
public class StuduCollections {
    @Test
    public void test1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("颜铭鹤");
        arrayList.add("大数据1902班");
        arrayList.add(193056277);
        arrayList.add(new Date());
        System.out.println(arrayList);
        System.out.println();

//        reverse(List)反转List中元素的顺序
        Collections.reverse(arrayList);
        System.out.println(arrayList);
        System.out.println();

//        shuffle(List)对List集合元素进行随机排序
        Collections.shuffle(arrayList);
        System.out.println(arrayList);
        System.out.println();

//        sort(List)根据元素的自然顺序对指定List集合元素按升序排序
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(312);
        list.add(321);
        list.add(213);
        list.add(231);
        list.add(132);
        Collections.sort(list);
        System.out.println(list);
        System.out.println();

//        sort(List,Comparator)根据指定的Comparator产生的顺序对List集合元素进行排序
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2){
                if(o1 instanceof Integer && o2 instanceof Integer){
                    Integer i1 = (Integer) o1;
                    Integer i2 = (Integer) o2;
                    return -i1.compareTo(i2);
                }
                throw new RuntimeException("传入的数据类型不一致！");
            }
        });
        System.out.println(list);
        System.out.println();

//        swap(List,int i,int j)将指定List集合中的i处元素和j处元素进行交换
        Collections.swap(arrayList,3,1);
        System.out.println(arrayList);
        System.out.println();

//        Object max(Collection)根据元素的自然顺序，返回给定集合中的最大元素
//        Object max(Collection,Comparator)根据Comparator给定的顺序，返回给定集合中最大的元素
        System.out.println(Collections.max(list));
        System.out.println();

//        Object min(Collection)
//        Object min(Collection,Comparator)
        System.out.println(Collections.min(list));
        System.out.println();

//        int frequency(Collection,Object)返回指定集合中，指定元素的出现次数
        System.out.println(Collections.frequency(list, 123));
        System.out.println();

//        void copy(List dest,List src)将src中的内容复制到dest
        /*
        会出现异常：IndexOutOfBoundsException("Source does not fit in dest")
        要求：dest长度不可小于src长度
        Collections.copy(arrayList,list);
        */
        List dest = Arrays.asList(new Object[list.size()]);
        Collections.copy(dest,list);
        System.out.println(dest);
        System.out.println();

//        boolean replaceAll(List list,Object oldVal,Object newVal)使用新值替换List对应对象的所有旧值
        Collections.replaceAll(dest,123,567);
        System.out.println(dest);
        System.out.println();
    }

    @Test
    public void test2(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(312);
        list.add(321);
        list.add(213);
        list.add(231);
        list.add(132);

        /*
        Collection类中提供多个synchronizedXXX()方法
        该方法可以使将指定集合包装成线程同步的集合，从而可以解决多线程并发访问集合时的线程安全问题
         */
//        返回的list1即为线程安全的list
        List list1 = Collections.synchronizedList(list);
    }
}

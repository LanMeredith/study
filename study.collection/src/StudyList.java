import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 1.List接口框架
 * Collection接口：单列集合，用来存储一个一个的对象
 * -->List接口，存储有序的、可重复的数据。-->“动态”数组，替换原有的数组
 * 常用的实现类：
 * ArrayList：作为List接口的主要实现类；线程不安全的，效率高；底层使用Object[] elementDate存储
 * LinkedList：对于频繁的增加、删除操作，使用此类效率比ArrayList高；底层使用双向链表存储
 * Vector：作为List接口的古老实现类；线程安全的，效率低；底层使用Object[] elementDate存储
 *
 * 2.ArrayList的源码分析，JDK7和JDK8版本源码有所不同
 * 2.1JDK7版本源码分析：
 * ArrayList list = new ArrayList();//底层创建了长度是10的Object[]数组elementDate
 * list.add(123);//elementDate[0] = new Integer(123);
 * ...
 * list.add(11);//如果此次添加导致底层elementDate数组容量不够，则进行扩容
 * 默认情况下，扩容为原来容量的1.5倍，同时需要将原有数组中的数据复制到新的数组中

 * 结论：建议开发中使用带参的构造器：ArrayList list = new ArrayList(int capacity)
 *
 * 2.2JDK8版本源码分析：
 * ArrayList list = new ArrayList();//底层Object[] elementDate初始化为{}，并没有创建长度为10的数组
 * list.add(123);//第一次调用add()时，底层才创建了长度为10的数组，并将123添加到elementDate[0]
 * ...
 * 后续的添加和扩容操作和JDK7无异。
 *
 * 2.3小结：
 * JDK7中的ArrayList的对象的创建类似于单例模式中的饿汉式，而JDK8中的ArrayList的对象的创建类似于单例模式中的懒汉式
 *
 *3.LinkedList的源码分析：
 * LinkedList link = new LinkedList();//内部声明了Node类型的first和last属性，默认值为null
 * link.add(123);//将123封装到Node中，创建了Node对象
 * 其中Node定义为：体现了LinkedList的双向链表的说法
 * private static class Node<E>{
 *     E item;
 *     Node<E> next;
 *     Node<E> prev;
 *
 *     Node(Node<E> prev, E element, Node<E> next){
 *          this.item = element;
 *          this.next = next;
 *          this.prev = prev;
 *     }
 * }
 *
 * 4.Vector的源码分析：JDK7和JDK8中通过Vector()构造器创建对象时，底层都创建了长度为10的数组
 * 在扩容方面，默认扩容为原来的数组长度的两倍
 *
 * 面试题：ArrayList、LinkedList和Vector的异同？
 * 同：三个类都实现了List接口，存储数据的特点相同：存储有序的，可重复的数据。
 * 不同：见上
 * @author shkstart
 * @create 2021-01-20-12:35
 */
public class StudyList {
    /**
     * List接口常用方法
     */
    @Test
    public void test1(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("颜铭鹤");
        arrayList.add("大数据1902班");
        arrayList.add(193056277);
        arrayList.add(new Date());

//        void add(int index, Object element)在index位置插入新元素element
        arrayList.add(1,"2019-9");
        System.out.println(arrayList);

        ArrayList list = new ArrayList();
        list.add("第一次测试");
        list.add("第二次测试");
        list.add("第三次测试");
//        boolean addAll(int index, Collection eles)从index位置开始将eles中的所有元素添加进来
        arrayList.addAll(0,list);
        System.out.println(arrayList);

//        Object get(int index)获取指定index位置的元素
        System.out.println(arrayList.get(5));

//        int indexOf(Object obj)返回obj在集合中首次出现的位置，如果不存在，则返回-1
        System.out.println(arrayList.indexOf("颜铭鹤"));
        System.out.println(arrayList.indexOf(new Date()));

//        int lastIndexOf(Object obj)返回obj在当前集合中末次出现的位置，如果不存在，则返回-1
        System.out.println(arrayList.lastIndexOf("第三次测试"));
        arrayList.add("第三次测试");
        System.out.println(arrayList.lastIndexOf("第三次测试"));

//        Object remove(int index)移除指定index位置的元素并返回此元素
        System.out.println(arrayList);
        System.out.println(arrayList.remove(8));
        System.out.println(arrayList);

//        Object set(int index,Object ele)设置指定index位置的元素为ele
        arrayList.set(2,"测试");
        System.out.println(arrayList);

//        List subList(int fromIndex,int toIndex)返回从fromIndex到toIndex位置（不包含toIndex）的子集合
        List sonlist = arrayList.subList(3,7);
        System.out.println(sonlist);
    }
}

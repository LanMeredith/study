import org.junit.Test;

import java.util.*;

/**
 * 集合框架的概述：
 * <p>
 * 1.集合、数组都是对多个数据进行存储操作的结构，简称java容器
 * 说明：此时的存储主要是指内存层次的存储，不涉及到持久化的存储
 * <p>
 * 2.1数组在存储多个数据方面的特点
 * 一旦初始化以后，其长度就确定了
 * 数组一旦定义好，其元素的类型也就确定了，我们也就只能操作指定类型的数据了
 * <p>
 * 2.2数组在存储多个数据方面的缺点
 * 一旦初始化以后，其长度就不可修改
 * 数组中提供的方法非常有限，对于添加、删除、插入数据等操作，非常不便，同时效率不高
 * 获取数组中实际元素的个数的需求，数组没有现成的属性或方法可用
 * 数组存储数据的特点：有序、可重复。对无序、不可重复的需求，不可满足
 * <p>
 * 二：集合框架
 * /---Collection接口：单列集合，用来存储一个一个的对象
 * /---List接口：存储有序的，可重复的数据     =>“动态”数组
 * /---Set接口：存储无序的，不可重复的数据    =>高中讲的“集合”
 * <p>
 * /---Map接口：双列集合，用来存储一对(key -- value)一对的数据    =>高中函数
 *
 * @author shkstart
 * @create 2021-01-19-13:19
 */
public class StudyCollection {
    @Test
    public void test1() {
        Collection coll = new ArrayList();

//        add(Object e)：将元素e添加到集合coll中
        coll.add("abc");
//        自动装箱
        coll.add(123);
        coll.add(new Date());

//        size()获取添加的元素的个数
        System.out.println(coll.size());
        System.out.println(coll);

//        add(Collection e)：将e集合中的元素添加到当前集合中
        Collection coll1 = new ArrayList();
        coll1.add("QWER");
        coll1.add(789);
        coll.addAll(coll1);
        System.out.println(coll.size());
        System.out.println(coll);

//        isEmpty()：判断当前集合是否为空
        System.out.println(coll.isEmpty());

//        hashCode()：返回当前对象的哈希值
        System.out.println(coll.hashCode());

//        toArray()：集合转为数组
        Object[] array = coll.toArray();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

//        扩展：数组转为集合：调用Arrays类的静态方法asList()
        List<String> strings = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(strings);
//        注意！！！
//        在这里会认为只有一个元素
        List<int[]> ints = Arrays.asList(new int[]{123, 456});
        System.out.println(ints);
//        要么这样写
        List ints1 = Arrays.asList(123, 456);
        System.out.println(ints1);
//        或者使用包装类
        List ints2 = Arrays.asList(new Integer[]{123, 456});
        System.out.println(ints2);

//        clear()：清空集合元素，集合中的元素全被重新赋值为null了，此时调用isEmpty会是true，但不会出现空指针异常
        coll.clear();
        System.out.println(coll.isEmpty());
    }
}

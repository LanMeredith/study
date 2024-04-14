import org.junit.Test;

import java.util.*;

/**
 * 一：Map的实现类的结构
 * Map：双列数据，存储key--value对的数据，--类似于高中函数：y=f(x)
 * -->HashMap：作为Map的主要实现类；线程不安全的，效率高；可以存储null的key和value
 *      -->LinkedHashMap：保证在遍历Map元素时，可以按照添加的顺序实现遍历
 *      原因：在原有的HashMap底层结构基础上，添加了一对指针，指向前一个和后一个元素
 *      对于频繁的遍历操作，此类的执行效率高于HashMap
 * -->ThreeMap：保证按照添加的key-value对进行排序，实现排序遍历。此时考虑key的自然排序或定制排序
 * -->Hashtable：作为古老的实现类；线程安全的，效率低；不能存储null的key和value
 *      -->Properties：常用来处理配置文件。key和value都是String类型
 *
 * HashMap的底层：数组+链表 （JDK7及之前）
 *              数组+链表+红黑树   （JDK8）
 *
 * 面试题：
 * 1.HashMap和Hashtable的异同？
 *
 *
 * 二：Map结构的理解：
 * Map中的key：无序的、不可重复的、使用Set存储所有的key     -->以HashMap为例：key所在的类要重写equals()和hashCode()
 * Map中的value：无序的、可重复的、使用Collection存储所有的value   -->value所在的类要重写equals()
 * 一个键值对：key-value构成一个Entry对象：无序的、不可重复的、Set存储
 * Map中的entry：无序的、不可重复的，使用Set存储所有的entry
 *
 *
 * 三：HashMap的底层实现原理？
 * 以JDK7为例说明：
 * HashMap map = new HashMap();
 * 在实例化以后，底层创建了长度是16的一维数组Entry[] table
 * ...可能已经执行过多次put...
 * map.put(key1,value1)：
 * 首先，调用key1所在类的hashCode()计算key1的哈希值，此哈希值经过某种算法计算后，得到Entry数组中的存放位置
 * 如果此位置上的数据为空，此时key1-value1添加成功     -->情况一
 * 如果此位置上的数据不为空，（意味此位置上存在一个或多个数据（以链表形式存在））
 * 比较key1和已经存在的一个或多个数据的哈希值：
 * -->如果key1的哈希值和已经存在的数据的哈希值都不相同，此时key1-value1添加成功     -->情况二
 * -->如果key1的哈希值和已经存在的某一数据(key2-value2)的哈希值相同，继续比较：调用key1所在类的equals(key2)方法，比较
 *      -->如果equals()返回false：此时key1-value1添加成功     -->情况三
 *      -->如果equals()返回true：使用value1替换value2
 *
 * 补充：关于情况二和情况三：此时key1-value1和原来的数据以链表的形式存储
 * 在添加过程中会涉及到扩容问题，当超出临界值（且要存放的位置非空时），扩容。
 * 默认的扩容方式：扩容为原来容量的两倍，并将原有的数据复制过来
 *
 * JDK8相较于JDK7在底层实现方面的不同
 * 1.new HashMap()底层没有创建一个长度为16的数组
 * 2.JDK8底层的数组是：Node[]，而非Entry[]
 * 3.首次调用put()时，底层创建长度为16的数组
 * 4.JDk7底层结构只有：数组+链表；JDK8底层机构：数组+链表+红黑树
 *      当数组的某一个索引位置上的元素以链表形式存在的数据个数 > 8 且当前数组的长度 > 64时，
 *      此时此索引上的所有数据改为使用红黑树存储。
 *
 *
 *      DEFAULT_INITIAL_CAPACITY：HashMap的默认容量：16
 *      DEFAULT_LOAD_FACTOR：HashMap的默认加载因子：0.75
 *      threshold：扩容的临界值，=容量*填充因子：16*0.75=12
 *      TREEIFY_THRESHOLD：Bucket中链表长度大于该默认值，转化为红黑树：8
 *      MIN_TREEIFY_CAPACITY：桶中的Node被树化时最小的hash表容量：64
 *
 *
 * 四：LinkedHashMap的底层实现原理（了解）
 *
 * @author shkstart
 * @create 2021-01-22-13:58
 */
public class StudyMap {
    /**
     * 以HashMap为例的常用方法，test1涉及到了增、删、改操作
     */
    @Test
    public void test1(){
        HashMap hashMap = new HashMap();
//        Object put(Object key,Object value)将指定key-value添加到（或修改）当前map对象中
        hashMap.put(1234,"VV");
        System.out.println(hashMap);
        hashMap.put(1234,"CC");
        System.out.println(hashMap);

//        void putAll(Map m)将m中的所有key-value对存放到当前map中
        HashMap hashMap1 = new HashMap();
        hashMap1.put(123,678);
        hashMap1.putAll(hashMap);
        System.out.println(hashMap1);

//        Object remove(Object key)移除指定key的key-value对并返回value
        System.out.println(hashMap1.remove("CC"));
        System.out.println(hashMap1.remove("123"));
        System.out.println(hashMap1.remove(123));
        System.out.println(hashMap1);

//        void clear()清空当前map中的所有数据，即便是清空了，map也存在，即为map != null
        hashMap1.clear();
        System.out.println(hashMap1);
    }


    /**
     * 以HashMap为例的常用方法，test2涉及到了元素查询操作
     */
    @Test
    public void test2(){
        HashMap hashMap = new HashMap();
        hashMap.put("CC",1234);
        hashMap.put(1234,"CC");
        hashMap.put(12,"SS");
        hashMap.put(123,"AA");
        hashMap.put(234,"UU");

//        Object get(Object key)获取指定key对应的value
        System.out.println(hashMap.get(12));

//        boolean containsKey(Object key)是否包含指定的key
        System.out.println(hashMap.containsKey("CC"));

//        boolean containsValue(Object value)是否包含指定的value
        System.out.println(hashMap.containsValue("CC"));

//        int size()返回map中key-value对的个数
        System.out.println(hashMap.size());

//        boolean isEmpty()判断当前map是否为空
        System.out.println(hashMap.isEmpty());

//        boolean equals(Object obj)判断当前map和参数对象obj是否相等
        HashMap hashMap1 = new HashMap();
        System.out.println(hashMap.equals(hashMap1));
        hashMap1.putAll(hashMap);
        System.out.println(hashMap.equals(hashMap1));
    }


    /**
     * 以HashMap为例的常用方法，test3涉及到了元视图的操作方法
     */
    @Test
    public void test3(){
        HashMap hashMap = new HashMap();
        hashMap.put("CC",1234);
        hashMap.put(1234,"CC");
        hashMap.put(12,"SS");
        hashMap.put(123,"AA");
        hashMap.put(234,"UU");

//        set keySet()返回所有key构成的Set集合
        Set set = hashMap.keySet();
        Iterator iterator = set.iterator();
//        在获取Set集合后再有增删改等操作，需要重新获取
//        hashMap.remove(12);
//        set = hashMap.keySet();
//        iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("*******************");

//        Collection values()返回所有value构成的Collection集合
        Collection collection = hashMap.values();
        Iterator iterator1 = collection.iterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
        System.out.println("***********************");

//        Set entrySet()返回所有key-value对构成的Set集合
        Set entrySet = hashMap.entrySet();
//        方式一：
        Iterator iterator2 = entrySet.iterator();
        while (iterator2.hasNext()){
            Object next = iterator2.next();
//            entrySet集合中的元素都是entry
            Map.Entry entry = (Map.Entry) next;

            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }
        System.out.println("***********************");

//        方式二
        Set keySet = hashMap.keySet();
        Iterator iterator3 = keySet.iterator();
        while(iterator3.hasNext()){
            Object key = iterator3.next();
            Object value = hashMap.get(key);
            System.out.println(key + "==>" + value);
        }
    }
}

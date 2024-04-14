import org.junit.Test;

import java.util.*;

/**
 * 1.Set接口框架
 * Collection接口：单列集合，用来存储一个一个的对象
 * -->Set接口：存储无序的，不可重复的数据。-->高中讲的“集合”
 *
 * 注意：Set接口中没有额外定义新的方法，使用的都是Collection中声明过的方法
 * 要求：向Set中添加的数据，其所在类一定要重写hashCode()和equals()
 * 要求：重写的hashCode()和equals()尽可能保持一致：相等的对象必须具有相同的散列码
 * 重写两个方法的小技巧：对象中用作equals()方法比较的Field，都应该用来计算hashCode值。
 *
 * 常用实现类：
 * HashSet：作为Set接口的主要实现类；线程不安全的；可以存储null值
 * LinkedHashSet：作为HashSet的子类；遍历其内部数据时，可以按照添加的顺序遍历
 * -->对于频繁的遍历操作，LinkedHashSet效率高于HashSet
 * TreeSet：可以按照添加对象的指定属性，进行排序。
 *
 * 一、Set：存储无序的，不可重复的数据
 * 以HashSet为例：
 * 1.无序性：不等于随机性。存储的数据在底层数组中并非按照数组索引的顺序添加。而是根据数组的哈希值决定的
 *
 * 2.不可重复性：保证添加的元素按照equals()判断时，不能反回true，即：相同的元素只能添加一个。
 *
 * 二、添加元素的过程，以HashSet为例：
 * 我们向HashSet中添加元素a，首先调用元素a所在类的hashCode()方法，计算元素a的哈希值，
 * 此哈希值接着通过某种算法计算出HashSet底层数组中的存放位置（即为：索引位置），
 * 判断数组此位置上是否已经有元素：
 *      如果此位置上没有其他元素，则元素a添加成功-->情况一
 *      如果此位置上有其他元素b（或以链表形式存在的多个元素），则比较元素a和元素b的hash值：
 *          如果hash值不相同，则元素a添加成功-->情况二
 *          如果hash值相同，进而需要调用元素a所在类的equals()方法
 *              equals()返回true，则元素a添加失败
 *              equals()返回false，则元素a添加成功-->情况三
 *
 * 对于添加成功的情况二与情况三而言：元素a与已经存在指定索引位置上数据以链表的方式存储
 * JDK7：元素a放到数组中，指向原来的元素
 * JDK8：原来的元素在数组中，指向元素a
 * 总结：七上八下
 *
 * HashSet底层：数组+链表的结构
 * @author shkstart
 * @create 2021-01-20-14:55
 */
public class StudySet {
    @Test
    public void test1(){
        Set set = new HashSet();
        set.add("颜铭鹤");
        set.add("大数据1902班");
        set.add(2019);
        set.add(193056277);
        set.add(2019);

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    /**
     * LinkedHashSet的使用
     * LinkedHashSet作为HashSet的子类，在添加数据的同时，每个数据还维护了两个引用
     * 记录此数据前一个数据和后一个数据
     * 优点：对于频繁的遍历操作，LinkedHashSet效率高于HashSet
     */
    @Test
    public void test2(){
        Set set = new LinkedHashSet();
        set.add("颜铭鹤");
        set.add("大数据1902班");
        set.add(2019);
        set.add(193056277);
        set.add(2019);

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    /**
     * 1.向TreeSet中添加的数据，要求是相同类的对象
     * 2.两种排序方式：自然排序（实现Comparable接口）和定制排序（Comparator）
     *
     * 3.自然排序中，比较两个对象是否相同的标准：compareTo()返回0，不再是equals()
     * 在定制排序中，比较两个对象是否相同的标准：compare()返回0，不再是equals()
     * test3中测试的是自然排序
     * test4中测试的是定制排序
     */
    @Test
    public void test3(){
        TreeSet set = new TreeSet();

        /*
        失败：不能添加不同类的对象
        set.add("颜铭鹤");
        set.add("大数据1902班");
        set.add(2019);
        set.add(193056277);
        set.add(2019);

        必须的是相同类
        set.add(123);
        set.add(456);
        set.add(321);
        set.add(654);
        */

//        如果我在Affiliated类中重写的compareTo()里只考虑按照姓名排序的话
//        将会出现重名的Tom因为compareTo()返回0，进而只添加其一，漏掉另一个的Tom
        set.add(new Affiliated("Tom",18));
        set.add(new Affiliated("june",90));
        set.add(new Affiliated("Yan",20));
        set.add(new Affiliated("ming",21));
        set.add(new Affiliated("Tom",21));

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test4(){
        Comparator com = new Comparator(){
//            按照年龄从小到大排序，如果年龄相同则按照姓名从小到大排序
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Affiliated && o2 instanceof Affiliated){
                    Affiliated treeSet1 = (Affiliated) o1;
                    Affiliated treeSet2 = (Affiliated) o2;
                    if(treeSet1.getAge() == treeSet2.getAge()){
                        return treeSet1.getName().compareTo(treeSet2.getName());
                    }else{
                        return Integer.compare(treeSet1.getAge(),treeSet2.getAge());
                    }
                }
                throw new RuntimeException("传入的数据类型不一致！");
            }
        };
        TreeSet set = new TreeSet(com);
        set.add(new Affiliated("Tom",18));
        set.add(new Affiliated("june",90));
        set.add(new Affiliated("Yan",20));
        set.add(new Affiliated("ming",21));
        set.add(new Affiliated("Tom",21));

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

class Affiliated implements Comparable{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Affiliated(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Affiliated() {
    }

    @Override
    public String toString() {
        return "Affiliated{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    /**
     * 按照姓名从小到大进行排序，如果姓名相同则按照年龄进行从小到大排序
     * */
    @Override
    public int compareTo(Object o) {
        if (o instanceof Affiliated){
            Affiliated affiliated = (Affiliated) o;
            if(this.name.compareTo(affiliated.name) == 0){
                return Integer.compare(this.age, affiliated.age);
            }else{
                return this.name.compareTo(affiliated.name);
            }
        }
        throw new RuntimeException("传入的数据类型不一致！");
    }
}
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

/**
 * 迭代器
 * 集合元素的遍历操作，使用迭代器Iterator接口
 * 1.集合对象每次调用iterator()方法都会得到一个全新的迭代器对象
 * 默认游标都在集合的第一个元素之前
 * 2.内部的方法：hasNext()和next()
 * hasNext()判断是否还有下一个元素
 * next()指针下移，将下移以后集合位置上的元素返回
 * 3.内部定义了remove()，可以在遍历的时候，删除集合中的元素。此方法不同于集合直接调用remove()
 * 如果还未调用next()或在上一次调用next()之后已经调用了remove()
 * 再调用remove()都会报异常IllegalStateException
 * @author shkstart
 * @create 2021-01-19-14:48
 */
public class StudyIterator {
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add("颜铭鹤");
        coll.add(193056277);
        coll.add("2000-07-25");
        coll.add(new Date());

        Iterator iterator = coll.iterator();

        /*
        方式一
        System.out.println(iterator.next());
        如果报异常NoSuchElementException，则表示没有这个元素，类似于数组角标越界异常

        方式二
        for (int i = 0; i < coll.size(); i++) {
            System.out.println(iterator.next());
        }
        */

//        方式三：推荐！！！
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    /**
     * 错误示范
     */
    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.add("颜铭鹤");
        coll.add(193056277);
        coll.add("2000-07-25");
        coll.add(new Date());

        /*
        错误示范一：这样会跳着输出，并且最后会出现异常NoSuchElementException
        Iterator iterator = coll.iterator();
        while((iterator.next()) != null){
            System.out.println(iterator.next());
        }

        错误示范二：每次都会创建一个新的迭代器对象，每次输出的内容都是第一个元素
        while (coll.iterator().hasNext()){
            System.out.println(coll.iterator().next());
        }
        */
    }
}

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Comparator接口的使用      定制排序
 * 1.背景：
 * 当元素的类型没有实现Comparable接口而又不方便修改代码
 * 或者实现了Comparable接口的排序规则不适合当前的操作
 * 那么可以考虑使用Comparator的对象来排序
 * 2.重写Compare(Object o1,Object o2)方法，比较o1和o2的大小
 * 如果方法返回正整数则表示o1大于o2
 * 如果方法返回零则表示相等
 * 如果方法返回负整数则表示o1小于o2
 *
 * 3.Comparable与Comparator接口的使用对比：
 * Comparable接口的方式一旦确定，保证Comparable接口实现类的对象在任何位置都可以比较大小
 * Comparator接口属于临时性比较。
 * @author shkstart
 * @create 2021-01-17-14:06
 */
public class StudyComparator {
    @Test
    public void test1(){
        String[] arr = new String[]{"AA","PP","II","YY","WW","QQ"};
        Arrays.sort(arr, new Comparator() {
//            按照字符串从大到小的顺序进行排序
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof String && o2 instanceof String){
                    String str1 = (String) o1;
                    String str2 = (String) o2;
                    return -str1.compareTo(str2);
                }
                throw new RuntimeException("传入的数据类型不一致！");
            }
        });
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test2(){
        StudyComparable[] arr = new StudyComparable[5];
        arr[0] = new StudyComparable("华为手机", 4999);
        arr[1] = new StudyComparable("小米手机", 2999);
        arr[2] = new StudyComparable("vivo手机", 3999);
        arr[3] = new StudyComparable("锤子手机", 1999);
        arr[4] = new StudyComparable("小米手机", 1999);

        Arrays.sort(arr, new Comparator() {
//            指明按照特定的方式进行排序，这里是按照名称从低到高排序，如果名称相同则按照价格从低到高排序
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof StudyComparable && o2 instanceof StudyComparable){
                    StudyComparable stu1 = (StudyComparable) o1;
                    StudyComparable stu2 = (StudyComparable) o2;
                    if (stu1.getName().equals(stu2.getName())){
                        return -Integer.compare(stu1.getPrices(), stu2.getPrices());
                    }else {
                        return stu1.getName().compareTo(stu2.getName());
                    }
                }
                throw new RuntimeException("传入的数据类型不一致！");
            }
        });
        System.out.println(Arrays.toString(arr));
    }
}

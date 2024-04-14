import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 通配符的使用
 * 通配符：?
 *
 * 类A是类B的父类，G<A>和G<B>是没有关系的，二者共同的父类是：G<?>
 * 添加：对于list<?>就不能向其内部添加数据，除了添加null之外。
 * @author shkstart
 * @create 2021-01-31-15:09
 */
public class StudyWildcard {
    @Test
    public void test1(){
        List<Integer> list1 = null;
        List<Object> list2 = null;

        List<?> list = null;
        list = list1;
        list = list2;

//        编译通过，为了测试list的添加、读取等操作而注释
//        print(list1);
//        print(list2);

//        添加：对于list<?>就不能向其内部添加数据，除了添加null之外。
//        list.add(null);
//        list.add(123);

        ArrayList<String> list3 = new ArrayList<>();
        list3.add("AA");
        list3.add("BB");
        list = list3;

//        获取（读取）：允许读取数据，读取的数据类型为Object
        Object o = list.get(0);
        System.out.println(o);
    }

    public void print(List<?> list){
        Iterator<?> iterator = list.iterator();
        while(iterator.hasNext()){
            Object o = iterator.next();
            System.out.println(o);
        }
    }

    /*
    有限制条件的通配符的使用：
    ? extends A：
            G<? extends A>，可以作为G<A>和G<B>的父类，其中B是A的子类
            通俗的讲：上限是A，可以包含A及A的子类（<=A）
    ? super A：
            G<? super A>，可以作为G<A>和G<B>的的父类，其中B是A的父类
            通俗的讲：下限是A，可以包含A及A的父类（>=A）
     */
    @Test
    public void test2(){
        List<? extends Student> list1 = null;
        List<? super Student> list2 = null;

        List<PrimarySchoolStudents> list3 = new ArrayList<>();
        List<Student> list4 = new ArrayList<>();
        List<Object> list5 = new ArrayList<>();

        list1 = list3;
        list1 = list4;
//        list1 = list5;

//        list2 =list3;
        list2 = list4;
        list2 = list5;


//        读取
        list1 = list3;
        Object obj1 = list1.get(0);
//        <? extends Student>最大是Student，所以可以直接用Student
        Student stu = list1.get(0);
//        编译不通过
//        PrimarySchoolStudents pss = list1.get(0);

        list2 = list4;
//        <? super Student>最小是Student，最大则是Object，所以只能用Object
        Object obj2 = list2.get(0);


//        写入
//        编译不通过
//        list1.add(new PrimarySchoolStudents());

//        编译通过
        list2.add(new Student());
        list2.add(new PrimarySchoolStudents());
    }
}

class PrimarySchoolStudents extends Student {

}

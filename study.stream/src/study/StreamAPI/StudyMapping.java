package study.StreamAPI;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Stream的中间操作
 * 多个中间操作可以连接起来形成一个流水线，除非流水线上触发终止操作，否则中间操作不会执行任何的处理
 * 而在终止操作时，一次性全部处理，称为”惰性求值“
 * 2.映射
 * @author shkstart
 * @create 2021-08-08-20:15
 */
public class StudyMapping {
    @Test
    public void test1() {
        /*
        * map(Function f)接收一个函数作为参数，将元素转换成其他形式或提取信息
        * 该函数会被应用到每个元素上，并将其映射成一个新的元素
        * */
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);

//        获取员工姓名长度大于三的员工的姓名
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().map(Employee::getName).filter(name -> name.length() > 3).forEach(System.out::println);

        /*
        * flatMap(Function f)接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
        * */
//        以Map()
        Stream<Stream<Character>> streamStream = list.stream().map(StudyMapping::fromStringToStream);
        streamStream.forEach(s -> s.forEach(System.out::println));

        System.out.println();

//        以flatMap()
        list.stream().flatMap(StudyMapping::fromStringToStream).forEach(System.out::println);
    }


    /**
     * 将字符串中的多个字符构成的集合转换为对应的Stream的实例
     */
    public static Stream<Character> fromStringToStream(String str) {
        ArrayList<Character> list = new ArrayList<>();
        for (Character c :
                str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    @Test
    public void test4() {
        ArrayList list1 = new ArrayList();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        ArrayList list2 = new ArrayList();
        list2.add(4);
        list2.add(5);
        list2.add(6);

//        list1中有四个元素[1,2,3,[4,5,6]]
        list1.add(list2);

        /*
        list1中有六个元素[1,2,3,4,5,6]
        list1.addAll(list2);
        */

//        遍历集合方式一
        for (Object obj :
                list1) {
            System.out.println(obj);
        }

        System.out.println();

//        遍历集合方式二
        Iterator iterator = list1.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

package study.StreamAPI;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Stream的中间操作
 * 多个中间操作可以连接起来形成一个流水线，除非流水线上触发终止操作，否则中间操作不会执行任何的处理
 * 而在终止操作时，一次性全部处理，称为”惰性求值“
 * 3.排序
 *
 * @author shkstart
 * @create 2021-08-08-21:07
 */
public class StudySorting {
    @Test
    public void test1() {
//        sorted()自然排序
        List<Integer> list = Arrays.asList(12, 312, 31, 31, 23, 123, 1);
        list.stream().sorted().forEach(System.out::println);

        System.out.println();

//      sorted(Comparator com)定制排序（从大到小）
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted((e1, e2) -> {
            return -Integer.compare(e1.getAge(), e2.getAge());
        }).forEach(System.out::println);
    }
}

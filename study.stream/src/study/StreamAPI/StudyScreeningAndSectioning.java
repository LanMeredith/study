package study.StreamAPI;

import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

/**
 * Stream的中间操作
 * 多个中间操作可以连接起来形成一个流水线，除非流水线上触发终止操作，否则中间操作不会执行任何的处理
 * 而在终止操作时，一次性全部处理，称为”惰性求值“
 * 1.筛选与切片
 * @author shkstart
 * @create 2021-08-08-19:57
 */
public class StudyScreeningAndSectioning {
    /**
     * filter(Predicate p)接收Lambda表达式，从流中排除某些元素
     */
    @Test
    public void test1() {
        /*
        原始写法
        stream.filter(new 函数式接口<Employee>(){
            抽象方法(Employee e){
                e.getSalary() > 7000;
            }
        });
         */
        List<Employee> list = EmployeeData.getEmployees();
        Stream<Employee> stream = list.stream();
        stream.filter(e -> e.getSalary() > 7000).forEach(System.out::println);
    }

    /**
     * limit(n)截断流，使其元素不超过给定数量
     */
    @Test
    public void test2() {
        List<Employee> list = EmployeeData.getEmployees();
        list.stream().limit(5).forEach(System.out::println);
    }

    /**
     * skip(n)跳过元素，返回一个扔掉了前n个元素的流，若流中元素不足n个，则返回一个空流，与limit(n)互补
     */
    @Test
    public void test3() {
        List<Employee> list = EmployeeData.getEmployees();
        list.stream().skip(5).forEach(System.out::println);
    }

    /**
     * distinct()筛选，通过流所生成的元素的hashCode()和equals()去除重复元素
     */
    @Test
    public void test4() {
        List<Employee> list = EmployeeData.getEmployees();
//        手动添加一个重复元素
        list.add(new Employee(1007, "任正非", 26, 4333.32));
//        System.out.println(list);
        list.stream().distinct().forEach(System.out::println);
    }
}

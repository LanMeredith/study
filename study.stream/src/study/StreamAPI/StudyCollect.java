package study.StreamAPI;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 终止操作
 * 3.收集
 * @author shkstart
 * @create 2021-08-11-23:21
 */
public class StudyCollect {
    /**
     * collect(Collector c)将流转换为其他形式。
     * 接收一个Collector接口的实现，用于给Stream中元素做汇总的方法
     */
    @Test
    public void test1() {
//        练习：查找工资大于六千的员工，结果返回为一个List或Set
        List<Employee> employees = EmployeeData.getEmployees();

        List<Employee> collect = employees.stream().filter(employee -> employee.getSalary() > 6000).collect(Collectors.toList());
        System.out.println("返回一个List");
        for (Employee e :
                collect) {
            System.out.println(e);
        }

        System.out.println();

        System.out.println("返回一个Set");
        employees.stream().filter(employee -> employee.getSalary() > 6000).collect(Collectors.toSet()).forEach(System.out::println);

        System.out.println();

        System.out.println("返回一个集合");
        employees.stream().filter(employee -> employee.getSalary() > 6000).collect(Collectors.toCollection(ArrayList::new)).forEach(System.out::println);
    }

    /**
     * 练习
     */
    @Test
    public void test2() {
        List<Employee> employees = EmployeeData.getEmployees();
//        计算流中元素的个数
        System.out.println(employees.stream().collect(Collectors.counting()));

        System.out.println();

//        对流中元素的整数属性求和
        System.out.println(employees.stream().collect(Collectors.summingInt(Employee::getAge)));

        System.out.println();

//        计算流中元素Integer属性的平均值
        System.out.println(employees.stream().collect(Collectors.averagingInt(Employee::getAge)));

        System.out.println();

//        收集流中Integer属性的统计值
        System.out.println(employees.stream().collect(Collectors.summarizingInt(Employee::getAge)));
    }
}

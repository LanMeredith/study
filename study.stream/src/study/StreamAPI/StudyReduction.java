package study.StreamAPI;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 终止操作
 * 2.归约
 * @author shkstart
 * @create 2021-08-11-23:00
 */
public class StudyReduction {
    /**
     * reduce(T identity, BinaryOperator)可以将流中元素反复结合起来，得到一个值，返回T
     */
    @Test
    public void test1() {
//        练习：计算1-10的自然数的和
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        可以在Integer::sum前加一个数值作为初始值，但是创建Optional对象时需要使用Optional.ofNullable()方法
        Optional<Integer> reduce =list.stream().reduce(Integer::sum);
        System.out.println(reduce);
    }

    /**
     * reduce(BinaryOperator)可以将流中元素反复结合起来，得到一个值，返回Optional<T>
     */
    @Test
    public void test2() {
//        练习：计算公司所有员工工资的总和
        List<Employee> list = EmployeeData.getEmployees();
        Optional<Double> reduce = list.stream().map(Employee::getSalary).reduce(Double::sum);
        System.out.println(reduce);
    }
}

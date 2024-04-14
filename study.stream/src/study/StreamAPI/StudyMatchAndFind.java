package study.StreamAPI;

import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * 终止操作
 * 终端操作会从流的流水线生成结果，其结果可以是任何不是流的值
 * 例如：List、Integer，甚至是void
 * 流进行终止操作后就不能再次使用
 *
 * 1.匹配与查找
 * @author shkstart
 * @create 2021-08-08-21:15
 */
public class StudyMatchAndFind {
    /**
     * allMatch(Predicate p)检查是否匹配所有元素
     */
    @Test
    public void test1() {
        List<Employee> employees = EmployeeData.getEmployees();
//        是否所有员工的年龄都大于十八
        boolean isAllMatch = employees.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(isAllMatch);
    }

    /**
     * anyMatch(Predicate p)检查是否至少匹配一个元素
     */
    @Test
    public void test2() {
        List<Employee> employees = EmployeeData.getEmployees();
//        是否有员工的工资大于一万
        System.out.println(employees.stream().anyMatch(e -> e.getSalary() > 10000));
    }

    /**
     * noneMatch(Predicate p)检查是否没有匹配的元素
     */
    @Test
    public void test3() {
        List<Employee> employees = EmployeeData.getEmployees();
        System.out.println(employees.stream().noneMatch(e -> e.getName().startsWith("雷")));
    }

    /**
     * findFirst()返回第一个元素
     */
    @Test
    public void test4() {
        List<Employee> employees = EmployeeData.getEmployees();
        Optional<Employee> first = employees.stream().findFirst();
        System.out.println(first);
    }

    /**
     * findAny()返回当前类流中的任意元素（存在一些问题：
     * 在串行的流中，findFirst()和findAny()返回的都是第一个对象
     * 而在并行流中，findAny()返回的是最快处理玩的那个线程的数据
     */
    @Test
    public void test5() {
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Employee> stream = employees.parallelStream();
        Optional<Employee> any = stream.findAny();
        System.out.println(any);
    }

    /**
     * count()返回流中元素的总个数
     * max(Comparator c)返回流中最大值
     * min(Comparator c)返回流中最小值
     */
    @Test
    public void test6() {
        List<Employee> employees = EmployeeData.getEmployees();
//        返回流中元素的总个数
        System.out.println(employees.stream().count());

//        返回最高工资
        Optional<Double> max = employees.stream().map(Employee::getSalary).max(Double::compareTo);
        System.out.println(max);

//        返回最低工资的员工
        System.out.println(employees.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
    }

    /**
     * forEach(Consumer c)内部迭代（使用Collection接口要用户做迭代，称为外部迭代。相反Stream API使用内部迭代）
     */
    @Test
    public void test7() {
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().forEach(System.out::println);
    }
}

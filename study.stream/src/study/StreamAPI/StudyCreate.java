package study.StreamAPI;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 1.
 * Stream API关注的是对数据的运算与CPU打交道
 * 集合馆主的是数据的存储，与内存打交道
 *
 * 2.
 * ①Stream 自己不会存储元素。
 * ②Stream 不会改变源对象。相反，他们会返回一个持有结果的新Stream。
 * ③Stream 操作是延迟执行的。这意味着他们会等到需要结果的时候才执行
 *
 * 3.
 * Stream 执行流程
 * ① Stream的实例化
 * ② 一系列的中间操作（过滤、映射、...)
 * ③ 终止操作
 *
 * 4.
 * 说明：
 * 4.1 一个中间操作链，对数据源的数据进行处理
 * 4.2 一旦执行终止操作，就执行中间操作链，并产生结果。之后，不会再被使用
 * @author shkstart
 * @create 2021-08-08-21:41
 */
public class StudyCreate {
    /**
     * 创建Stream方式一：通过集合
     */
    @Test
    public void test1() {
        List<Employee> employees = EmployeeData.getEmployees();
//        default Stream<E> stream()返回一个顺序流
        Stream<Employee> stream = employees.stream();
//        default Stream<E> parallelStream()返回一个并行流
        Stream<Employee> employeeStream = employees.parallelStream();
    }

    /**
     * 创建Stream方式二：通过数组
     */
    @Test
    public void test2() {
        int[] arr = new int[]{12,3,12,31,31,312,3,1};
        IntStream stream = Arrays.stream(arr);

        Employee e1 = new Employee(1001, "Tom");
        Employee e2 = new Employee(1002, "Jerry");
        Employee[] employees = {e1, e2};
        Stream<Employee> employeeStream = Arrays.stream(employees);
    }

    /**
     * 创建Stream方式三：通过Stream的of()
     */
    @Test
    public void test3() {
        Stream<Integer> stream = Stream.of(1, 23, 12, 321, 231);
    }

    /**
     * 创建Stream方式四：创建无限流
     */
    @Test
    public void test4() {
        /*
        * 迭代
        * public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
        * 遍历前十个偶数
        * */
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);

        /*
        * 生成
        * public static<T> Stream<T> generate(Supplier<T> s)
        * 生成十个随机数
        * */
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }
}

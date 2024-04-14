package study.references;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用
 * 当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用！
 * 本质上就是Lambda表达式，而Lambda表达式作为函数式接口的实例，所以方法引用也就是函数式接口的实例
 *
 * @author shkstart
 * @create 2021-08-07-14:26
 */
public class StudyMethodRef {
    /**
     * 使用情况一：
     * 对象 :: 非静态方法
     */
    @Test
    public void test1() {
//        Lambda表达式
        Consumer<String> con = str -> System.out.println(str);
        con.accept("北京");

//        方法引用
        Consumer<String> consumer = System.out::println;
        consumer.accept("吉安");
        System.out.println();

//        Lambda表达式
        Employee tom = new Employee(1232131, "Tom");
        Supplier<String> sup = () -> tom.getName();

        System.out.println(sup.get());

//        方法引用
        Supplier<String> supplier = tom::getName;
        System.out.println(supplier.get());
    }

    /**
     * 使用情况二：
     * 类 :: 静态方法
     */
    @Test
    public void test2() {
//        Lambda表达式
        Comparator<Integer> com = (t1, t2) -> Integer.compare(t1, t2);
        System.out.println(com.compare(12312, 122131));

//        方法引用
        Comparator<Integer> com1 = Integer::compareTo;
        System.out.println(com1.compare(1231, 12312312));

        System.out.println();

        /*
        Function中的R apply(T t)
        Math中的Long round(Double d)
        先写形参后写返回值类型
         */
//        Lambda表达式
        Function<Double, Long> fun = aDouble -> Math.round(aDouble);
        System.out.println(fun.apply(123.123));

//        方法引用
        Function<Double, Long> fun1 = Math::round;
        System.out.println(fun1.apply(123.456));
    }

    /**
     * 使用情况三：
     * 类::非静态方法（有难度）
     */
    @Test
    public void test3() {
//        Lambda表达式
        Comparator<String> com = (s1, s2) -> s1.compareTo(s2);
        System.out.println(com.compare("颜铭鹤", "YMH"));

//        方法引用
        Comparator<String> com1 = String::compareTo;
        System.out.println(com1.compare("YMH", "颜铭鹤"));
    }
}

package study.Optional;

import org.junit.Test;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * Optional<T>类（java.util.Optional）是一个容器类
 * 它可以保存类型T的值，代表这个值存在。
 * 或者仅仅保存null，表示这个值不存在。
 * 原来用null表示一个值不存在，现在Optional可以更好的表达这个概念。
 * 并且可以避免空指针异常
 * @author shkstart
 * @create 2021-08-11-23:38
 */
public class StudyCreate {
    /**
     * Optional.of(T t)：创建一个Optional实例，t必须为非空
     * Optional.empty()：创建一个空的Optional实例
     * Optional.ofNullable(T t)：t可以为null
     *
     * isPresent()判断是否包含对象
     * ifPresent()如果有值，就执行Consumer接口的实现代码，并且该值会作为参数传给它
     *
     * T get()如果调用对象包含值，返回该值，否则抛出异常
     * T orElse(T other)如果有值则返回，否则返回指定的other对象
     * T orElseGet(Supplier<? extends T> other)如果有值则将其返回，否则返回有Supplier接口实现提供的对象
     * T orElseThrow(Supplier<? extends X> exceptionSupplier)如果有值则将其返回，否则抛出由Supplier接口实现提供的异常
     */
    @Test
    public void test1() {
        Employee employee = new Employee();
        Optional<Employee> optional = Optional.of(employee);
        System.out.println(optional);

        Employee employee1 = null;
        Optional<Employee> optional1 = Optional.ofNullable(employee1);
        System.out.println(optional1);

        System.out.println();

        System.out.println(optional.isPresent());
        System.out.println(optional1.isPresent());

        optional.ifPresent(Employee::newtoString);

        System.out.println();

        System.out.println(optional.get());
//        optional1有泛型为employee，所以只能返回指定的Employee类型
        System.out.println(optional1.orElse(new Employee()));
    }
}

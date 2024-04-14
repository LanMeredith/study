package study.references;

import org.junit.Test;

import java.util.function.Supplier;

/**
 * 构造器引用
 * 和方法引用类似，函数式接口的抽象方法的形参列表和构造器的形参列表一致
 * 抽象方法的返回值类型即为构造器所属的类的类型
 * @author shkstart
 * @create 2021-08-08-19:38
 */
public class StudyConstructorRef {
    /**
     * 构造器引用
     * Supplier中T get()
     * Employee中空参构造器Employee()
     */
    @Test
    public void test1() {
//        构造器引用原始写法
        Supplier<Employee> supplier = new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };

//        lambda表达式写法
        Supplier<Employee> supplier1 = () -> new Employee();

//        方法引用写法
        Supplier<Employee> supplier2 = Employee::new;
    }
}

package study.lambda;


import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Lambda是一个匿名函数，我们可以把Lambda表达式理解为是一段可以传递的代码
 * 格式：
 * -> lambda操作符或叫箭头操作符
 * ->左边 lambda形参列表（其实就是接口中的抽象方法的形参列表）
 * ->右边 lambda体（其实就是重写的抽象方法的方法体）
 * @author shkstart
 * @create 2021-08-07-14:00
 */
public class StudyLambda {
    @Test
    public void test() {
//        1.无参无返回值
        Runnable r1 = () -> {
            System.out.println("情况一：无参无返回值");
        };
        r1.run();

//        2.一个参数，无返回值
        Consumer<String> con = (String str) -> {
            System.out.println(str);
        };
        con.accept("情况二：一个参数，无返回值");

//        3.数据类型可以省略，因为可由编译器推断得出，称为“类型推断”
        Consumer<Integer> con1 = (i) -> {
            System.out.println("这是情况" + i);
        };
        con1.accept(3);

//        4.若只需要一个参数时，参数的小括号可以省略
        Consumer<String> con2 = str -> {
            System.out.println(str);
        };
        con2.accept("情况四：若只需要一个参数时，参数的小括号可以省略");

//        5.需要两条及以上的参数，多条执行语句，并且可以有返回值
        Comparator<Integer> com = (o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        System.out.println(com.compare(45, 122));

//        6.只有一条语句，return与大括号若有都可以省略（省略大括号就一定要省略return）
        Comparator<Double> com1 = (o1, o2) -> o1.compareTo(o2);
        System.out.println(com1.compare(123.1231, 12321.31));
    }
}

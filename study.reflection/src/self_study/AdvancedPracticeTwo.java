package self_study;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 在Practice类中学习的进阶第二节
 * @author shkstart
 * @create 2021-08-02-20:32
 */
public class AdvancedPracticeTwo {
    /**
     * 获取指定属性
     *
     * 在这里碰到了两个错误，第一个是Student中没有空参构造器
     * 但是我在创建运行时类的对象时newInstance()指引向的是空参构造器，从而导致报错
     * 第二个问题则是在最后一行获取对象的此属性值时，get()方法中的参数应该是对象，我写错成了studyid
     */
    @Test
    public void test() throws IllegalAccessException, InstantiationException, NoSuchFieldException {
//        获取运行时类
        Class<Student> aClass = Student.class;
//        创建运行时类的对象
        Student student = aClass.newInstance();
//        获取指定属性
        Field studyid = aClass.getDeclaredField("studyid");
//        设置当前属性是可以访问的
        studyid.setAccessible(true);
//        设置指定对象的此属性值
        studyid.set(student, 193056277);
//        获取指定对象的此属性值
        System.out.println("studyid = " + studyid.get(student));
    }

    /**
     * 获取指定方法
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    @Test
    public void test1() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
//        获取运行时类
        Class<Student> aClass = Student.class;
//        创建运行时类的对象
        Student student = aClass.newInstance();
//        获取指定方法，参数1：指定要获取的方法名称，参数2：指明要获取方法的形参列表，以免同名方法
        Method showtime = aClass.getDeclaredMethod("showtime", String.class);
//        设置当前方法是可以访问的
        showtime.setAccessible(true);
//        invoke()参数1：方法的调用者，参数2：给方法形参赋值的实参
//        此方法的返回值，即为对应类中调用的方法的返回值
        Object hello = showtime.invoke(student, "Hello");
        System.out.println((String) hello);
    }

    /**
     * 获取指定静态方法
     */
    @Test
    public void test2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        获取运行时类
        Class<Student> aClass = Student.class;
//        获取指定方法，静态方法不用创建对象
        Method showtime = aClass.getDeclaredMethod("showtime", int.class);
//        设置当前方法是可以访问的
        showtime.setAccessible(true);
//        调用方法，这几种写法都可以
        /*
        Object invoke = showtime.invoke("", 7);
        Object invoke = showtime.invoke(aClass, 7);
        Object invoke = showtime.invoke(null, 7);
        */
        Object invoke = showtime.invoke(Student.class, 7);
        System.out.println((int) invoke);
    }

    @Test
    public void test3() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        获取运行时类
        Class<Student> aClass = Student.class;
//        获取指定的构造器，参数：指明构造器的参数列表
        Constructor<Student> constructor = aClass.getDeclaredConstructor(String.class);
//        保证此构造器是可访问的
        constructor.setAccessible(true);
//        调用此构造器创建运行时类的对象
        Student student = constructor.newInstance("三中");
        System.out.println(student);
    }
}

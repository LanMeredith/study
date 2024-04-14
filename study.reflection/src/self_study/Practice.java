package self_study;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 通过反射可访问的主要描述信息
 *
 * 说明：
 * 在通过getFields()和getMethods()方法以此获取得权限为public的成员变量和方法时，将包含从父类中继承到的成员变量和方法；
 * 而通过方法getDeclaredFields()和getDeclaredMethods()只是获得在本类中定义的所有成员变量和方法
 * @author shkstart
 * @create 2021-07-22-23:15
 */
public class Practice {
    @Test
    public void test() {
        Class<Student> studentClass = Student.class;

//        获得该类的存放路径
        System.out.println("获得该类的存放路径");
        System.out.println(studentClass.getPackage());
        System.out.println();

//        获得该类的名称
        System.out.println("获得该类的名称");
        System.out.println(studentClass.getName());
        System.out.println();

//        获得该类的继承类（即为该类的父类）
        System.out.println("获得该类的继承类（即为该类的父类）");
        System.out.println(studentClass.getSuperclass());
        System.out.println();

//        获得该类实现的所有接口（返回数组）
        System.out.println("获得该类实现的所有接口（返回数组）");
        for (Class<?> anInterface : studentClass.getInterfaces()) {
            System.out.println(anInterface);
        }
        System.out.println();
    }

    /**
     * 构造方法
     */
    @Test
    public void test1() throws NoSuchMethodException {
        Class<Student> studentClass = Student.class;

//        获得本类所有权限为public的构造方法（返回数组）
        System.out.println("获得所有权限为public的构造方法（返回数组）");
        for (Constructor<?> constructor : studentClass.getConstructors()) {
            System.out.println(constructor);
        }
        System.out.println();

//        获得权限为public的指定构造方法
        System.out.println("获得权限为public的指定构造方法");
        Constructor<Student> constructor = studentClass.getConstructor(String.class);
        System.out.println(constructor);
        System.out.println();

//        获得当前运行时类中所有构造方法，按声明顺序返回
        System.out.println("获得所有构造方法，按声明顺序返回");
        for (Constructor<?> declaredConstructor : studentClass.getDeclaredConstructors()) {
            System.out.println(declaredConstructor);
        }
        System.out.println();

//        获得指定构造器
        System.out.println("获得指定构造器");
//        指明要获取构造器的形参列表，以免同名方法
        Constructor<Student> declaredConstructor = studentClass.getDeclaredConstructor(String.class, String.class);
        System.out.println(declaredConstructor);
        System.out.println();
    }

    /**
     * 方法
     */
    @Test
    public void test2() throws NoSuchMethodException {
        Class<Student> studentClass = Student.class;

//        获得所有权限为public的方法，包含父类中以public修饰的方法
        System.out.println("获得所有权限为public的方法");
        for (Method method : studentClass.getMethods()) {
            System.out.println(method);
        }
        System.out.println();

//        获得权限为public的指定方法
        System.out.println("获得权限为public的指定方法");
        Method getSchool = studentClass.getMethod("getSchool");
        System.out.println(getSchool);
        System.out.println();

//        获得所有方法，按声明顺序返回，只获得本类中的方法
        System.out.println("获得所有方法，按声明顺序返回");
        for (Method declaredMethod : studentClass.getDeclaredMethods()) {
            System.out.println(declaredMethod);
        }
        System.out.println();

//        获得指定方法
        System.out.println("获得指定方法");
//        指明要获取方法的形参列表，以免同名方法
        Method setSchool = studentClass.getDeclaredMethod("showtime", String.class);
        System.out.println(setSchool);
        System.out.println();
    }

    /**
     * 成员变量
     */
    @Test
    public void test3() throws NoSuchFieldException {
        Class<Student> studentClass = Student.class;

//        获得所有权限为public的成员变量，包含父类中以public修饰的成员变量
        System.out.println("获得所有权限为public的成员变量，包含父类中以public修饰的成员变量");
        for (Field field : studentClass.getFields()) {
            System.out.println(field);
        }
        System.out.println();

//        获得权限为public的指定成员变量
        System.out.println("获得权限为public的指定成员变量");
        Field school = studentClass.getField("school");
        System.out.println(school);
        System.out.println();

//        获得所有成员变量，按声明顺序返回，只获得本类中所有属性
        System.out.println("获得所有成员变量，按声明顺序返回，只获得本类中所有属性");
        for (Field declaredField : studentClass.getDeclaredFields()) {
            System.out.println(declaredField);
        }
        System.out.println();

//        获得指定成员变量
        Field school1 = studentClass.getDeclaredField("school");
        System.out.println(school1);
        System.out.println();
    }

    /**
     * 内部类
     */
    @Test
    public void test4() {
        Class<Student> studentClass = Student.class;

//        获得所有权限为public的内部类
        for (Class<?> aClass : studentClass.getClasses()) {
            System.out.println(aClass);
        }
        System.out.println();

//        获得所有内部类
        for (Class<?> aClass : studentClass.getDeclaredClasses()) {
            System.out.println(aClass);
        }
        System.out.println();

//        如果该类是内部类，则返回它的成员类，否则返回null
        Class<?> aClass = studentClass.getDeclaringClass();
        System.out.println(aClass);
    }
}

import org.junit.Test;

import java.lang.annotation.ElementType;

/**
 * java.lang.Class的理解
 * 1.类的加载过程：
 * 程序在经过java.exe命令以后，会生成一个或多个字节码文件(以.class)结尾
 * 接着我们使用java.exe命令对某个字节码文件进行解释运行，相当于讲某个字节码文件加载到内存中，此过程就称为类的加载
 * 加载到内存中的类，我们就称为运行时类，此运行时类，就作为Class的一个实例
 * 2.换句话说，Class的实例就对应一个运行时类
 * 3.加载到内存中的运行时类会缓存一定时间，在此时间内我们可以通过不同的方式来获取此运行时类
 *
 * 哪些类可以有Class对象
 * （1）class：外部类，成员（成员内部类，静态内部类），局部内部类，匿名内部类
 * （2）interface：接口
 * （3）[]：数组
 * （4）enum：枚举
 * （5）annotation：注解@interface
 * （6）primitive type：基本数据类型
 * （7）void
 * @author shkstart
 * @create 2021-07-14-22:06
 */
public class UnderstandReflection {
    /**
     * 获取Class的实例的方式
     */
    @Test
    public void test() throws ClassNotFoundException {
//        方式一
        Class<Person> aClass = Person.class;
        System.out.println(aClass);

//        方式二
        Person person = new Person();
        Class bClass = person.getClass();
        System.out.println(bClass);

//        方式三
        Class cClass = Class.forName("Person");
        System.out.println(cClass);

//        指向同一对象同一地址
        System.out.println(aClass == bClass);
        System.out.println(aClass == cClass);

//        以上三种方法要求全部掌握
//        方式四：使用类的加载器
        ClassLoader loader = UnderstandReflection.class.getClassLoader();
        Class dClass = loader.loadClass("Person");
        System.out.println(dClass);

        System.out.println(aClass == dClass);
    }

//    Class实例可以是那些结构类型的说明：
    @Test
    public void test1() {
//        class：外部类，成员（成员内部类，静态内部类），局部内部类，匿名内部类
        Class aClass = Object.class;
//        interface：接口
        Class aClass1 = Comparable.class;
//        []：数组
        Class aClass2 = String[].class;
        Class aClass3 = int[][].class;
//        enum：枚举
        Class aClass4 = ElementType.class;
//        annotation：注解@interface
        Class aClass5 = Override.class;
//        primitive type：基本数据类型
        Class aClass6 = int.class;
//        void
        Class aClass7 = void.class;
//        class：外部类，成员（成员内部类，静态内部类），局部内部类，匿名内部类
        Class aClass8 = Class.class;

        int[] ints = new int[]{1,7,3,4,5312312,22313,7,21312,9};
        int[] ints1 = new int[1000];
        int[][] ints2 = new int[10][10];
        Class aClass9 = ints.getClass();
        Class aClass10 = ints1.getClass();
        Class aClass11 = ints2.getClass();
//        只要元素类型与维度一样，就是同一个Class
        System.out.println(aClass9 == aClass10);
//        若不一样，则不算同一个Class。如例：一维数组的Class与二维数组的不一样
        System.out.println(aClass10 == aClass11);
    }
}

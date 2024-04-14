import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Reflection（反射）是被视为   动态语言    的关键
 * 反射机制允许程序在执行期借助于Reflection API取得任何类的内部信息
 * 并能直接操作任意对象的内部属性及方法。
 *
 * 补充：动态语言 VS 静态语言
 * 动态语言：是一类在运行时可以改变其结构的语言：
 * 例如新的函数、对象、甚至代码可以被引进，已有的函数可以被删除或是其他结构上的变化。
 * 通俗点说就是在运行时代码可以根据某些条件改变自身结构
 * 主要动态语言：Object-c、C#、JavaScript、PHP、Python、Erlang
 * 静态语言：与动态语言相对应的，运行时结构不可变的语言就是静态语言。
 * 主要静态语言：JAVA、C、C++
 *
 * JAVA不是动态语言，但JAVA可以称为“准动态语言”。
 * 即JAVA有一定的动态性，我们可以利用反射机制、字节码操作获得类似动态语言的特性。
 * JAVA的动态性让编程的时候更加灵活！
 * @author shkstart
 * @create 2021-07-07-14:01
 */
public class StudyReflection {
    /**
     * 反射之前对于person类的操作
     */
    @Test
    public void test1(){
//        1.创建Person类的对象
        Person person = new Person("Tom",18);

//        2.通过对象，调用其内部的属性、方法
        person.age = 10;
        System.out.println(person.toString());

        person.show();

//        3.在Person类外部，不可以通过Person类的对象调用其内部私有结构
//        比如：name、showNation()以及私有的构造器
    }

    /**
     * 反射之后对于Person类的对象
     * */
    @Test
    public void test2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class aClass = Person.class;
//        1.通过反射，创建Person类的对象
//        调用构造器
        Constructor cons = aClass.getConstructor(String.class, int.class);
        Object obj = cons.newInstance("Tom", 12);
        Person p = (Person)obj;
        System.out.println(p.toString());
//        可强转也可不强转，实际一样
        System.out.println(obj.toString());

        System.out.println();

//        2.通过反射，调用对象指定的属性，方法
        Field age = aClass.getDeclaredField("age");
        age.set(p, 10);
//        无论是obj还是p其实都一样，指向同一个对象
//        调用属性
        System.out.println(obj.toString());
        System.out.println(p.toString());

//        调用方法
        Method show = aClass.getDeclaredMethod("show");
        show.invoke(p);
        show.invoke(obj);

        System.out.println();

//        通过反射可以调用Person类的私有结构，如私有的构造器、方法、属性
//        调用私有的构造器
        Constructor cons1 = aClass.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1 = (Person) cons1.newInstance("Jack");
        System.out.println(p1);

//        调用私有的属性
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1, "Lilei");
        System.out.println(p1);

//        调用私有的方法
        Method showNation = aClass.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
//        相当于p1.showNation("中国")
        showNation.invoke(p1, "中国");
//        相当于String nation = showNation.invoke(p1, "中国")
        String nation = (String) showNation.invoke(p1, "中国");
        System.out.println(nation);
    }
}

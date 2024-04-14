package self_study;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

/**
 * 在Practice类中学习的进阶
 * @author shkstart
 * @create 2021-07-29-22:59
 */
public class AdvancedPractice {
    /**
     * 通过getDeclaredFields()可以获取到本类中的所有成员变量，而通过以下的方式可以获取这些成员变量的更详细信息
     */
    @Test
    public void test() {
        Class<Student> studentClass = Student.class;
        for (Field declaredField : studentClass.getDeclaredFields()) {
//            1.权限修饰符
            int modifiers = declaredField.getModifiers();
            System.out.println(Modifier.toString(modifiers));

//            2.数据类型
            Class<?> type = declaredField.getType();
            System.out.println(type.getName() + "\t");

//            3.变量名
            System.out.println(declaredField.getName());
            System.out.println();
        }
    }

    /**
     * 通过getDeclaredMethods()可以获取到本类中的所有方法，而通过以下的方式可以获取这些方法的更详细信息
     */
    @Test
    public void test1() {
        Class<Student> studentClass = Student.class;
        for (Method declaredMethod : studentClass.getDeclaredMethods()) {
//            1.获取方法方法声明的注解（只有声明为RUNTIME生命周期的注解才能通过反射获取）
            Annotation[] annotation = declaredMethod.getAnnotations();
            for (Annotation a :
                    annotation) {
//                在运行时，先获取到该方法，获取注解再获取权限修饰符，故注解永远在对应权限修饰符的上方
                System.out.println(a);
            }

//            2.权限修饰符
            System.out.println(Modifier.toString(declaredMethod.getModifiers()));

//            3.返回值类型
            System.out.println(declaredMethod.getReturnType().getName());

//            4.方法名
            System.out.print(declaredMethod.getName() + "(");

//            5.形参列表
            Class<?>[] types = declaredMethod.getParameterTypes();
            boolean isTypes = (types == null) || (types.length == 0);
            if (!isTypes) {
                for (int i = 0; i < types.length; i++) {
                    if (i == types.length - 1) {
                        System.out.print(types[i].getName());
                        break;
                    }
                    System.out.print(types[i].getName() + ",");
                }
            }
            System.out.println(")");

//            6.抛出的异常
            Class<?>[] exceptionTypes = declaredMethod.getExceptionTypes();
            boolean isExceptionTypes = (exceptionTypes == null) || (exceptionTypes.length == 0);
            if (!isExceptionTypes) {
                System.out.print("throws {");
                for (int i = 0; i < exceptionTypes.length; i++) {
                    if (i == exceptionTypes.length - 1) {
                        System.out.print(exceptionTypes[i].getName());
                        break;
                    }
                    System.out.print(exceptionTypes[i].getName() + ",");
                }
                System.out.println("}");
            }

            System.out.println();
        }
    }

    /**
     * 获取运行时类的带泛型的父类
     */
    @Test
    public void test2() {
        Class<Student> studentClass = Student.class;
        Type superclass = studentClass.getGenericSuperclass();
        System.out.println(superclass);
    }

    /**
     * 获取运行时类的带泛型的父类的泛型
     */
    @Test
    public void test3() {
        Class<Student> studentClass = Student.class;
        Type superclass = studentClass.getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) superclass;
//        获取泛型类型
        Type[] types = parameterizedType.getActualTypeArguments();
        for (Type i :
                types) {
//            获取泛型方法一
            System.out.println(i.getTypeName());
//            获取泛型方法二
            System.out.println(((Class)i).getName());
        }
    }
}

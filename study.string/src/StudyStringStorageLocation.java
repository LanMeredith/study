/**
 * String的实例化方式：
 * 一：通过字面量定义的方式：
 * String s1 = "javaEE"
 * 此时的s1的数据javaEE声明在方法区中的字符串常量池中
 * 二：通过new+构造器的方式
 * String s2 = new String("javaEE")
 * 此时的s2保存的地址值，是数据在堆空间中开辟空间以后对应的地址值
 *
 * 这里将会对String的储存位置进行探究
 * @author shkstart
 * @create 2021-01-11-12:44
 */
public class StudyStringStorageLocation {
    public static void main(String[] args) {
//        一到四都是储存在常量池中
        String s1 = "Hello";
        String s2 = "World";
        String s3 = "HelloWorld";
        String s4 = "Hello" + "World";
//        五到七都是储存在堆空间中
        String s5 = s1 + "World";
        String s6 = "Hello" + s2;
        String s7 = s1 + s2;
//        因为调用了intern()方法，所以八储存在常量池中
        String s8 = s5.intern();
//        final关键字修饰一个变量，则这个变量也称之为常量
        final String s9 = "Hello";
        String s10 = s9 + "World";

        System.out.println(s3 == s4);
        System.out.println(s3 != s5);
        System.out.println(s3 != s6);
        System.out.println(s3 != s7);
        System.out.println(s3 == s8);
        System.out.println(s3 == s10);
        System.out.println(s5 != s6);
        System.out.println(s5 != s7);
        System.out.println(s6 != s7);
        /*
        结论：
        1.常量与常量的拼接，结果在常量池，且常量池中不会存在相同内容的常量
        2.只要其中有一个是变量，结果就在堆空间中
        3.如果拼接的结果调用intern()方法，返回值就在常量池中
         */
    }
}

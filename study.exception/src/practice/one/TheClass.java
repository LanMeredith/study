package practice.one;

/**
 * 编写一个异常类ValueIsTooLargeException，再编写一个类为Student，该类有一个产生异常的方法speak(int i)。
 * 要求参数m的值大于50时，方法抛出一个ValueIsTooLargeException异常对象。最后编写主类，在主方法中创建Student对象，让该对象调用speak()方法。
 * @author shkstart
 * @create 2021-07-25-15:41
 */
public class TheClass {
    public static void main(String[] args) {
        Student student = new Student();
        try {
            int i = student.speak(51);
            System.out.println("该班成员有" + i + "人。");
        } catch (ValueIsTooLargeException e) {
            e.printStackTrace();
        }
    }
}

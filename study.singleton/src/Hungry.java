/**
 * @author shkstart
 * @date: 2022.09.12
 */
public class Hungry {
    /**
     * 1.私有化类的构造器
     */
    private Hungry() {
    }

    /**
     * 2.内部创建类的对象
     * 4.要求此对象也必须声明为static
     */
    private static Hungry examples = new Hungry();

    /**
     * 3.创建公共的 静态的方法，返回类的对象
     * @return
     */
    public static Hungry getExamples() {
        return examples;
    }
}

/**
 * 单例模式的懒汉式实现
 * 所谓的类的单例设计模式，就是采取一定的方法保证在整个的软件系统中，对某个类只能存在一个对象实例
 *
 * @author shkstart
 * @date: 2022.09.12
 */
public class Lazy {
    /**
     * 私有化类的构造器
     */
    private Lazy() {
    }

    /**
     * 声明当前类的对象，没有初始化
     * 此对象也必须声明为static的
     */
    private static Lazy examples = null;

    /**
     * 创建公共的 静态的方法，返回类的对象
     * @return
     */
    public static Lazy getExamples() {
        if (examples == null) {
            examples = new Lazy();
        }
        return examples;
    }
}

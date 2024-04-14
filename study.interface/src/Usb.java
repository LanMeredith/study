/**
 * 接口是一种特殊的抽象类
 * 接口里的所有方法都是抽象方法，接口中的所有属性都是常量
 *
 * 抽象类中可以包含非抽象方法，但是接口不行
 * 抽象类中的抽象方法访问类型可以是public
 * @author shkstart
 * @create 2022-09-08-9:56
 */
public interface Usb {
    /**
     * 接口中方法都是抽象方法，所以修饰符可以不写
     * 这是开始工作方法
     */
    public abstract void start();

    /**
     * 这就是省略修饰符的抽象方法
     * 结束工作方法
     */
    void stop();
}

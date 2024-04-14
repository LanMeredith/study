/**
 * 1.所谓的类的单例设计模式
 * 就是采取一定的方法保证在整个的软件系统中，对某个类只能存在一个对象实例
 * 通过私有化构造方法，只能通过get实例的方法获取对象，从而保证只存在一个对象实例
 * 优点：减少了系统性能的开销
 *
 * 2.如何实现
 * 饿汉式		vs		懒汉式
 *
 * 3.区分：
 * 饿汉式：好处是线程安全的
 * 但是对象加载时间过长
 *
 * 懒汉式：好处是可以延迟对象的创建
 * 但是以目前的写法会导致线程不安全
 * @author shkstart
 * @date: 2022.09.12
 */
public class Test {
    public static void main(String[] args) {
//        lazyOne和lazyTwo其实是同一个对象
        Lazy lazyOne = Lazy.getExamples();
        Lazy lazyTwo = Lazy.getExamples();
        System.out.println(lazyOne == lazyTwo);

//        hungryOne和hungryTwo其实也是同一个对象
        Hungry hungryOne = Hungry.getExamples();
        Hungry hungryTwo = Hungry.getExamples();
        System.out.println(hungryOne == hungryTwo);
    }
}

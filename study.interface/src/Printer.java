/**
 * 实现接口时使用implements关键字
 * 这是打印机类
 * @author shkstart
 * @create 2022-09-08-10:10
 */
public class Printer implements Usb {
    /**
     * 实现接口重写的start方法
     */
    @Override
    public void start() {
        System.out.println("打印机开始工作");
    }

    /**
     * 实现接口重写的stop方法
     */
    @Override
    public void stop() {
        System.out.println("打印机结束工作");
    }
}

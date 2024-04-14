/**
 * 这是手机类
 * 实现Usb接口
 * @author shkstart
 * @create 2022-09-08-10:12
 */
public class Phone implements Usb {
    /**
     * 实现接口重写的start方法
     */
    @Override
    public void start() {
        System.out.println("手机开机");
    }

    /**
     * 实现接口重写的stop方法
     */
    @Override
    public void stop() {
        System.out.println("手机关机");
    }
}

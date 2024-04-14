/**
 * @author shkstart
 * @create 2022-09-08-10:16
 */
public class Equipment {
    public void data(Usb usb) {
        usb.start();
        System.out.println("具体的运行过程");
        usb.stop();
    }
}

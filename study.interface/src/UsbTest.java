/**
 * 匿名对象就是没有名字的对象
 * 只通过new的动作在堆空间开辟空间
 * 却没有把堆内存空间的地址赋值给栈内存的某个变量用以存储
 *
 * 由于没有记录堆内存对象的地址值，所以只能用一次
 * @author shkstart
 * @create 2022-09-08-10:18
 */
public class UsbTest {
    public static void main(String[] args) {
        Equipment equipment = new Equipment();

//        创建了接口的非匿名实现类的非匿名对象
        Phone phone = new Phone();
        equipment.data(phone);
        System.out.println();

//        创建了接口的非匿名实现类的匿名对象
        equipment.data(new Phone());
        System.out.println();

//        创建了接口的匿名实现类的非匿名对象
        Usb printer = new Usb() {
            @Override
            public void start() {
                System.out.println("打印机开始工作");
            }

            @Override
            public void stop() {
                System.out.println("打印机结束工作");
            }
        };
        equipment.data(printer);
        System.out.println();

//        创建了接口的匿名实现类的匿名对象
        equipment.data(new Usb() {
            @Override
            public void start() {
                System.out.println("打印机开始工作");
            }

            @Override
            public void stop() {
                System.out.println("打印机结束工作");
            }
        });
    }
}

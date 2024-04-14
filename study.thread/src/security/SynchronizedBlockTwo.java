package security;

/**
 * 学习线程同步，采用继承的方式创建线程
 * 使用同步块的方式进行了线程同步
 * @author shkstart
 * @create 2020-12-24-12:34
 */
public class SynchronizedBlockTwo {
    public static void main(String[] args) {
        SSBT s1 = new SSBT();
        SSBT s2 = new SSBT();
        SSBT s3 = new SSBT();
        s1.setName("线程一");
        s2.setName("线程二");
        s3.setName("线程三");
        s1.start();
        s2.start();
        s3.start();
    }
}

class SSBT extends Thread {
    /**
     * 车票
     */
    private static int ticket = 100;
    /**
     * 设置静态的，表示唯一的Object类的对象
     */
    private static Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                if (ticket > 0) {
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(currentThread().getName() + "票数：" + ticket--);
                } else {
                    break;
                }
            }
        }
    }
}
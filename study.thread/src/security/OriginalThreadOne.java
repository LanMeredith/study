package security;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

/**
 * 学习线程同步，采用实现接口的方式创建线程
 * 这是没有考虑线程安全问题的情况下，没有进行线程同步
 * 会出现重票，错票
 * @author shkstart
 * @create 2020-12-23-22:17
 */
public class OriginalThreadOne {
    public static void main(String[] args) {
        One one = new One();
        Thread oneA = new Thread(one, "线程一");
        Thread oneB = new Thread(one, "线程二");
        Thread oneC = new Thread(one, "线程三");
        oneA.start();
        oneB.start();
        oneC.start();
    }
}

class One implements Runnable {
    /**
     * 车票，被默认共享，所以不需要加static
     */
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
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
package security;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

/**
 * 学习线程同步，采用实现接口的方式创建线程
 * 使用同步块的方式进行了线程同步
 * @author shkstart
 * @create 2020-12-24-7:47
 */
public class SynchronizedBlockOneUpgrade {
    public static void main(String[] args) {
        SSBOU ssbu = new SSBOU();
        Thread a = new Thread(ssbu,"线程一");
        Thread b = new Thread(ssbu,"线程二");
        Thread c = new Thread(ssbu,"线程三");
        a.start();
        b.start();
        c.start();
    }
}

class SSBOU implements Runnable{
//    车票
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            /*
            用实现的方式创建线程，可以用this作为同步监视器，表示当前类的对象
            且在StudySynchronizedBlockUpgrade类中只new了一个SSBU类的对象
            所以同步监视器唯一
             */
            synchronized (this){
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
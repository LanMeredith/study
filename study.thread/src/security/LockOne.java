package security;

import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

/**
 * 学习线程同步，采用实现接口的方式创建线程
 * 使用lock锁的方式进行了线程的同步
 * @author shkstart
 * @create 2020-12-28-12:21
 */
public class LockOne {
    public static void main(String[] args) {
        SLO slo = new SLO();
        Thread t1 = new Thread(slo,"线程一");
        Thread t2 = new Thread(slo,"线程二");
        t1.start();
        t2.start();
    }
}

class SLO implements Runnable {
    /**
     * 车票
     * 第一步实例化ReentrantLock
     */
    private int ticket = 100;
    ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
//                第二步调用lock()方法
                lock.lock();
                try {
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
                } finally {
//                第三步，调用解锁方法unlock()方法
                    lock.unlock();
                }
            } else {
                break;
            }
        }
    }
}
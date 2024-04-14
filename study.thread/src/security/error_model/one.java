package security.error_model;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 这里是有关线程同步问题的错误示范一
 * 来自于哔哩哔哩别人提出的问题
 * 这道题中出现了售票错误的情况
 * @author shkstart
 * @create 2021-01-14-21:59
 */
public class one {
    public static void main(String[] args) {
        Ticket t = new Ticket();
        new Thread(t, "窗口一").start();
        new Thread(t, "窗口二").start();
        new Thread(t, "窗口三").start();
    }
}

class Ticket implements Runnable {
//    车票
    private int ticket = 100;
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (ticket > 0) {
//            经过检查后发现是锁的位置放错了，正确的使用方法在study.thread.security.LockOne中
            try {
//                lock.lock();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "票号为" + ticket--);

            } finally {
//                lock.unlock();
            }
        }
    }
}

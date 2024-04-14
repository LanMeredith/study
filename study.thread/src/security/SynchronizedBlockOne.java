package security;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

/**
 * 学习线程同步，采用实现接口的方式创建线程
 * 使用同步块的方式进行了线程同步
 * @author shkstart
 * @create 2020-12-23-22:52
 */
public class SynchronizedBlockOne {
    public static void main(String[] args) {
//        在这里只new了一次SSBD类的对象，所以同步锁只有一把
        SSBO s = new SSBO();
        Thread a = new Thread(s,"线程一");
        Thread b = new Thread(s,"线程二");
        Thread c = new Thread(s,"线程三");
        a.start();
        b.start();
        c.start();
    }
}

class SSBO implements Runnable{
    /**
     * 车票，和继承创建的线程不同，这里默认为静态的，所以不需要static修饰
     */
    private int ticket = 100;
    /**
     * 在这里选择了Object类的对象充当同步锁
     */
    Object obj = new Object();
    @Override
    public void run() {
        while (true) {
            /*
            括号中的obj是同步锁，同步监视器，任何一个类的对象都可以充当锁
            要求：多个线程必须要用同一把锁
             */
            synchronized (obj){
                /*
                被synchronized大括号包括的代码块，是需要被同步的代码块。
                意为操作共享数据的代码，包含代码不可过多或者过少。
                例：将while也包含进去，则当其中一个线程操作同步代码时，其他线程只能等待，相当于是单线程。
                在进入同步代码后，会一直处于while循环，导致由一个窗口将所有的车票全部输出。
                 */
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
package security;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

/**
 * 学习线程同步，采用实现接口的方式创建线程
 * 使用了同步方法的方式进行了线程同步
 * 如果操作共享数据的代码完整的声明在一个方法中
 * 我们不妨将此方法声明同步的
 * @author shkstart
 * @create 2020-12-24-21:27
 */
public class SynchronizedMethodsOne {
    public static void main(String[] args) {
        SSMO s = new SSMO();
        Thread t1 = new Thread(s,"线程一");
        Thread t2 = new Thread(s,"线程二");
        Thread t3 = new Thread(s,"线程三");
        t1.start();
        t2.start();
        t3.start();
    }
}

class SSMO implements Runnable{
//    车票
    private int ticket = 100;
    @Override
    public void run() {
        while(true){
            drawer();
            if (ticket == 0){
                break;
            }
        }
    }
    /**
    同步方法仍涉及到同步监视器，不需要我们显示的声明
    非静态的同步方法，同步监视器是this
    静态的同步方法，同步监视器是当前类本身
     */
    private synchronized void drawer(){
        if (ticket > 0){
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(currentThread().getName() + "票数：" + ticket--);
        }
    }
}
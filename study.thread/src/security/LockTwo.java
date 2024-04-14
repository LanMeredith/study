package security;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.currentThread;

/**
 * @author shkstart
 * @create 2021-09-05-11:17
 */
public class LockTwo {
    public static void main(String[] args) {
        lt lt = new lt();

        FutureTask taskA = new FutureTask(lt);
        FutureTask taskB = new FutureTask(lt);
        FutureTask taskC = new FutureTask(lt);

        Thread threadA = new Thread(taskA);
        Thread threadB = new Thread(taskB);
        Thread threadC = new Thread(taskC);

        threadA.setName("窗口一");
        threadB.setName("窗口二");
        threadC.setName("窗口三");

        threadA.start();
        threadB.start();
        threadC.start();
    }
}

class lt implements Callable {
    private int ticket = 50;
    ReentrantLock lock = new ReentrantLock();

    @Override
    public Object call() throws Exception {
        while (true) {
            if (ticket > 0) {
                lock.lock();
                try {
                    if (ticket > 0) {
                        Thread.sleep(100);
                        System.out.println(currentThread().getName() + "票数：" + ticket--);
                    } else {
                        break;
                    }
                } finally {
                    lock.unlock();
                }
            } else {
                break;
            }
        }
        return null;
    }
}

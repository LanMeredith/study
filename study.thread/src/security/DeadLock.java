package security;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 死锁
 * 不同的线程分别占着对方需要的同步资源不放弃
 * 都在等对方放弃自己需要的同步资源，就形成了线程的死锁
 * 出现死锁后，不会出现异常，不会出现提示，只是所有的线程都处于阻塞状态，无法继续
 * 我们在使用同步时需要注意，避免出现死锁
 * @author shkstart
 * @create 2021-09-05-10:07
 */
public class DeadLock {
    public static void main(String[] args) {
        StringBuffer sbA = new StringBuffer();
        StringBuffer sbB = new StringBuffer();

        /*
        出现死锁的原因是线程一执行后占用了资源sbA
        线程二进入执行后占用了资源sbB
        线程一进行进入下一个同步锁需要得到资源sbB
        而线程二进入下一个同步资源需要得到资源sbA
        他们所需要的同步资源分别被对方占着，想要执行下一步需要线程一完成执行释放sbA，或者线程二完成执行释放sbB
         */

        new Thread(new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
//                进入同步锁，占用sbA资源
                synchronized (sbA) {
                    sbA.append('Y');
                    sbB.append('M');

//                    调用sleep是为了增大出现死锁的概率
                    Thread.sleep(100);

//                    进入同步锁，占用sbB资源
                    synchronized (sbB) {
                        sbA.append(0);
                        sbB.append(7);
                        System.out.println(sbA);
                        System.out.println(sbB);
                    }
                }
//                完成后释放sbA和sbB资源
                return null;
            }
        })).start();

        new Thread(new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
//                进入同步锁，占用sbB资源
                synchronized (sbB) {
                    sbA.append('H');
                    sbB.append('h');

//                    调用sleep是为了增大出现死锁的概率
                    Thread.sleep(100);

//                    进入同步锁，占用sbA资源
                    synchronized (sbA) {
                        sbA.append(2);
                        sbB.append(5);
                        System.out.println(sbA);
                        System.out.println(sbB);
                    }
                }
//                完成后释放sbA和sbB资源
                return null;
            }
        })).start();
    }
}

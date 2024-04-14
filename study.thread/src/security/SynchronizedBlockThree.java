package security;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import static java.lang.Thread.currentThread;

/**
 * @author shkstart
 * @create 2021-09-04-20:58
 */
public class SynchronizedBlockThree {
    public static void main(String[] args) {
        Sbt sbt = new Sbt();
        /*
        Sbt只需要创建一个实例对象，但是FutureTask需要创建多个
        后续的Thread构造方法需要传入不同的FutureTask对象才能完成多线程创建
        */
        FutureTask futureTaskA = new FutureTask(sbt);
        FutureTask futureTaskB = new FutureTask(sbt);
        FutureTask futureTaskC = new FutureTask(sbt);

        Thread threadA = new Thread(futureTaskA);
        threadA.setName("线程一");
        Thread threadB = new Thread(futureTaskB);
        threadB.setName("线程二");
        Thread threadC = new Thread(futureTaskC);
        threadC.setName("线程三");

        threadA.start();
        threadB.start();
        threadC.start();

        try {
//            此处可以采用任意FutureTask对象调用get()，结果都一样，因为Sbt只有一个实例对象
            System.out.println(futureTaskA.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class Sbt implements Callable {
    private int ticket = 100;
    private String str = "已售完";

    /**
     * 此处，Thread.sleep()不需要抛出异常，原因是call()可以throws抛出异常
     * 而我采用的是自动生成call()的方式，默认抛出的是Exception
     * 经我发现后将Exception换成了InterruptedException
     * @return
     * @throws InterruptedException
     */
    @Override
    public Object call() throws InterruptedException {
        while (true) {
//            进行两次对ticket的判断，可以让sleep不放置在同步锁中影响效率
            if (ticket > 0) {
                Thread.sleep(100);
                synchronized (this) {
                    if (ticket > 0) {
                        System.out.println(currentThread().getName() + "票数：" + ticket--);
                    } else {
                        break;
                    }
                }
            } else {
                break;
            }
        }
        return str;
    }
}
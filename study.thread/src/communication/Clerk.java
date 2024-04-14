package communication;

/**
 * 线程通信的应用，经典的生产者消费者问题
 * 生产者将产品交给店员，店员将产品售卖给消费者
 * 店员一次只能持有固定数量的产品，而生产者试图生产更多的产品时，店员会要求生生产者先停下
 * 如果店员有空位放产品了再通知生产者进行生产
 * 如果店员没有产品了，则会让消费者等下，等店员有产品了再来购买产品
 *
 * 分析：
 * 一：属于多线程问题？是，创建了生产者线程和消费者线程
 * 二：是否有共享数据？是，店员（产品）
 * 三：如何解决线程的安全问题？同步机制，有三种方法
 * 四：是否涉及线程的通信？是
 *
 * @author shkstart
 * @create 2020-12-28-20:44
 */
public class Clerk {
    /**
     * product 货量
     */
    private static int product = 0;

    /**
     * 生产产品
     * 当货量达到饱和时停止生产，不足时继续生产
     */
    public synchronized void production() {
        if (product < 20) {
            System.out.println(Thread.currentThread().getName() + "开始生产第"
                    + ++product + "个产品");
            notify();
        } else {
            try {
//                使用wait()进入阻塞后自动释放了锁
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 消费产品
     * 当有货时消费者进行消费，没货时停止消费
     */
    public void consumption() {
        synchronized (this) {
            if (product > 0) {
                System.out.println(Thread.currentThread().getName() + "开始消费第"
                        + product-- + "个产品");
                notify();
            } else {
                try {
//                    使用wait()进入阻塞后自动释放了锁
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

/**
 * 生产者
 */
class Productor implements Runnable {
    private Clerk clerk;

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "生产者开始生产……");
        while(true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.production();
        }
    }
}

/**
 * 消费者
 */
class Customer implements Runnable {
    private Clerk clerk;

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "消费者开始消费……");
        while(true){
            try {
                Thread.sleep(60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumption();
        }
    }
}
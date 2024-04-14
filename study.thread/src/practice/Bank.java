package practice;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 银行有一个账户
 * 有两个储户分别向同一个账户存三千元，每次一千，存三次，三次后打印账户余额
 * @author shkstart
 * @create 2021-09-05-11:52
 */
public class Bank implements Callable {
    private double money = 0;
    ReentrantLock lock = new ReentrantLock();

    @Override
    public Object call() throws Exception {
        lock.lock();
        try {
            for (int i = 0; i < 3; i++) {
                money += 1000;
                System.out.println(Thread.currentThread().getName() + "存入一千元");
            }
        } finally {
            lock.unlock();
        }
        return money;
    }
}

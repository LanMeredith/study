import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

/**
 * 创建线程的第二种方式：
 * 实现Runnable接口
 * 1.定义一个类，该类实现Runnable接口，并重写run()方法。
 * 2.创建该类的一个实例对象
 * 3.以这个对象为目标对象创建一个线程对象
 * 4.启动线程，调用start()。线程启动后将执行目标(target)对象的run()方法
 * 其作用为打印输出一百以内的所有奇数，每一点五秒打印一次，线程名设置为：线程一
 * @author shkstart
 * @create 2020-12-18-21:16
 */
public class StudyThreadTwo {
    public static void main(String[] args) {
        Thread thread = new Thread(new OddNumber());
        thread.start();
    }
}

class OddNumber implements Runnable {
    @Override
    public void run() {
        currentThread().setName("输出奇数的线程");
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                try {
//                    使线程睡眠millis毫秒后执行
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(currentThread().getName() + ":" + i);
            }
        }
    }
}

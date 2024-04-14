/**
 * 创建线程的第一种方式：
 * 继承Thread类
 * 1.创建一个继承自Thread类的子类
 * 2.覆写Thread类的run()方法
 * 3.创建线程类的一个对象
 * 4.通过线程类的对象调用start()方法启动线程（启动之后会自动调用覆写的run()方法执行线程）
 * 编写的第一个多线程类
 * 其作用为打印输出一百以内的所有偶数，每一点五秒打印一次，线程名设置为：线程一
 * 想要启动多个线程，则需要创建多个线程对象，已有的线程类实例在调用start()后不可再次调用start()
 * @author shkstart
 * @create 2020-12-18-13:16
 */
public class StudyThreadOne{
    public static void main(String[] args) {
//        创建线程类的一个对象
        EvenNumber e = new EvenNumber();
//        启动线程，并执行对象的run()方法
        e.start();

        /*
        如果只用一次，可以偷懒使用匿名的方式写
        example：
         */
        new Thread(){
            @Override
            public void run() {
//                设置线程优先级，因为有休眠所以看不出来
                setPriority(7);
                setName("输出奇数的线程");
                for (int i = 0; i < 100; i++) {
                    if (i % 2 != 0) {
                        try {
                            sleep(500);
                        } catch (InterruptedException interruptedException) {
                            interruptedException.printStackTrace();
                        }
                        System.out.println(getName() + ":" + i);
                    }
                    if (i == 55) {
                        try {
//                            join()在线程a中调用线程b的join()，将使线程a进入阻塞状态，直到线程b完全结束
                            e.join();
                        } catch (InterruptedException interruptedException) {
                            interruptedException.printStackTrace();
                        }
                    }
                }
            }
        }.start();
    }
}

class EvenNumber extends Thread {
    /**
     * 重写Thread类的run()方法
     */
    @Override
    public void run() {
//        设置线程优先级，因为有休眠所以看不出来
        setPriority(3);
        setName("输出偶数的线程");
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                try {
//                    使线程睡眠millis毫秒后执行
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(getName() + ":" + i);
            }
        }
//        判断线程是否存活
        System.out.println(isAlive());
    }
}

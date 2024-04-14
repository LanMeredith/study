package security;

/**
 * 学习线程同步，采用继承的方式创建线程
 * 使用同步块的方式进行了线程同步
 * @author shkstart
 * @create 2020-12-24-13:01
 */
public class SynchronizedBlockTwoUpgrade {
    public static void main(String[] args) {
        SSBTU s1 = new SSBTU();
        SSBTU s2 = new SSBTU();
        SSBTU s3 = new SSBTU();
        s1.setName("线程一");
        s2.setName("线程二");
        s3.setName("线程三");
        s1.start();
        s2.start();
        s3.start();
    }
}

class SSBTU extends Thread{
//    车票
    private static int ticket = 100;
    @Override
    public void run() {
        while (true) {
            /*
            用继承的方式创建线程，可以用当前类名.class做同步监视器
            这意味着类名.class也是一个对象（万事万物皆对象）
            类名.class相当于private static SSBTU s = new SSBTU();
            并且只会加载一次
            此处类名.class在反射中有提及，一个类只有一个Class对象
             */
            synchronized (SSBTU.class) {
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
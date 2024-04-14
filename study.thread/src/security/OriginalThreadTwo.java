package security;

/**
 * 学习线程同步
 * 这是没有考虑线程安全问题的情况下，没有进行线程同步
 * 会出现重票，错票
 * @author shkstart
 * @create 2020-12-23-22:35
 */
public class OriginalThreadTwo {
    public static void main(String[] args) {
        Two twoA = new Two();
        Two twoB = new Two();
        Two twoC = new Two();
        twoA.setName("线程一");
        twoB.setName("线程二");
        twoC.setName("线程三");
        twoA.start();
        twoB.start();
        twoC.start();
    }
}

class Two extends Thread {
    //    车票
    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
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
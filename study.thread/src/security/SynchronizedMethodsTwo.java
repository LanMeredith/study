package security;

/**
 * 学习线程同步，采用继承的方式创建线程
 * 使用了同步方法的方式进行了线程同步
 * 如果操作共享数据的代码完整的声明在一个方法中
 * 我们不妨将此方法声明同步的
 * @author shkstart
 * @create 2020-12-24-22:15
 */
public class SynchronizedMethodsTwo {
    public static void main(String[] args) {
        SSMT s1 = new SSMT();
        SSMT s2 = new SSMT();
        SSMT s3 = new SSMT();
        s1.setName("线程一");
        s2.setName("线程二");
        s3.setName("线程三");
        s1.start();
        s2.start();
        s3.start();
    }
}

class SSMT extends Thread{
//    车票
    private static int ticket = 100;

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
    因为是采用继承的方式创建线程，所以在sychronized之前还需要加static
    非静态的同步方法，同步监视器是this
    静态的同步方法，同步监视器是当前类本身
     */
    private synchronized static void drawer(){
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
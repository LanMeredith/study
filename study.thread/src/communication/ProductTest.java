package communication;

/**
 * @author shkstart
 * @create 2020-12-28-21:26
 */
public class ProductTest {
    public static void main(String[] args) {
//        这里的clerk是唯一的
        Clerk clerk = new Clerk();

        Productor p1 = new Productor(clerk);
        Customer c1 = new Customer(clerk);
        Customer c2 = new Customer(clerk);
        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(c1);
        Thread t3 = new Thread(c1);
        Thread t4 = new Thread(c2);
        t1.setName("生产者一");
        t2.setName("消费者一");
        t3.setName("消费者二");
        t4.setName("消费者三");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

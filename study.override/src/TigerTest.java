/**
 * @author shkstart
 * @date: 2022.09.11
 */
public class TigerTest {
    public static void main(String[] args) {
        Tiger tiger = new Tiger();
        tiger.setAge(15);
        tiger.setName("妞妞");

//        sleep方法没有被重写，所以调用的是Animal类中的sleep()
        tiger.sleep();
//        eat方法被重写了，所以调用的是Tiger类中被重写的eat()方法
        tiger.eat();
        tiger.speed();
    }
}

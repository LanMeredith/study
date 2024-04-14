/**
 * @author shkstart
 * @date: 2022.09.11
 */
public class Dog extends Animal{
    @Override
    public void eat() {
        System.out.println("狗需要进食维持体能，狗是一种肉食性动物。");
    }

    @Override
    public void sleep() {
        System.out.println("狗需要睡觉，一般在夜晚睡觉。");
    }
}

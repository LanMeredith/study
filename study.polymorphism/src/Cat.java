/**
 * @author shkstart
 * @date: 2022.09.11
 */
public class Cat extends Animal{
    String NAME = "猫猫";

    @Override
    public void eat() {
        System.out.println("猫需要进食维持体能，猫是一种杂食性动物。");
    }

    @Override
    public void sleep() {
        System.out.println("猫需要睡觉，但它是夜行生物，所以一般在白天睡觉。");
    }

    public void form() {
        System.out.println("众所周知猫是一种液体。");
    }
}

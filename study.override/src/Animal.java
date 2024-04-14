/**
 * 方法的重写训练
 * @author shkstart
 * @date: 2022.09.11
 */
public class Animal {
    private String name;

    public void eat() {
        System.out.println("所有的动物都需要进食");
    }

    public void sleep() {
        System.out.println("所有的动物都需要睡觉");
    }

    public Animal() {
    }

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

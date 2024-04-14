/**
 * @author shkstart
 * @date: 2022.09.11
 */
public class Tiger extends Animal {
    private int age;

    public Tiger(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println("老虎需要吃肉");
    }

    public void speed() {
        System.out.println("我叫" + getName() + "，是一头老虎，我的年龄是" + getAge() + ", 我的速度非常快");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Tiger() {
    }

    public Tiger(int age) {
        this.age = age;
    }

    public Tiger(String name, int age) {
        super(name);
        this.age = age;
    }
}

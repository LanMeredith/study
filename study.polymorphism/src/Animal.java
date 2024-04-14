/**
 * 类的多态性
 * <p>
 * 可以理解为一个事务的多种形态
 * 对象的多态性：父类的引用指向子类的对象
 * 多态性的使用：当调用子父类同名同参数的方法时，实际执行的是子类重写父类的方法——虚拟方法调用
 * 有了对象的多态性以后，我们在编译期只能调用父类中声明的方法，我们实际执行的是子类重写父类的方法
 * <p>
 * 多态性使用的前提：
 * 1.类的继承关系
 * 2.方法的重写
 * <p>
 * 总结：编译看左边，运行看右边
 * Animal animal = new Dog();
 * <p>
 * 对象的多态性只适用于方法，不适用于属性（编译和运行都看左边）
 *
 * @author shkstart
 * @date: 2022.09.11
 */
public class Animal {
    String NAME = "动物";

    public void eat() {
        System.out.println("所有动物都需要不断的进食以此维持体能。");
    }

    public void sleep() {
        System.out.println("所有动物都需要睡觉，其中一部分动物在白天睡觉。");
    }
}

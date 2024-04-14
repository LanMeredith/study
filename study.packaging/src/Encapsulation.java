/**
 * @author SeedList
 * @package PACKAGE_NAME
 * @createTime 2023/6/17 20:10
 * @Description 封装性的体现之一：我们将类的属性私有化，同时提供公共的(public)方法来获取(get)和设置(set)此属性的值
 * 用setAge()设置人的合法年龄，用getAge()返回人的年龄
 * 在测试类中实例化一个本类的对象b，调用setAge()和getAge()方法，体会java的封装性
 */
public class Encapsulation {
    /**
     * 设置一个私有的年龄，即为将类的属性私有化
     */
    private int age;

    public void setAge(int age) {
        if (age >= 0 && age <= 130) {
            /*
             * this的主要作用之一是：调用本类中的属性，也就是类中的成员变量
             * 在这里this调用的是本类中私有化的属性age，而非setAge的形参age
             * */
            this.age = age;
        } else {
            System.out.println("输入错误，请您重新输入！！！");
        }
    }

    public int getAge() {
        return age;
    }
}

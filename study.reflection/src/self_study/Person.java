package self_study;

/**
 * @author shkstart
 * @create 2021-07-07-21:57
 */
public class Person<T>{
    private String name;
    public int age;

    public void show() {
        System.out.println("你好，我是" + getName() + "，今年" + getAge() + "岁。");
    }

    private String showNation(String nation) {
        System.out.println("我的国籍是：" + nation);
        return nation;
    }

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person(int age) {
        this.age = age;
    }

    private Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 实例化后，操作原来泛型位置的结构必须与指定的泛型类型一致
     * @return
     */
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

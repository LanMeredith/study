package study.io.object;

import java.io.Serializable;

/**
 * Person需要满足如下要求，方可序列化
 * 1.需要实现接口：Serializable
 * 2.需要当前类提供一个全局常量：serialVersionUID
 * 3.除了当前Person类需要实现Serializable接口之外，还必徐保证其内部所有属性也必须是可序列化的
 * （默认情况下，基本数据类型可序列化）
 *
 * 补充：不可序列化static和transient修饰的成员变量
 * @author shkstart
 * @create 2021-03-13-15:26
 */
public class Person implements Serializable {
    public static final long serialVersionUID = 2012713669L;

    private String name;
    private int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
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

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

package three.domain;

/**
 * 员工，不可用于添加到团队中
 * @author shkstart
 * @create 2021-08-12-19:52
 */
public class Employee {
    private int id;
    private String name;
    private int age;
    private double salay;

    public Employee() {
    }

    public Employee(int id, String name, int age, double salay) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salay = salay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getSalay() {
        return salay;
    }

    public void setSalay(double salay) {
        this.salay = salay;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salay=" + salay +
                '}';
    }
}

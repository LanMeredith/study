/**
 * 编写一个Employee（员工）类，声明为抽象类
 * 包含如下三个属性，name、id、salary
 * 提供必要的构造器和方法
 * 以及一个抽象方法work()
 * @author shkstart
 * @create 2022-09-07-8:44
 */
abstract public class Employee {
    /**
     * 姓名
     * 工号
     * 薪水
     */
    private String name;
    private int id;
    private int salary;

    /**
     * 抽象方法：只有方法的声明，无方法体。
     * 包含抽象方法一定是抽象类，反之抽象类中不定有抽象方法。
     * 本抽象方法要设置的则是员工的工作内容
     */
    public abstract void work();

    public Employee() {
    }

    public Employee(String name, int id, int salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}

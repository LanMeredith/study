/**
 * 这是继承了抽象方法Employee的类，Manager为经理
 * 需要重写父类中的work抽象方法才行，否则Manager仍然是一个抽象类
 * @author shkstart
 * @create 2022-09-07-8:48
 */
public class Manager extends Employee {
    private int bons;

    @Override
    public void work() {
        System.out.println("经理管理员工");
    }

    public Manager(int bons) {
        this.bons = bons;
    }

    public Manager(String name, int id, int salary, int bons) {
        super(name, id, salary);
        this.bons = bons;
    }

    public int getBons() {
        return bons;
    }

    public void setBons(int bons) {
        this.bons = bons;
    }
}

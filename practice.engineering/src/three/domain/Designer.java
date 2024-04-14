package three.domain;

/**
 * 设计师
 * bonus 表示奖金
 * @author shkstart
 * @create 2021-08-12-19:52
 */
public class Designer extends Programmer{
    private double bonus;

    public Designer(int id, String name, int age, double salay, Equipment equipment, double bonus) {
        super(id, name, age, salay, equipment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "Designer{" +
                "bonus=" + bonus +
                "} " + super.toString();
    }
}

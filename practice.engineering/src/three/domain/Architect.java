package three.domain;

/**
 * 架构师
 * stock 表示公司奖励的股票数量
 *
 * @author shkstart
 * @create 2021-08-12-19:52
 */
public class Architect extends Designer {
    private int stock;

    public Architect(int id, String name, int age, double salay, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salay, equipment, bonus);
        this.stock = stock;
    }


    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Architect{" +
                "stock=" + stock +
                "} " + super.toString();
    }
}

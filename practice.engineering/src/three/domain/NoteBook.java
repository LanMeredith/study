package three.domain;

/**
 * 设备：笔记本
 *
 * @author shkstart
 * @create 2021-08-12-19:56
 */
public class NoteBook implements Equipment {
    /**
     * model 表示机器的型号
     * display 表示显示器名称
     * type 表示机器的类型
     * price 表示价钱
     */
    private String model;
    private double price;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public NoteBook(String model, double price) {
        this.model = model;
        this.price = price;
    }

    @Override
    public String getDescription() {
        return getModel() + "(" + getPrice() + ")";
    }
}

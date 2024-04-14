package three.domain;

/**
 * 设备：打印机
 * @author shkstart
 * @create 2021-08-12-20:00
 */
public class Printer implements Equipment{
    /**
     * model 表示机器的型号
     * display 表示显示器名称
     * type 表示机器的类型
     */
    private String name;
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Printer(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String getDescription() {
        return getName() + "(" + getType() + ")";
    }
}

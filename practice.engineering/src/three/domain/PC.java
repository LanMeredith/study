package three.domain;

/**
 * 设备：个人电脑
 * @author shkstart
 * @create 2021-08-12-19:58
 */
public class PC implements Equipment{
    /**
     * model 表示机器的型号
     * display 表示显示器名称
     * type 表示机器的类型
     */
    private String model;
    private String dispaly;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDispaly() {
        return dispaly;
    }

    public void setDispaly(String dispaly) {
        this.dispaly = dispaly;
    }

    public PC(String model, String dispaly) {
        this.model = model;
        this.dispaly = dispaly;
    }

    @Override
    public String getDescription() {
        return getModel() + "(" + getDispaly() + ")";
    }
}

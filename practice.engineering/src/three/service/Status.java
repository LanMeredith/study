package three.service;

/**
 * 枚举类，其中属性代表员工的状态
 * @author shkstart
 * @create 2021-08-12-20:36
 */
public enum Status {
    /*
    经过我修改的枚举类Status，其中
    FREE-空闲
    BUSY-已加入开发团队
    VOCATION-正在休假
    */
    FREE("FREE"), VOCATION("VOCATION"), BUSY("BUSY");

    private final String NAME;

    private Status(String name) {
        this.NAME = name;
    }

    public String getNAME() {
        return NAME;
    }

    @Override
    public String toString() {
        return NAME;
    }
}

/**
 * 有关于构造方法的练习
 * 在三角形类中声明私有的边长和高
 * 再设置公共方法访问私有变量。
 * 此外提供必要的构造器。
 * 在另一类中使用这些公共方法，计算三角形的面积
 *
 * @author shkstart
 * @create 2022-09-06-12:51
 */
public class TriAngle {
    /**
     * base 三角形的底边长
     * height 三角形的高
     */
    private double base;
    private double height;

    /**
     * 在没有定义构造方法时，系统会自动生成一个默认的无参构造方法
     * 但若是自定义了一个构造方法的话，系统就不再提供一个默认的空参构造器，所以需要自行设置以便于后续使用
     */
    public TriAngle() {
    }

    public TriAngle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}

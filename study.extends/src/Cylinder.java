import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @author shkstart
 * @create 2022-09-08-9:20
 */
public class Cylinder extends Circle {
    private double height;

    /**
     * 计算圆柱体体积
     * @return 圆柱体积
     */
    public double findVolume() {
        return findArea() * height;
    }

    public Cylinder() {
    }

    public Cylinder(double height) {
        this.height = height;
    }

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}

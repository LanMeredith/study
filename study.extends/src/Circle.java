import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @author shkstart
 * @create 2022-09-08-9:05
 */
public class Circle {
    private double radius;

    /**
     * 计算圆的面积，设置保留两位小数，四舍五入模式
     * @return 圆形面积
     */
    public double findArea() {
        return Math.pow(radius, 2) * Math.PI;
    }

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}

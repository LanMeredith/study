import java.util.Objects;

/**
 * @author shkstart
 * @create 2022-09-08-11:01
 */
public class Circle extends GeometricObject {
    private double radius;

    /**
     * @return 面积
     */
    public double findArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    /**
     * @return 圆的半径
     */
    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                "} ";
    }

    /**
     * 重写equals方法，比较两个圆的半径是否相等，如相等则返回true
     * 这只是比较半径，不是常规的equals方法比较
     * @param obj 比较对象
     * @return 比较结果
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Circle circle = (Circle) obj;
        return Double.doubleToLongBits(this.radius) != Double.doubleToLongBits(circle.radius);
    }

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(String color, double weight, double radius) {
        super(color, weight);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}

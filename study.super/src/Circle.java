/**
 * @author SeedList
 * @package PACKAGE_NAME
 * @createTime 2023/6/17 20:21
 * @Description
 */
public class Circle {
    /**
     * 半径
     */
    private double radius;

    /**
     * @param
     * @return
     * @author SeedList
     * @createTime 2023/6/17 20:21
     * @Name Circle
     * @throw
     * @Description 构造器，将radius属性初始化值为1
     */
    public Circle() {
        super();
        radius = 1;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * @param
     * @return double
     * @author SeedList
     * @createTime 2023/6/17 20:21
     * @Name findArea
     * @throw
     * @Description 计算圆的面积
     */
    public double findArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}

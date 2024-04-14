/**
 * @author SeedList
 * @package PACKAGE_NAME
 * @createTime 2023/6/17 20:22
 * @Description
 */
public class Cylinder extends Circle{
    private double length;

    public Cylinder() {
        super();
        length = 1;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double findVolume() {
        return super.findArea() * getLength();
    }

    @Override
    public double findArea() {
        return 2 * super.findArea() + 2 * Math.PI * getRadius() * getLength();
    }
}

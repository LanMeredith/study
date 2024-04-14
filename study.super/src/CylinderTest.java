import java.text.DecimalFormat;

/**
 * @author SeedList
 * @package PACKAGE_NAME
 * @createTime 2023/6/17 20:22
 * @Description
 */
public class CylinderTest {
    public static void main(String[] args) {

        DecimalFormat df = new DecimalFormat("#0.00");

        Cylinder c = new Cylinder();
        c.setRadius(3);
        c.setLength(2);
        System.out.println(df.format(c.findArea()));
        System.out.println(df.format(c.findVolume()));

        Cylinder c2 = new Cylinder();
        System.out.println(df.format(c2.findArea()));
        System.out.println(df.format(c2.findVolume()));
    }
}

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @author shkstart
 * @create 2022-09-08-9:26
 */
public class CylinderTest {
    public static void main(String[] args) {
//        通过DecimalFormat设置保留两位小数
        DecimalFormat df = new DecimalFormat("0.00");
//        四舍五入模式
        df.setRoundingMode(RoundingMode.HALF_UP);

        Cylinder cylinderOne = new Cylinder();
        cylinderOne.setRadius(45.2);
        cylinderOne.setHeight(42.1);
//        DecimalFormat类的format方法返回的是String类型
        System.out.println(df.format(cylinderOne.findVolume()));

        Cylinder cylinderTwo = new Cylinder(12.3, 51.4);
        System.out.println(df.format(cylinderTwo.findVolume()));
    }
}

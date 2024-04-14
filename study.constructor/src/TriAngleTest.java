import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @author shkstart
 * @create 2022-09-06-12:56
 */
public class TriAngleTest {
    public static void main(String[] args) {
//        DecimalFormat类可以将数字格式化成需要的样子。
//        主要靠#和0来指定数字长度，0表示位数不足则以0进行填充，#表示只要有可能就把数字拉上这个位置
        DecimalFormat df = new DecimalFormat("0.00");
//        设置为四舍五入模式
        df.setRoundingMode(RoundingMode.HALF_UP);

        TriAngle one = new TriAngle();
        one.setBase(5);
        one.setHeight(7);
//        DecimalFormat类的format方法返回的是String类型
        System.out.println("第一个三角形one的面积是：" + df.format(one.getBase() * one.getHeight() / 2));

        TriAngle two = new TriAngle(1.5, 9.3);
        System.out.println("第二个三角形two的面积是：" + df.format(two.getBase() * two.getHeight() / 2));
    }
}

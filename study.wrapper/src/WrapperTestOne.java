/**
 * @author SeedList
 * @package PACKAGE_NAME
 * @createTime 2023/6/17 20:27
 * @Description
 */
public class WrapperTestOne {
    public static void main(String[] args) {
        WrapperTestOne wt = new WrapperTestOne();
        wt.test1();
    }

    public void test1() {
//        基本数据类型==>包装类：调用包装类的构造器
        int num1 = 10;
        Integer in1 = new Integer(num1);
        Integer in2 = new Integer("123");
        System.out.println(in1);
        System.out.println(in2);
        System.out.println(new Integer(20).toString());
        System.out.println();

        double num2 = 2.4;
        Double do1 = new Double(num2);
        Double do2 = new Double("2.7");
        Double do3 = new Double(2.2d);
        Double do4 = new Double(2.7f);
        Float fl1 = new Float(3.4f);
        System.out.println(do1);
        System.out.println(do2);
        System.out.println(do3);
        System.out.println(do4);
        System.out.println(fl1);
        System.out.println();

        Boolean bo1 = new Boolean(true);
        Boolean bo2 = new Boolean("true");
        Boolean bo3 = new Boolean("true123");
        System.out.println(bo1);
        System.out.println(bo2);
        System.out.println(bo3);
        System.out.println();
    }
}

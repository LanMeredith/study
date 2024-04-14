/**
 * @author SeedList
 * @package PACKAGE_NAME
 * @createTime 2023/6/17 20:28
 * @Description
 */
public class WrapperTestTwo {
    public static void main(String[] args) {
        WrapperTestTwo wt = new WrapperTestTwo();
        wt.test1();
    }

    public void test1() {
//        包装类==>基本数据类型：调用包装类xxx的xxxValue()
        Integer in1 = new Integer(29);
        int i1 = in1.intValue();
        System.out.println(i1 + 1);

        System.out.println(new Integer(26).intValue());

        System.out.println(new Double(2.5).doubleValue());
    }
}

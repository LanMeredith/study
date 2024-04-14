/**
 * @author SeedList
 * @package PACKAGE_NAME
 * @createTime 2023/6/17 20:27
 * @Description
 */
public class WrapperTestThree {
    public static void main(String[] args) {
        WrapperTestThree wt = new WrapperTestThree();
        wt.test1();
        wt.test2();
    }

    public void test1() {
        /*
         * 基本数据类型，包装类=>String
         * 方法一：直接运算
         * */
        int num1 = 10;
        String str1 = num1 + "";
        System.out.println(str1);
        System.out.println();

//        方法二：调用String重载的ValueOf(XXX xxx)
        String str2 = String.valueOf(num1) + "asd" + 123;
        System.out.println(str2);
        String str3 = String.valueOf(new Double(5.4));
        System.out.println(str3);
        System.out.println();
    }

    public void test2() {
        /*
         * String=>基本数据类型，包装类
         * 调用包装类的parsexxx()
         * */
        String str4 = "123";
        int num2 = Integer.parseInt(str4);
        System.out.println(num2);
        System.out.println();
    }
}

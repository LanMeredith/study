/**
 * @author SeedList
 * @package PACKAGE_NAME
 * @createTime 2023/6/17 20:23
 * @Description
 */
public class Automatic {
    public static void main(String[] args) {
        Automatic a = new Automatic();
        a.test1();
    }

    public void test1() {
//        自动装箱，实现的是基本数据类型==>包装类
        int num1 = 10;
//        自动装箱
        Integer in1 = num1;

//        自动拆箱，实现的是包装类==>基本数据类型
        int num2 = in1;//自动拆箱

        /*
         * Integer内部定义了IntegerCache结构
         * IntegerCache中定义了Integer[]
         * 保存了从-128~127范围内的整数
         * 如果我们用自动装箱的方法
         * 给Integer赋值在-128~127范围内时，可以直接使用数组中的元素，不用new
         */
        Integer in2 = 11;
        Integer in3 = 11;
        System.out.println(in2 == in3);//true

        Integer in4 = 128;
        Integer in5 = 128;
//        这里相当于new了一个新的对象Integer，比较两个对象的地址值不相等，所以返回false
        System.out.println(in4 == in5);
//        true
        System.out.println(in4.equals(in5));
    }
}

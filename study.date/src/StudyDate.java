import java.util.Date;

/**
 * java.util.Date
 *         -->java.sql.Date
 * 子父类关系
 *
 * 两个构造器的使用
 *      构造器一：Date()创建一个对应当前时间的Date对象
 *      构造器二：创建指定毫秒数的Date()对象
 *
 * 两个方法的使用
 *      toString()：显示当前的年月日时分秒
 *      getTime()：获取当前Date对应的毫秒数。（时间戳）
 *
 * java.sql.Date对应着数据库中的日期类型的变量
 *      如何实例化
 *      如何将java.util.Date转换为java.sql.Date对象
 * @author shkstart
 * @create 2021-01-13-14:26
 */
public class StudyDate {
    public static void main(String[] args) {
//        创建Date的对象
        Date date1 = new Date();
//        显示当前的年月日时分秒
        System.out.println(date1.toString());
//        获取当前Date对应的毫秒数
        System.out.println(date1.getTime());

//        创建指定毫秒数的Date对象date2
        Date date2 = new Date(1236716418436L);
//        显示指定毫秒数的date2对应的年月日时分秒
        System.out.println(date2.toString());

        java.sql.Date date3 = new java.sql.Date(182738917231L);
        System.out.println(date3.toString());

//        将java.util.Date转换为java.sql.Date对象的方法一
        Date date4 = new java.sql.Date(213412434134L);

//        将java.util.Date转换为java.sql.Date对象的方法二
        java.sql.Date date5 = new java.sql.Date(date1.getTime());
    }
}

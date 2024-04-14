import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * JDK8之后的时间API
 * localDate、localTime、localDateTime
 * DateTimeFormatter
 * @author shkstart
 * @create 2021-01-16-13:58
 */
public class StudyJDK8DateTime {

    /*
    LocalDate、LocalTime、LocalDateTime的使用

    说明：
    1.LocalDateTime相较于LocalDate、LocalTime使用频率更高一些
    2.具有不可变性
     */
    @Test
    public void test1(){
//        now()获取当前的日期、时间、日期+时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

//        of()设置指定的年月日时分秒，无偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 2, 16, 14, 25, 30);
        System.out.println(localDateTime1);

//        getXXX()  类似于Calendar的get()方法可以获取属性信息
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getMinute());
        System.out.println(localDateTime.getMonth());

//        withXXX()    类似于Calendar的set()方法可以设置属性信息
//        体现不可变性
        LocalDate localDate1 = localDate.withDayOfMonth(22);
        System.out.println(localDate.getDayOfMonth());
        System.out.println(localDate1.getDayOfMonth());

//        plusXXX()     类似于Calendar对属性信息进行加法修改
        LocalDate localDate2 = localDate.plusDays(4);
        System.out.println(localDate);
        System.out.println(localDate2);

//        minus()       类似于Calendar对属性信息进行减法修改
        LocalTime localTime1 = localTime.minusMinutes(50);
        System.out.println(localTime);
        System.out.println(localTime1);
    }
}

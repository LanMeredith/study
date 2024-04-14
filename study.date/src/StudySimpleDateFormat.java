import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * jdk8之前的日期时间的API测试
 * 1.
 * System类中currentTimeMillis();
 * System.out.println(System.currentTimeMillis());
 * 2.java.util.Date和java.sql.Date
 * 3.SimpleDateFormat
 * 4.Calendar
 * @author shkstart
 * @create 2021-01-15-13:51
 */
public class StudySimpleDateFormat {
    /*
    SimpleDateFormat的使用：SimpleDateFormat对日期Date类的格式化和解析

    1.两个操作
    1.1格式化      日期=>指定格式的字符串
    1.2解析        格式化的逆过程，指定格式的字符串=>日期

    2.SimpleDateFormat的实例化
     */

    @Test
    public void testSimpleDateFormatone(){
//        使用默认的构造器实例化SimpleDateFormat
        SimpleDateFormat sdfone = new SimpleDateFormat();

        Date date = new Date();
//        等同于打印date.toString()
        System.out.println(date);

//        格式化   日期=>指定格式的字符串
        String format = sdfone.format(date);
        System.out.println(format);

        String str = "21-1-15 下午2:34";
        try {
//        解析    格式化的逆过程，指定格式的字符串=>日期
//            可能会识别不了str
            Date date1 = sdfone.parse(str);
            System.out.println(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSSimpleDateFormattwo(){
//        使用指定的方式格式化和解析：调用带参数的构造器
        SimpleDateFormat sdftwo = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = new Date();

//        格式化
        String format = sdftwo.format(date);
        System.out.println(format);

        try {
//            解析；要求字符串的格式必须是符合SimpleDateFormat识别的格式（通过构造器参数体现）
            Date date1 = sdftwo.parse("2000-07-25 12:12:12");
            System.out.println(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

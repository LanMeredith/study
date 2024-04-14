import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * DateTimeFormatter格式化或解析日期、时间
 * 类似于SimpleDateFormat
 * 重点是实例化方式三：自定义的格式
 * @author shkstart
 * @create 2021-01-16-15:59
 */
public class StudyDateTimeFormatter {
    /**
     * 实例化方式一：
     */
    @Test
    public void test1(){
//        预定义的标准格式
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

//        格式化   日期=>字符串
        String str = dateTimeFormatter.format(localDateTime);
        System.out.println(str);

//        解析    字符串=>日期
        TemporalAccessor temporalAccessor1 = dateTimeFormatter.parse("2021-01-16T16:09:56.729");
        TemporalAccessor temporalAccessor2 = dateTimeFormatter.parse(str);
        System.out.println(temporalAccessor1);
        System.out.println(temporalAccessor2);
    }

//    实例化方式二
    @Test
    public void test2(){
//        本地化相关的格式
//        例如：ofLocalizedDate()
//        FormatStyle.FULL / FormatStyle.LONG / FormatStyle.SHORT / FormatStyle.MEDIUM : 适用于LocalDateTime
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

//        格式化
        String str = dateTimeFormatter.format(localDateTime);
        System.out.println(str);
    }

    /**
     * 实例化方式三
     */
    @Test
    public void test3(){
//        重点：自定义的格式！！！
//        如：ofPattern("yyyy-MM-dd hh:mm:ss E");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");

//        格式化
        String str = dateTimeFormatter.format(LocalDateTime.now());
        System.out.println(str);

//        解析
        TemporalAccessor parse = dateTimeFormatter.parse("2021-01-16 04:33:28");
        System.out.println(parse);
    }
}

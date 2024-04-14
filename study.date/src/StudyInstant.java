import org.junit.Test;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * Instant的使用
 * 类似于java.util.Date
 * @author shkstart
 * @create 2021-01-16-15:37
 */
public class StudyInstant {
    @Test
    public void test(){
//        now()获取本初子午线对应的标准时间
        Instant instant = Instant.now();
        System.out.println(instant);

//        添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

//        toEpochMilli()获取自1970年1月1日0时0分0秒（UTC）开始的毫秒数
        long milli = instant.toEpochMilli();
        System.out.println(milli);

//        通过给定的毫秒数，获取Instant实例
        Instant instant1 = Instant.ofEpochMilli(156479871546456L);
        System.out.println(instant1);
    }
}

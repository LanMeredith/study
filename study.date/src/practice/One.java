package practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 练习一：
 * 字符串“2020-2-15”转换为java.sql.Date
 * @author shkstart
 * @create 2021-01-15-16:13
 */
public class One {
    public static void main(String[] args) {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        try {
//            解析，先将字符串转换成java.util.Date类型
            Date date = sdf1.parse("2020-02-15");
//            再将java.sql.Date转换成java.sql.Date类型
            java.sql.Date sqldate = new java.sql.Date(date.getTime());
            System.out.println(sqldate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

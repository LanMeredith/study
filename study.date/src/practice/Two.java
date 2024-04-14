package practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 三条打鱼两天晒网
 * 计算某某某天时，渔夫在打鱼还是在晒网
 * @author shkstart
 * @create 2021-01-15-16:43
 */
public class Two {
    public static void main(String[] args) {
        String start = "1990-01-01";
        String day = "2020-2-15";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date datestart = sdf.parse(start);
            Date dateday = sdf.parse(day);
            int i = (int)(dateday.getTime() - datestart.getTime()) / (24 * 60 * 60 * 1000) + 1;
            switch (i%5){
                case 1:
                case 2:
                case 3:
                    System.out.println("打鱼");
                    break;
                case 4:
                case 0:
                    System.out.println("晒网");
                    break;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

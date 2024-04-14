import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Calendar日历类是一个抽象基类，主用用于完成日期字段之间相互操作的功能
 * 获取Calendar实例的方法
 * 1.使用Calendar.getInstance()方法
 * 2.调用它的子类GregorianCalendar的构造器
 *
 * 注意：
 * 1.获取月份时，一月是0，二月是1……
 * 1.获取星期时，星期天是1，星期一是2……星期六是7
 * @author shkstart
 * @create 2021-01-16-12:41
 */
public class StudyCalendar {
    public static void main(String[] args) {
//        实例化Calendar，方式一：使用Calendar.getInstance()方法
        Calendar calendar1 = Calendar.getInstance();
//        实际上还是由GregorianCalendar类创建的对象
        System.out.println(calendar1.getClass());

//        方式二：调用它的子类GregorianCalendar的构造器
        Calendar calendar2 = new GregorianCalendar();

//        常用方法
//        get()可以获取常用的属性信息
        int i = calendar1.get(Calendar.DAY_OF_MONTH);
        System.out.println(i);
        System.out.println(calendar1.get(Calendar.DAY_OF_YEAR));

//        set()可以对属性信息进行修改，修改过后，calendar1相应的所有属性都被修改
//        这里修改的是DAY_OF_MONTH，实际上DAY_OF_YEAR也随之修改
        calendar1.set(Calendar.DAY_OF_MONTH,22);
        System.out.println(calendar1.get(Calendar.DAY_OF_MONTH));

//        add()方法对属性信息进行加法修改
        calendar1.add(Calendar.DAY_OF_YEAR,-4);
        System.out.println(calendar1.get(Calendar.DAY_OF_YEAR));

//        getTime()     日历类=>Date
        Date date1 = calendar1.getTime();
        System.out.println(date1);

//        setTime()     Date=>日历类
        Date date2 = new Date();
        calendar1.setTime(date2);
        System.out.println(calendar1.get(Calendar.DAY_OF_YEAR));
    }
}

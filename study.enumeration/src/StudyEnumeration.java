/**
 * 枚举类的使用：
 * 1.枚举类的理解：类的对象只有有限个，确定的。我们称此类为枚举类
 * 2.当需要定义一组常量时，强烈建议使用枚举类
 * 3.如果枚举类中只有一个对象，则可以作为单例模式的实现方式
 *
 * 二：如何定义枚举类
 * 方式一：jdk5.0之前，自定义枚举类
 * 方式二：jdk5.0之后，可以使用enum关键字定义枚举类
 * @author shkstart
 * @create 2021-01-17-17:11
 */
public class StudyEnumeration {
    public static void main(String[] args) {
        StudyFirst spring = StudyFirst.SPRING;
        System.out.println(spring);
    }
}


//自定义枚举类
class StudyFirst{
//    1.声明StudyFirst对象的属性：需要用private final修饰
//    名
    private final String name;
//    描述
    private final String desc;

//    2.私有化类的构造器，并给对象属性赋值
    private StudyFirst(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

//    3.提供当前枚举类的多个对象：public static final的修饰
    public static final StudyFirst SPRING = new StudyFirst("春天","春暖花开");
    public static final StudyFirst SUNMER = new StudyFirst("夏天","酷热炎炎");
    public static final StudyFirst AUTUMN = new StudyFirst("秋天","风清气爽");
    public static final StudyFirst WINTER = new StudyFirst("冬天","冰天雪地");

//    4.其他诉求：获取枚举类对象的属性
    public String getName() {
        return name;
    }
    public String getDesc() {
        return desc;
    }

//    4.其他诉求：提供toString()
    @Override
    public String toString() {
        return "StudyFirst{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
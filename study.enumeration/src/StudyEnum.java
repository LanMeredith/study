/**
 * 使用enum关键字来定义枚举类
 * 说明：定义的枚举类默认继承于java.lang.Enum类
 *
 * Enum类中的常用方法
 * 1.values()方法：返回枚举类型的对象数组。该方法可以很方便地遍历所有枚举值
 * 2.valuesOf(String str)方法：可以把一个字符串转为对应的枚举类对象。
 * 要求字符串必须是枚举类对象的“名字”。如果不是，将会有运行时异常IllegalArgumentException
 * 3.toString()方法：返回当前枚举类对象常量的名称
 *
 * @author shkstart
 * @create 2021-01-18-13:22
 */
public class StudyEnum {
    public static void main(String[] args) {
        StudySecond sunmer = StudySecond.SUNMER;
//        若是不重写toString方法，则使用的是Enum类的toString方法
        System.out.println(sunmer);

//        查询StudySecond类的父类
        System.out.println(StudySecond.class.getSuperclass());

        StudySecond[] values = StudySecond.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }

        System.out.println("**********************");
//        查看线程的状态，遍历线程所有的状态
        Thread.State[] states = Thread.State.values();
        for (int i = 0; i < states.length; i++) {
            System.out.println(states[i]);
        }

        System.out.println("************************");
        StudySecond autumn = StudySecond.valueOf("AUTUMN");
        System.out.println(autumn);
    }
}


//使用enum关键字新建枚举类
enum StudySecond{
    //    3.提供当前枚举类的对象，多个对象之间用逗号隔开，最后用分号
    SPRING("春天","春暖花开"),
    SUNMER("夏天","酷热炎炎"),
    AUTUMN("秋天","风清气爽"),
    WINTER("冬天","冰天雪地");

    //    1.声明StudyFirst对象的属性：需要用private final修饰
    private final String name;
    private final String desc;

    //    2.私有化类的构造器，并给对象属性赋值
    private StudySecond(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

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
        return "StudySecond{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
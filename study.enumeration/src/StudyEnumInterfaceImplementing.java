/**
 * 使用enum关键字定义的枚举类实现接口的情况
 * 情况一：实现接口，在enum类中实现抽象方法
 * 情况二；让枚举类的对象分别去实现接口中的抽象方法
 * @author shkstart
 * @create 2021-01-18-13:54
 */
public class StudyEnumInterfaceImplementing {
    public static void main(String[] args) {
        StudyThird winter = StudyThird.WINTER;
        winter.show();
    }
}

//定义一个接口
interface Info{
    void show();
}

enum StudyThird implements Info {
    //    3.提供当前枚举类的对象，多个对象之间用逗号隔开，最后用分号
    SPRING("春天", "春暖花开"){
        @Override
        public void show() {
            System.out.println("这是春天");
        }
    },
    SUNMER("夏天", "酷热炎炎"){
        @Override
        public void show() {
            System.out.println("这是夏天");
        }
    },
    AUTUMN("秋天", "风清气爽"){
        @Override
        public void show() {
            System.out.println("这是秋天");
        }
    },
    WINTER("冬天", "冰天雪地"){
        @Override
        public void show() {
            System.out.println("这是冬天");
        }
    };

    //    1.声明StudyFirst对象的属性：需要用private final修饰
    private final String name;
    private final String desc;

    //    2.私有化类的构造器，并给对象属性赋值
    private StudyThird(String name, String desc) {
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
        return "StudyThird{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

//    重写接口中的show()方法
//    @Override
//    public void show() {
//        System.out.println("这是一个季节");
//    }
}
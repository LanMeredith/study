package self_study;

/**
 * @author shkstart
 * @create 2021-07-22-22:55
 */
@MyAnnotation(value = "学习学习学习！！！")
public class Student extends Person<String> implements Study {
    public String school;
    public int myclass;
    private int studyid;

    public Student() {
    }

    private Student(String school) {
        this.school = school;
    }

    public Student(String name, int age, String school) {
        super(name, age);
        this.school = school;
    }

    @MyAnnotation
    public Student(int myclass) {
        this.myclass = myclass;
    }

    @MyAnnotation(value = "hi")
    private Student(String school, String name) {
        super(name, 18);
        this.school = school;
    }

    @MyAnnotation(value = "测试AdvancedPractice中的test1()")
    private void showtime() {
        System.out.println("你好，我是" + getName() + "，今年" + getAge() + "岁。在" + getSchool() + "读书。");
    }

    private String showtime(String str) {
        System.out.println("用于测试Practice类中的指定方法getDeclaredMethod()，这是传入的参数：" + str);
        return str;
    }

    private static int showtime(int grade) {
        System.out.println("如何调用静态的方法呢？这是传入的参数年级：" + grade);
        return grade;
    }

    private void newShowTime(int age, String name) throws NullPointerException, ClassCastException {
        System.out.println("这里是用于测试AdvancedPractice中的test1()");
    }

    public int getMyclass() {
        return myclass;
    }

    public void setMyclass(int myclass) {
        this.myclass = myclass;
    }

    public int getStudyid() {
        return studyid;
    }

    public void setStudyid(int studyid) {
        this.studyid = studyid;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "school='" + school + '\'' +
                "} " + super.toString();
    }
}

package practice;

import java.util.Objects;
import java.util.TreeSet;

/**
 * 请把学生的姓名与考试分数录入到集合中，并按分数显示前三名成绩学员的名字
 * @author shkstart
 * @create 2021-01-29-13:25
 */
public class Four {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet();
        treeSet.add(new Student("颜铭鹤",90,193056277));
        treeSet.add(new Student("袁经睿",92,193056567));
        treeSet.add(new Student("徐隆威",93,193021317));
        treeSet.add(new Student("杨帆",98,193012345));
        treeSet.add(new Student("谢传鹏",90,112345673));
        treeSet.add(new Student("邓金亮",97,123213213));
        treeSet.add(new Student("张罡",88,132422423));
        treeSet.add(new Student("刘佳欣",100,193243324));
        treeSet.add(new Student("师勇",89,12323133));

        Object[] array = treeSet.toArray();
        for (int i = 0; i < 3; i++) {
            System.out.println(array[i]);
        }
    }
}

class Student implements Comparable{
//    姓名
    String name;
//    成绩
    double score;
//    学号
    int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student() {
    }

    public Student(String name, double score, int id) {
        this.name = name;
        this.score = score;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Double.compare(student.score, score) == 0 && id == student.id && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score, id);
    }

    /**
     * 按照成绩排名，如果成绩相同则按照姓名排
     * @param o
     * @return
     */
    @Override
    public int compareTo(Object o) {
        if(o instanceof Student){
            Student stu = (Student) o;
            if(Double.compare(this.score, stu.score) == 0){
                return this.name.compareTo(stu.name);
            }else{
                return -Double.compare(this.score, stu.score);
            }
        }
        throw new RuntimeException("传入的数据类型不一致！");
    }
}
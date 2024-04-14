import java.util.Scanner;
import java.util.Vector;

/**
 * @author SeedList
 * @package PACKAGE_NAME
 * @createTime 2023/6/17 20:25
 * @Description
 */
public class ScoreTest {
    public static void main(String[] args) {
//        实例化Scanner，用于从键盘获取学生成绩
        Scanner sc = new Scanner(System.in);
//        创建Vector对象，Vector v = new Vector();相当于原来的数组
        Vector v = new Vector();
//        最高分
        int max = 0;

//        通过循环的方式给Vector中添加数组
        while (true) {
            System.out.println("请输入学生成绩（当输入为负数时表示结束）：");
            int score = sc.nextInt();

//            当输入负数时跳出循环
            if (score < 0) {
                break;
            }

            if (score > 100) {
                System.out.println("输入的数据非法！请重新输入!");
//                用于提前结束本次循环，跳过循环体剩余语句，直接进行下一次循环
                continue;
            }

            /*
             * 自动装箱，若是在jdk5.0之前，则需要先写Integer in = new Integer(score);
             * 再写v.addElement(in);多态
             * */
            v.addElement(score);

//            获取学生的最高分
            if (max < score) {
                max = score;
            }
        }

//        学生等级
        char level;
        for (int i = 0; i < v.size(); i++) {
            Object obj = v.elementAt(i);
            /*
             * jdk5.0之前
             * Integer inScore = (Integer)obj;向下转型downcasting
             * int score = inScore.intValue();
             * jdk5.0之后
             * */
            int score = (int) obj;

            if (max - score < 10) {
                level = 'A';
            } else if (max - score <= 20) {
                level = 'B';
            } else if (max - score <= 20) {
                level = 'C';
            } else {
                level = 'D';
            }

            System.out.println("student:" + i + "score is" + score + ",level is" + level);
        }
    }
}

package practice;

import org.junit.Test;
import queryResults.ExamStudent;
import util.Universal;

import java.util.Scanner;

/**
 * 1.对examstudent数据表插入一个新的student信息
 * 2.通过考生号或身份证号进行查询
 * 3.删除一条记录
 *
 * @author shkstart
 * @date: 2022.10.01
 */
public class Two {
    /**
     * 1.对examstudent数据表插入一个新的student信息
     */
    @Test
    public void testOne() {
        String sql = "insert into examstudent (Type,IDCard,ExamCard,StudentName,Location,Grade) values (?,?,?,?,?,?)";
        int value = Universal.update(sql, 4, "362429200007254316", "202223164754000", "SeedList", "九江", 442);

        if (value > 0) {
            System.out.println("操作成功");
        } else {
            System.out.println("操作失败");
        }
    }

    /**
     * 2.通过考生号或身份证号进行查询
     */
    @Test
    public void testTwo() {
        Scanner scanner = new Scanner(System.in);
        ExamStudent student = null;

        while (true) {
            System.out.println("请选择您要输入的类型");
            System.out.println("a:准考证号");
            System.out.println("b:身份证号");
            char choose = scanner.nextLine().charAt(0);

            if (choose == 'a') {
                System.out.println("请输入准考证号");
                String examCard = scanner.nextLine();

                String sql = "select FlowID flowID,Type type,IDCard,ExamCard examCard,StudentName studentName,Location location,Grade grade from examstudent where examCard = ?";

                student = Universal.aQuery(ExamStudent.class, sql, examCard);
                break;
            } else if (choose == 'b') {
                System.out.println("请输入身份证号");
                String IDCard = scanner.nextLine();

                String sql = "select FlowID flowID,Type type,IDCard,ExamCard examCard,StudentName studentName,Location location,Grade grade from examstudent where IDCard = ?";

                student = Universal.aQuery(ExamStudent.class, sql, IDCard);
                break;
            } else {
                System.out.println("您的输入有误，请重新进入程序");
                continue;
            }
        }

        if (student != null) {
            System.out.println("===查询结果===");
            System.out.println("流水号:" + student.getFlowID());
            System.out.println("四级/六级:" + student.getType());
            System.out.println("身份证号:" + student.getIDCard());
            System.out.println("准考证号:" + student.getExamCard());
            System.out.println("学生姓名:" + student.getStudentName());
            System.out.println("区域:" + student.getLocation());
            System.out.println("成绩:" + student.getGrade());
        } else {
            System.out.println("===查询结果===");
            System.out.println("查无此人");
        }
    }

    /**
     * 3.删除一条记录
     */
    @Test
    public void testThree() {
        System.out.println("请输入准考证号");
        Scanner scanner = new Scanner(System.in);
        String examCard = scanner.nextLine();

        String sql = "delete from examstudent where ExamCard = ?";
        int value = Universal.update(sql, examCard);

        if (value > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }
}

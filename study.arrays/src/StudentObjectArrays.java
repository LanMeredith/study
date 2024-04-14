/**
 * 对象数组
 * @author shkstart
 * @create 2022-09-04-15:12
 */
public class StudentObjectArrays {
    public static void main(String[] args) {
//        创建对象数组，需要注意设置对象数组的长度
        Student[] students = new Student[20];
//        利用循环对学生数组填充内容
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student();
            students[i].id = i + 1;
//            random()返回0<=n<1之间的随机实数n，此处加一是因为年级不可以为0
            students[i].state = (int) (Math.random() * 6 + 1);
//            此处不加1是因为成绩可以为0
            students[i].score = (int) (Math.random() * 101);
        }

//        找出三年级学生
        for (int i = 0; i < students.length; i++) {
            if (students[i].state == 3) {
                System.out.println("此三年级学生的学号是：" + students[i].id + "，成绩是：" + students[i].score);
            }
        }

        System.out.println("以下为按成绩排名后");
//        冒泡排序法需要循环数组长度减一次
        for (int i = 0; i < students.length - 1; i++) {
//            每一次循环需要比较数组长度减一次
            for (int j = 0; j < students.length - 1; j++) {
//                如果发现前一个元素比后一个元素大，则进行交换。
                if (students[j].score > students[j + 1].score) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }

//        打印排序后的成绩
        for (int i = 0; i < students.length; i++) {
            System.out.println("学号：" + students[i].id + "\t年级：" + students[i].state + "\t成绩：" + students[i].score);
        }
    }
}

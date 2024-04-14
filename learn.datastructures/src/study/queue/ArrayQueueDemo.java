package study.queue;

import java.util.Scanner;

/**
 * @author shkstart
 * @create 2021-09-04-11:18
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
//        接受用户输入
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean isloop = true;

//        输出一个菜单
        while (isloop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头部数据");
//            接收第一个字符
            key = scanner.next().charAt(0);

            switch (key) {
                case 's':
                    queue.showAQueue();
                    break;
                case 'e':
                    scanner.close();
                    isloop = false;
                    break;
                case 'a':
                    System.out.println("请输入数据");
                    int n = scanner.nextInt();
                    queue.addQueue(n);
                    break;
                case 'g':
                    try {
                        int x = queue.getQueue();
                        System.out.println("取出的数据为:x = " + x);
                    } catch (RuntimeException e) {
                        e.printStackTrace();
                    } finally {
                        break;
                    }
                case 'h':
                    try {
                        int y = queue.headQueue();
                        System.out.println("队列头部数据为:y = " + y);
                    } catch (RuntimeException e) {
                        e.printStackTrace();
                    } finally {
                        break;
                    }
                default:
                    break;
            }
        }
    }
}

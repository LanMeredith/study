package study.linkedLIst.Singly.practice;

import study.linkedLIst.Singly.HeroNode;
import study.linkedLIst.Singly.HeroNodeLinkedList;

/**
 * 我们可以写一个接口来完成同样的操作
 * @author shkstart
 * @create 2021-09-10-15:32
 */
public interface GetSumTwo {
    /**
     * 因为接口中的全局常量修饰固定，故可以省略不写
     * 抽象方法也可以省略不写
     * @param hnll
     * @return
     */
    static int getInstance(HeroNodeLinkedList hnll) {
        HeroNode temp = hnll.head;
        int i = 0;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
            i++;
        }
        return i;
    }
}

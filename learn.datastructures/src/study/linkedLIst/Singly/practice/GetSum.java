package study.linkedLIst.Singly.practice;

import study.linkedLIst.Singly.HeroNode;
import study.linkedLIst.Singly.HeroNodeLinkedList;

/**
 * 获取单链表的节点的个数
 * @author shkstart
 * @create 2021-09-10-15:03
 */
public class GetSum {

    public HeroNodeLinkedList hnll;

    public GetSum(HeroNodeLinkedList hnll) {
        this.hnll = hnll;
    }

    public int getHnllSum() {
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

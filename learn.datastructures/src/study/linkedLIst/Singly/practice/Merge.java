package study.linkedLIst.Singly.practice;

import study.linkedLIst.Singly.HeroNode;
import study.linkedLIst.Singly.HeroNodeLinkedList;

/**
 * 合并两个有序的单链表，合并后依然有序
 *
 * @author shkstart
 * @create 2021-09-11-19:48
 */
public class Merge extends ReverseTraversal {

    public HeroNodeLinkedList secondary;

    /**
     * 调用方法传入的两条单链表，以第一条为主，将第二条单链表中的节点信息以此插入到第一条单链表中
     *
     * @param hnll
     * @param secondary
     */
    public Merge(HeroNodeLinkedList hnll, HeroNodeLinkedList secondary) {
        super(hnll);
        this.secondary = secondary;
    }

    public HeroNodeLinkedList merge() {
        while (true) {
//            得到单链表中的最后一个节点
            HeroNode temp = secondary.head;
            while (true) {
                if (temp.next.next == null) {
                    break;
                }
                temp = temp.next;
            }
            hnll.add(temp.next);
            temp.next = null;
            if (secondary.head.next == null) {
                break;
            }
        }
        return hnll;
    }
}

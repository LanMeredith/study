package study.linkedLIst.Singly.practice;

import study.linkedLIst.Singly.HeroNode;
import study.linkedLIst.Singly.HeroNodeLinkedList;

/**
 * 第二种实现单链表反转的方法
 *
 * 与第一种方法有所不同，我们不需要调用button()
 * 也可以对单链表的节点进行修改
 * @author shkstart
 * @create 2021-09-11-15:53
 */
public class ReverseTwo {

    public HeroNodeLinkedList hnll;

    public ReverseTwo(HeroNodeLinkedList hnll) {
        this.hnll = hnll;
    }

    public HeroNodeLinkedList reverseTwo(){
        HeroNodeLinkedList heroNodeLinkedList = new HeroNodeLinkedList();
        HeroNode temp = heroNodeLinkedList.head;
        while (true) {
            /*
            此处思路有所不同，我们要取出的不是原单链表中的最后一个节点，而是倒数第二个节点
            将倒数第二个节点的next属性赋给新单链表的节点后，将其修改为null
            原单链表减少一个节点
             */
            HeroNode temptwo = hnll.head;
            if (temptwo.next == null) {
                break;
            } else {
                while (true) {
                    if (temptwo.next.next == null) {
                        break;
                    }
                    temptwo = temptwo.next;
                }
            }

            temp.next = temptwo.next;
            temptwo.next = null;
            if (temp.next != null) {
                temp = temp.next;
            }
        }
        return heroNodeLinkedList;
    }
}

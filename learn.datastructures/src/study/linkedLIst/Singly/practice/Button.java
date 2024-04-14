package study.linkedLIst.Singly.practice;

import study.linkedLIst.Singly.HeroNode;
import study.linkedLIst.Singly.HeroNodeLinkedList;

/**
 * 查找单链表中的倒数第k个节点
 *
 * @author shkstart
 * @create 2021-09-10-15:10
 */
public class Button extends GetSum {

    public int sum = getHnllSum();

    public Button(HeroNodeLinkedList hnll) {
        super(hnll);
    }

    public HeroNode button(int k){
        if (sum >= k) {
            HeroNode temp = hnll.head;
            for (int i = 0; i <= sum - k; i++) {
                temp = temp.next;
            }
            return temp;
        } else {
            return null;
        }
    }
}

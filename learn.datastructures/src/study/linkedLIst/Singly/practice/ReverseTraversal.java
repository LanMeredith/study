package study.linkedLIst.Singly.practice;

import study.linkedLIst.Singly.HeroNode;
import study.linkedLIst.Singly.HeroNodeLinkedList;

import java.util.Stack;

/**
 * 从尾到头打印单链表
 * 不建议反转单链表，若要反转的单链表过大，会导致占用大量运行资源
 * 建议使用stack栈进行
 * stack特点：先进后出
 *
 * @author shkstart
 * @create 2021-09-11-16:35
 */
public class ReverseTraversal extends Reverse {

    public ReverseTraversal(HeroNodeLinkedList hnll) {
        super(hnll);
    }

    public void RTraversal() {
        Stack<HeroNode> stack = new Stack<>();
        HeroNode temp = hnll.head;
        if (temp.next == null) {
            System.out.println("单链表为空");
        } else {
            while (true) {
                if (temp.next == null) {
                    break;
                }
                temp = temp.next;
//                添加进stack栈
                stack.add(temp);
            }
        }
        while (stack.size() > 0) {
//            pop()就是将栈顶的数据取出
            System.out.println(stack.pop().toString());
        }
    }
}

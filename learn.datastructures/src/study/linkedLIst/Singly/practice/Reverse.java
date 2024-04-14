package study.linkedLIst.Singly.practice;

import study.linkedLIst.Singly.HeroNode;
import study.linkedLIst.Singly.HeroNodeLinkedList;

/**
 * 单链表的反转
 * 创建一个新的链表，对这个链表进行添加
 * 添加的节点是原链表的末尾
 * 将原链表进行遍历，当处于最后一个节点时，将其摘下，添加到新链表中
 * @author shkstart
 * @create 2021-09-10-15:51
 */
public class Reverse extends Button {

    public int hnllSum = getHnllSum();

    public Reverse(HeroNodeLinkedList hnll) {
        super(hnll);
    }

    public HeroNodeLinkedList reverse() {
        HeroNodeLinkedList linkedList = new HeroNodeLinkedList();
        for (int i = 0; i < hnllSum; i++) {
            HeroNode temp = linkedList.head;
            while (true) {
                if (temp.next == null) {
                    break;
                }
                temp = temp.next;
            }
            /*
            在此处的犯错历程：
            1.button()参数传值为hnllSum
            解析：由于button()的作用是查找单链表中的倒数第K个值
            而我们要做的又是将单链表进行反转，所以第一步要查找的应该是单链表中的最后一个值
            传入hnllSum会导致查找指向单链表的第一个值

            2.没有将查找出来的值的next属性归为null
            example：现在单链表中有两个值分别是x与y，x.next = y
            当我们将y添加入新单链表中，将不会出现问题，因为y.next = null
            但是在进行下一步添加时，会产生错误
            y.next修改为x，而x.next没有受到修改仍然指向y
            从而导致进行循环判断是否抵达链表尾部时出现死循环无法跳出

            3.当发现问题2后添加了操作，将x.next归于null
            这又导致我出现了一个新的错误，角标越界
            因为对象是   引用数据类型  ，我们虽然获取了button()的返回值
            但其返回值仍然指引向对象x
            即对返回值的.next属性进行修改将会直接作用到对象x上
            当我们把x.next属性修改为null后
            单链表就会减少一个节点，再次获取节点个数也会减一
            单链表“长度”的改变导致了我对button()操作时，获取到的节点不再是我目标的节点
            在单链表“长度”不断减少后，再次调用button()就会出现角标越界错误
            example：原单链表长度为5
            操作两次后，对节点四的next属性修改为null
            原单链表长度改变为4
            此时再调用button()就是对倒数第三个节点进行操作
            即将顺数第二个节点的next属性修改为null
            单链表长度改变为2
            再调用一个button()对倒数第四个节点进行操作
            长度为2的单链表显然不会有倒数第四个节点，因此报错角标越界
             */
            HeroNode button = button(i + 1);
            HeroNode node = new HeroNode(button.no, button.name, button.nickName);
            temp.next = node;
        }
        return linkedList;
    }
}

package study.linkedLIst.Singly;

import java.util.Scanner;

import study.linkedLIst.Singly.practice.*;

/**
 * @author shkstart
 * @create 2021-09-08-19:11
 */
public class Demo implements GetSumTwo {
    public static void main(String[] args) {
        HeroNodeLinkedList linkedList = new HeroNodeLinkedList();

        HeroNode heroNode = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode1 = new HeroNode(5, "卢俊义", "玉麒麟");
        HeroNode heroNode2 = new HeroNode(9, "李逵", "黑旋风");
        HeroNode heroNode3 = new HeroNode(21, "林冲", "豹子头");
        HeroNode heroNode4 = new HeroNode(108, "鲁智深", "花和尚");

        linkedList.add(heroNode2);
        linkedList.add(heroNode1);
        linkedList.add(heroNode4);
        linkedList.add(heroNode3);
        linkedList.add(heroNode);

//        删除no为108的节点
        linkedList.delete(108);

//        修改no为9和108的节点
        linkedList.modify(9, "花荣", "小李广");
        linkedList.modify(108, "段景住", "金毛犬");

//        遍历输出单链表所有节点
        linkedList.traverse();

//        获取单链表节点总数
        Reverse reverse = new Reverse(linkedList);
        int sum = reverse.getHnllSum();
        System.out.println("单链表linkedList中的节点个数是：" + sum);

//        获取单链表倒数第K个节点
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入K的值");
        int k = sc.nextInt();
        HeroNode node = reverse.button(k);
        if (node == null) {
            System.out.println("查找失败，但链表长度不足");
        } else {
            System.out.println(node.toString());
        }

//        使用接口也可以实现这些操作，如通过接口获取单链表节点总数
        System.out.println(GetSumTwo.getInstance(linkedList));

//        将单链表反转
        System.out.println("单链表的反转方式一：");
        HeroNodeLinkedList nodeLinkedList = reverse.reverse();
        nodeLinkedList.traverse();

        System.out.println("单链表的反转方式二：");
        ReverseTwo reverseTwo = new ReverseTwo(nodeLinkedList);
        reverseTwo.reverseTwo().traverse();

//        此时再看先后进行反转的单链表
        System.out.println("两种反转单链表的方式不同，第一种反转方式对原单链表不会产生破坏");
        linkedList.traverse();
        System.out.println("两种反转单链表的方式不同，第二种反转方式会将原单链表的所有节点删除");
        nodeLinkedList.traverse();

//        从尾到头遍历单链表
        ReverseTraversal traversal = new ReverseTraversal(linkedList);
        traversal.RTraversal();

//        合并两条单链表，先创建另一条单链表
        HeroNodeLinkedList temporaryList = new HeroNodeLinkedList();
        HeroNode heroNode5 = new HeroNode(12, "朱仝", "美髯公");
        HeroNode heroNode6 = new HeroNode(14, "武松", "行者");
        HeroNode heroNode7 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode8 = new HeroNode(21, "刘唐", "赤发鬼");
        HeroNode heroNode9 = new HeroNode(20, "戴宗", "神行太保");
        temporaryList.add(heroNode5);
        temporaryList.add(heroNode6);
        temporaryList.add(heroNode7);
        temporaryList.add(heroNode8);
        temporaryList.add(heroNode9);

//        合并两条单链表
        Merge merge = new Merge(linkedList, temporaryList);
        HeroNodeLinkedList heroNodeLinkedList = merge.merge();
        heroNodeLinkedList.traverse();
    }
}

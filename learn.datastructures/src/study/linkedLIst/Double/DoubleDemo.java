package study.linkedLIst.Double;

/**
 * 测试双链表
 * @author shkstart
 * @create 2021-09-12-15:16
 */
public class DoubleDemo {
    public static void main(String[] args) {
        DoubleLinkedList linkedList = new DoubleLinkedList();

        HeroNodeDouble heroNode = new HeroNodeDouble(1, "宋江", "及时雨");
        HeroNodeDouble heroNode1 = new HeroNodeDouble(5, "卢俊义", "玉麒麟");
        HeroNodeDouble heroNode2 = new HeroNodeDouble(9, "李逵", "黑旋风");
        HeroNodeDouble heroNode3 = new HeroNodeDouble(21, "林冲", "豹子头");
        HeroNodeDouble heroNode4 = new HeroNodeDouble(108, "鲁智深", "花和尚");

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
    }
}

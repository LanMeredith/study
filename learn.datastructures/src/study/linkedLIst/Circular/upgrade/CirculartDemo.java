package study.linkedLIst.Circular.upgrade;

/**
 * 双向环形链表测试
 * @author shkstart
 * @create 2021-09-23-14:46
 */
public class CirculartDemo {
    public static void main(String[] args) {
        GirlCircularLinkedList linkedList = new GirlCircularLinkedList();
        Girl girl = new Girl(1, "萧子婧", 21);
        Girl girl1 = new Girl(5, "彦茗", 25);
        Girl girl2 = new Girl(81, "萧乡", 45);
        Girl girl3 = new Girl(61, "金倩倩", 21);
        Girl girl4 = new Girl(31, "刘佳欣", 18);
        Girl girl5 = new Girl(61, "董明珠", 60);

        linkedList.addGirl(girl3);
        linkedList.addGirl(girl1);
        linkedList.addGirl(girl2);
        linkedList.addGirl(girl4);
        linkedList.addGirl(girl);
        linkedList.addGirl(girl5);

//        删除ID为108的节点
        linkedList.delete(108);

//        对ID为2和31的节点进行修改
        linkedList.modify(2, "宋婷", 18);
        linkedList.modify(31, "欣欣", 18);

//        遍历
        linkedList.traverse();
    }
}

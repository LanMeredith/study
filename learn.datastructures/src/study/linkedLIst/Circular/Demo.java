package study.linkedLIst.Circular;

/**
 * @author shkstart
 * @create 2021-09-22-21:26
 */
public class Demo {
    public static void main(String[] args) {
        BoyCircularLinkedList linkedList = new BoyCircularLinkedList();
        linkedList.addBoy(10);
        linkedList.addBoy(5);
        linkedList.traverse();

        System.out.println();

        Josephu josephu = new Josephu();
//        josephu.teacher(linkedList,3);
        josephu.MyMethods(linkedList, 4);
    }
}

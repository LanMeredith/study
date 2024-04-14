package study.linkedLIst.Circular;

/**
 * Josephu问题
 * 设编号为1、2、3……n的n个人围坐一圈，约定编号为k(1<=k<=n)的人从1开始报数
 * 数到m的那个人出列，他的下一位又从1开始报数，数到m的那个人又出列
 * 以此类推，直到所有人出列为止，由此产生一个出队编号的序列
 * <p>
 * 提示：
 * 用一个不带头节点的循环链表来处理Josephu问题：
 * 先构成一个有n个节点的单向循环链表，然后由k节点起，从1开始计数，直到最后一个节点从链表中删除算法结束
 * <p>
 * 这一问题有两种解决方法，一种是老师教的方法，另一种则是我自己想出来的
 *
 * @author shkstart
 * @create 2021-09-22-20:27
 */
public class Josephu {
    /**
     * 这是依照老师教的思路实现的
     * @param linkedList
     * @param m
     */
    public void teacher(BoyCircularLinkedList linkedList,int m) {
        int sum = linkedList.sum();
//          以单向链表的经验，要让某一节点出圈则要定位到此节点的前一位，即最后一个节点，因为最后一个节点的next指向frist
        Boy temp = linkedList.end();
        Boy first = linkedList.first;

        for (int i = 0; i < sum; i++) {
            /*
            因为报数要从first开始，即first为1
            当开始报数，就让temp和first同时移动m-1次
            此时first就是要出圈的节点
             */
            for (int j = 0; j < (m - 1); j++) {
                first = first.next;
                temp = temp.next;
            }

//           输入first
            System.out.println(first.toString());
//            让first移动，指向下一个节点
            first = first.next;
//            将temp的next指向现first，原来first指向的节点没有任何引用，会被收回
            temp.next = first;
        }
    }

    /**
     * 这是我自己想出来的方法
     * @param linkedList
     * @param m
     */
    public void MyMethods(BoyCircularLinkedList linkedList,int m){
        Boy temp = linkedList.first;

        while (temp.next != temp) {
            /*
            要让某一节点出圈则要定位到此节点的前一位
            报数是从temp开始
            综合起来则让temp移动m-2次
            此处的temp更想是老师教的方法中的temp
             */
            for (int j = 0; j < (m - 2); j++) {
                temp = temp.next;
            }
            System.out.println(temp.next.toString());
            temp.next = temp.next.next;
//            因为下次报数是从出列的节点的下一位开始，所以需要让first后移一位
            temp = temp.next;
        }
    }
}

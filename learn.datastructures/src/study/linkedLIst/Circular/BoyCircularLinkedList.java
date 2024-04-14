package study.linkedLIst.Circular;

/**
 * 环形链表
 * @author shkstart
 * @create 2021-09-22-20:41
 */
public class BoyCircularLinkedList {
    /**
     * 创建一个辅助指针（变量）作用是指向环形链表中的第一个节点
     */
    public Boy first = null;

    /**
     * 向环形链表内添加指定个数的节点
     * 每个新增的节点会被放置到最后
     * 由最后一个节点指向第一个节点完成闭环
     */
    public void addBoy(int num) {
//        先判断要添加的个数是否符合规范，若不符合规范则直接退出此方法
        if (num < 1) {
            System.out.println("num的值不正确");
            return;
        }

        /*
        若是符合规范，则进行添加，由于first指向的是第一个节点，不可动
        所以创建一个辅助指针temp，指向位置从第一个节点开始不断后移，每次指向的都是环形链表的最后一个节点
        此处调用了end()方法，目的是反复调用addBoy方法时可以让temp直接指向最后一个节点
        若环形链表中无节点时，end()返回的是null
        */
        Boy temp = end();
//        获取环形链表的长度
        int sum = sum();
        for (int i = 0; i < num; i++) {
//            根据编号创建boy节点
            Boy boy = new Boy(sum + 1 + i);
//            如果环形链表为空，要加入的是第一个boy节点，则让first指向该节点
            if (first == null) {
                first = boy;
//                构成环形链表
                first.next = first;
//                在环形链表为空的情况下让temp指向first
                temp = first;
            } else {
//                若不是第一个节点的话，则让最后一个节点的next属性指向要添加的boy节点
                temp.next = boy;
//                此后boy节点成了链表的最后一个节点，让boy的next指向第一个节点完成闭环
                boy.next = first;
//                辅助指针往后移动
                temp = temp.next;
            }
        }
    }

    /**
     * 遍历环形链表
     * 有返回值是为了返回最后一个节点，利于addBoy()方法在多次调用时直接从最后一个节点处添加
     * @return
     */
    public void traverse(){
//        创建一个辅助指针，指针从指向first开始遍历
        Boy temp = first;
        if (temp == null) {
            System.out.println("链表为空");
            return;
        } else {
            while (true) {
//                 因为temp指向的第一个节点是包含信息的，所以需要先输出再后移
                System.out.println(temp.toString());
//                说明已经遍历完毕
                if (temp.next == first) {
                    break;
                }
                temp = temp.next;
            }
        }
    }

    /**
     * 返回当前链表的最后一个节点
     * @return
     */
    public Boy end(){
//        创建一个辅助指针，指针从指向first开始遍历
        Boy temp = first;
        if (temp == null) {
            return null;
        } else {
            while (true) {
//                说明已经遍历完毕
                if (temp.next == first) {
                    break;
                }
                temp = temp.next;
            }
            return temp;
        }
    }

    /**
     * 获取环形链表中的节点数
     * @return
     */
    public int sum(){
        int sum = 0;
        Boy temp = first;
        if (temp == null) {
            return sum;
        } else {
            while (true) {
                sum++;
                if (temp.next == first) {
                    break;
                }
                temp = temp.next;
            }
            return sum;
        }
    }
}

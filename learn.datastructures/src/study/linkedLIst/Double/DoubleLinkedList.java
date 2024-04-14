package study.linkedLIst.Double;

/**
 * 双链表的学习
 *
 * @author shkstart
 * @create 2021-09-12-14:18
 */
public class DoubleLinkedList {

    public HeroNodeDouble head = new HeroNodeDouble(0, "", "");

    /**
     * 双链表的添加操作
     * 因为是双链表，需要对前一个节点的next属性，后一个节点的pre属性，以及要添加节点的next与pre属性进行操作
     * 所以一共需要四步
     * 同时应该注意对下一节点的操作的前提是其不为null
     * temp指向的是要插入位置的前一个位置
     *
     * @param herNodeDouble
     */
    public void add(HeroNodeDouble herNodeDouble) {
        HeroNodeDouble temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > herNodeDouble.no) {
                break;
            }
            temp = temp.next;
        }
//        将上一个节点的next赋给要插入节点的next
        herNodeDouble.next = temp.next;
//        将上一个节点的next属性修改为要插入节点
        temp.next = herNodeDouble;
//        将要插入节点的pre属性修改为上一个节点
        herNodeDouble.pre = temp;

//        因为上一个节点的next无法指向原下一个节点，所以只能通过要插入节点的next属性指向
        if (herNodeDouble.next != null) {
//        如果下一个节点存在而非null，那么就需要将下一个节点的pre属性修改为要插入节点
            herNodeDouble.next.pre = herNodeDouble;
        }
    }

    /**
     * 双链表的遍历操作，与单链表无异
     */
    public void traverse() {
        HeroNodeDouble temp = head;
        if (temp.next == null) {
            System.out.println("单链表为空");
        } else {
            while (true) {
                if (temp.next == null) {
                    break;
                }
                temp = temp.next;
                System.out.println(temp.toString());
            }
        }
    }

    /**
     * 双链表的删除操作，和单链表有所不同，双链表可以实现自我删除
     * 可以直接定位到    删除节点    ，而非删除节点的前一个节点
     *
     * @param no
     */
    public void delete(int no) {
        HeroNodeDouble temp = head;
//        设置一个布尔值isThere，若没有找到相应的节点则为false
        boolean isThere = false;
        while (true) {
            if (temp.next == null) {
                break;
            }

            temp = temp.next;

//            若找到了相应的节点则对isThere进行修改
            if (temp.no == no) {
                isThere = true;
                break;
            }
        }

        if (isThere) {
//            因为temp定位的是要删除节点，所以需要考虑要删除节点后是否为最后一个节点
            if (temp.next != null) {
//            temp是要删除节点，让temp的上一个节点的next属性指向下一个节点，下一个节点的pre属性指向上一个节点
                temp.pre.next = temp.next;
                temp.next.pre = temp.pre;
            } else {
                temp.pre.next = null;
            }
            System.out.println("删除成功，已将" + no + "的相应节点删除");
        } else {
            System.out.println("删除失败，没有任意节点no值与要删除节点的no相等");
        }
    }

    /**
     * 因为是要对已有的节点进行修改，所以可以直接定位到    要修改节点
     * 思路与单链表修改方法一致
     * 根据结果判断是否要进行修改，若需要修改则进行修改
     * 若不存在此节点，则进行添加操作，将信息作为一个节点加入单链表中
     *
     * @param no
     * @param name
     * @param nickName
     */
    public void modify(int no, String name, String nickName) {
        HeroNodeDouble temp = head;
//        设置一个布尔值isThere，若没有找到相应的节点则为false
        boolean isThere = false;
        while (true) {
            if (temp.next == null) {
                break;
            }

            temp = temp.next;

//            若找到了相应的节点则对isThere进行修改
            if (temp.no == no) {
                isThere = true;
                break;
            }
        }

        if (isThere) {
            temp.name = name;
            temp.nickName = nickName;
            System.out.println("修改成功，已将" + no + "的相应节点内容修改");
        } else {
            System.out.println("修改失败，没有任意节点no值与要删除节点的no相等。");
            add(new HeroNodeDouble(no, name, nickName));
            System.out.println("我们执行了添加操作，将此节点加入链表中");
        }
    }
}

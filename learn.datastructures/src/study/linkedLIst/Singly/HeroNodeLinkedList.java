package study.linkedLIst.Singly;

/**
 * 这是一个可以实现按no顺序添加的单链表
 *
 * @author shkstart
 * @create 2021-09-08-19:05
 */
public class HeroNodeLinkedList {
    /**
     * 初始化一个头节点，这一节点可以存入数据，但存入的数据并不一定满足我们后续对单链表的需求
     * 所以为了更方便的操作单链表
     * 不建议头节点存放任何数据
     */
    public HeroNode head = new HeroNode(0, "", "");

    /**
     * 添加节点到单向列表中
     * 思路：
     * 头节点不能动，创建一个temp作为辅助变量（指针）来指向当前节点
     * temp从指向头节点开始
     * 先判断temp的next是否为空，若为空则已抵达链表尾部
     * 若不为空，则再进行判断，temp的next的no属性是否大于要插入节点的no属性
     * 若大于，则在temp后插入
     * 若不大于，则将temp向后移
     *
     * @param heroNode
     */
    public void add(HeroNode heroNode) {
        HeroNode temp = head;
//        判断是否需要执行修改操作
        boolean isModify = false;
        while (true) {
            if (temp.next == null) {
                break;
            }

            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                isModify = true;
                break;
            }
            temp = temp.next;
        }
        if (isModify) {
//                若是要添加的节点的属性值no已经存在于单链表中，则对该节点信息进行修改
            modify(heroNode.no, heroNode.name, heroNode.nickName);
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    /**
     * 单链表的遍历操作
     * 思路大体和添加一样，无需对no属性进行判断
     * 只需要确认当前是否为链表尾即可
     * 若不为链表尾，则向后移动一位，将节点信息输出
     * 先后移再输出是因为temp从头节点开始，而头节点无信息
     */
    public void traverse() {
        HeroNode temp = head;
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
     * 删除指定节点，索引依据是节点内容no的值
     * 思路：
     * 先找到要删除节点的    前一个节点！
     * temp.next = temp.next.next;
     * 被删除的节点，将不会有其他引用指向，会被垃圾回收机制回收
     * 比较时，比较的节点中的no
     *
     * @param no
     */
    public void delete(int no) {
        HeroNode temp = head;
//        设置一个布尔值isThere，若没有找到相应的节点则为false
        boolean isThere = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
//            若找到了相应的节点则对isThere进行修改
            if (temp.next.no == no) {
                isThere = true;
                break;
            }
            temp = temp.next;
        }

        if (isThere) {
            temp.next = temp.next.next;
            System.out.println("删除成功，已将" + no + "的相应节点删除");
        } else {
            System.out.println("删除失败，没有任意节点no值与要删除节点的no相等");
        }
    }

    /**
     * 修改
     * 根据节点中的属性no进行修改
     * 先找到要修改的节点，大体思路与前几个方法类似
     * 因为是对已有节点进行修改，所以可以直接定位到    要修改的节点
     * 根据结果判断是否要进行修改，若需要修改则进行修改
     * 若不存在此节点，则进行添加操作，将信息作为一个节点加入单链表中
     */
    public void modify(int no, String name, String nickName) {
        HeroNode temp = head;
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
            add(new HeroNode(no, name, nickName));
            System.out.println("我们执行了添加操作，将此节点加入链表中");
        }
    }
}

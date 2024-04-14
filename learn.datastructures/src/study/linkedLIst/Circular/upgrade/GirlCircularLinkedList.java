package study.linkedLIst.Circular.upgrade;

/**
 * 双向环形链表
 * 要求：
 * 实现双向环形链表
 * 插入的节点将依照编号排序
 * 实现指定节点出圈的操作
 * 实现指定节点的修改操作
 * 实现环形链表的遍历操作
 *
 * @author shkstart
 * @create 2021-09-23-13:30
 */
public class GirlCircularLinkedList {
    public Girl first = null;

    /**
     * 按照ID编号添加一个新的节点
     *
     * @param girl
     */
    public void addGirl(Girl girl) {
//        首先判断first是否为空，若为空则说明环形链表为空（因为这是一个无头节点的环形链表，所以first指向的是链表的起点，此处以ID为排序标准）
        if (first == null) {
            first = girl;
//            完成双向环形链表的闭环
            first.setNext(first);
            first.setPre(first);
        } else {
            /*
            若first不为空的话则说明此环形链表中已有节点
            则根据ID编号从小到大的顺序进行添加
            先判断要添加进去的节点ID是否小于first节点ID
            若是小于的话，则需要将此节点添加到first之前
            并且移动first，让其指向ID更小的节点
            原因：
            这是无头节点的双向环形链表，所以first指向的节点不能保证其ID就是最小的一个
            当出现更小的ID时，我们需要进行调整，确保整个环形链表中first指向的就是ID最小的节点
             */
            if (girl.getId() < first.getId()) {
                girl.setNext(first);
                girl.setPre(first.getPre());
                first.getPre().setNext(girl);
                first.setPre(girl);
                first = girl;
            } else {
//                如果这个环形链表中有节点的话，就创建一个辅助指针，从first开始对比每个节点的ID与要插入节点的ID
                Girl temp = first;
                while (true) {
//                    如果发现要插入节点的ID已存在，则执行修改操作
                    if (girl.getId() == temp.getId()) {
                        System.out.println("要添加节点已存在，已对原节点进行修改");
                        temp.setAge(girl.getAge());
                        temp.setName(girl.getName());
                        break;
                    } else if (girl.getId() < temp.getId()) {
//                        若temp节点的ID大于要插入节点的ID则将其插入到temp之前
                        girl.setNext(temp);
                        girl.setPre(temp.getPre());
                        temp.getPre().setNext(girl);
                        temp.setPre(girl);
                        break;
                    } else if (temp.getNext() == first) {
//                        若是抵达最后一个节点，则插入在最后一个位置
                        girl.setNext(first);
                        girl.setPre(temp);
                        first.setPre(girl);
                        temp.setNext(girl);
                        break;
                    }
                    temp = temp.getNext();
                }
            }
        }
    }

    /**
     * 遍历双向环形链表
     */
    public void traverse() {
        if (first == null) {
            System.out.println("此链表为空");
        } else {
            Girl temp = first;
            while (true) {
//                因为没有头节点，所以first指向的节点包含数据，我们也要将其打印出来，所以先打印，后判断，再移动
                System.out.println(temp.toString());
                if (temp.getNext() == first) {
                    break;
                }
                temp = temp.getNext();
            }
        }
    }

    /**
     * 双向环形链表的删除操作，temp直接定位到要删除节点，实现自我删除
     *
     * @param id
     * @return
     */
    public Girl delete(int id) {
        if (first == null) {
            System.out.println("此链表为空");
            return null;
        } else {
            Girl temp = first;
            while (true) {
//                因为这是环形链表，所以找到要删除节点后，不需要考虑这一节点是否为最后一个节点，可以直接进行自我删除
                if (temp.getId() == id) {
                    temp.getPre().setNext(temp.getNext());
                    temp.getNext().setPre(temp.getPre());
                    return temp;
                }
                if (temp.getNext() == first) {
                    System.out.println("无相对应ID的节点");
                    return null;
                }
                temp = temp.getNext();
            }
        }
    }

    public void modify(int id, String name, int age) {
        if (first == null) {
            System.out.println("此链表为空");
        } else {
            Girl temp = first;
            while (true) {
                if (temp.getId() == id) {
                    temp.setName(name);
                    temp.setAge(age);
                    break;
                }
//                如果没有找到相应的节点，就执行添加操作
                if (temp.getNext() == first) {
                    System.out.println("未找到相应节点，已执行添加操作");
                    addGirl(new Girl(id, name, age));
                    break;
                }
                temp = temp.getNext();
            }
        }
    }
}

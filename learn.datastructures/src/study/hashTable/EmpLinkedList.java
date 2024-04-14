package study.hashTable;

/**
 * @author shkstart
 * @create 2021-11-06-15:13
 */
public class EmpLinkedList {
    /**
     * 头指针，执行第一个Emp，因此我们这个链表的head是直接指向第一个Emp的
     * 与之前学的单链表不同，之前学的单链表头节点是空的
     * 此时head默认为null
     */
    private Emp head;

    /**
     * 添加雇员到链表中
     * notice：
     * 1.假定，当添加雇员时，id是自增长，即id的分配总是从小到大
     * 因此我们将该雇员直接加入到本链表的最后即可
     *
     * @param emp
     */
    public void add(Emp emp) {
//        判断头指针是否为空，若为空则直接添加到头指针即可
        if (head == null) {
            head = emp;
            return;
        }

//        判断是否要对头指针进行更改
        if (head.id > emp.id) {
            emp.next = head;
            head = emp;
            return;
        }
//        若头指针不为空，且不需要对头指针进行更改，则创建一个辅助指针curEmp
        Emp curEmp = head;
        while (true) {
//            如果抵达了链表的最后一位，则直接将emp添加进链表
            if (curEmp.next == null) {
                curEmp.next = emp;
                break;
            } else if (curEmp.next.id > emp.id) {
//                如果指针curEmp的下一位的id大于要添加emp的id，则将emp插入到curEmp后面
                emp.next = curEmp.next;
                curEmp.next = emp.next;
                break;
            }
            curEmp = curEmp.next;
        }
    }

    /**
     * 修改雇员信息
     * @param emp
     */
    public void amend(Emp emp) {
//        辅助指针
        Emp curEmp = head;
        while (true) {
//            如果已经到了链表尾部，说明没有符合条件的节点，进行添加操作
            if (curEmp == null) {
                add(emp);
                return;
            }
//            如果找到了相应的节点，则进行修改
            if (curEmp.id == emp.id) {
                curEmp.name = emp.name;
                break;
            }
            curEmp = curEmp.next;
        }
    }

    /**
     * 遍历单链表
     */
    public void list(int no) {
        if (head == null) {
            System.out.println("第" + (no + 1) + "条链表为空");
            return;
        }

        System.out.print("第" + (no + 1) + "条链表的信息为：");
        Emp curEmp = head;
        do {
            System.out.printf("=> id = %d, name = %s\n", curEmp.id, curEmp.name);
            curEmp = curEmp.next;
        } while (curEmp != null);
    }

    /**
     * 根据id在链表中查找员工
     *
     * @param id
     * @return
     */
    public Emp findEmp(int id) {
        if (head == null) {
            return null;
        }

        Emp curEmp = head;
        do {
//            找到了，curEmp就是我们要找的雇员
            if (curEmp.id == id) {
                break;
            }
            curEmp = curEmp.next;
        } while (curEmp != null);

//        如果没找到，curEmp就是null，返回一个null
        return curEmp;
    }

    /**
     * 链表的删除节点操作
     * 如果找到了指定id的雇员则进行删除，并将其返回
     * 如果没有找到则直接返回null
     * @param id
     * @return
     */
    public Emp delEmp(int id) {
//        如果头指针为null说明链表中无节点
        if (head == null) {
            return null;
        }

//        创建两个辅助指针，一个在前一个在后，cause：此单链表头节点不为空，并且我们需要返回被删除Emp雇员
        Emp curEmp = head;
        Emp tempEmp = head.next;
//        如果头节点就是要删除的雇员，则直接对其进行操作
        if (head.id == id) {
            head = head.next;
            return curEmp;
        }
//        若头节点不是要删除的雇员，则进行循环，查找此链表后续的节点
        do {
//            找到了就进行删除操作，并结束循环
            if (tempEmp.id == id) {
                if (tempEmp.next != null) {
                    curEmp.next = tempEmp.next;
                } else {
                    curEmp.next = null;
                }
                break;
            }
            curEmp = curEmp.next;
            tempEmp = tempEmp.next;
        } while (tempEmp != null);

//        没找到的话就是null
        return tempEmp;
    }
}

package study.hashTable;

/**
 * 哈希表，用于管理多条链表
 * 一个数组中，每一个元素都是一条链表
 *
 * @author shkstart
 * @create 2021-11-06-15:25
 */
public class HashTab {
    private EmpLinkedList[] empLinkedLists;
    private int size;

    public HashTab(int size) {
        this.size = size;
//        确定了数组长度，但是数组中的元素都是null
        empLinkedLists = new EmpLinkedList[size];
//        对数组中的每个元素都初始化了
        for (int i = 0; i < size; i++) {
            empLinkedLists[i] = new EmpLinkedList();
        }
    }

    /**
     * 添加雇员
     *
     * @param emp
     */
    public void add(Emp emp) {
//        根据员工的id得到该员工应该添加到哪条链表中
        int empLinkedListNo = hashFun(emp.id);
//        将emp添加到对应的链表中
        empLinkedLists[empLinkedListNo].add(emp);
    }

    /**
     * 编写散列函数，使用一个简单取模法
     *
     * @param id
     * @return
     */
    public int hashFun(int id) {
        return id % size;
    }

    /**
     * 遍历哈希表
     */
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedLists[i].list(i);
        }
    }

    /**
     * 在哈希表中查找指定id的雇员
     * @param id
     */
    public void findEmpById(int id) {
//        查找到该雇员应该在哪条链表中
        int empLinkedListNo = hashFun(id);
//        进行查找，并且获得返回值
        Emp emp = empLinkedLists[empLinkedListNo].findEmp(id);
        if (emp == null) {
            System.out.println("在哈希表中没有找到该雇员");
        } else {
            System.out.println("在第" + (empLinkedListNo + 1) + "条链表中找到id为" + id + "的雇员，其姓名是" + emp.name);
        }
    }

    /**
     * 在哈希表中删除指定id的雇员
     * @param id
     */
    public void delEmpById(int id) {
//        查找到该雇员应该在哪条链表中
        int empLinkedListNo = hashFun(id);
//        进行查找，并且获得返回值
        Emp emp = empLinkedLists[empLinkedListNo].delEmp(id);
        if (emp == null) {
            System.out.println("在哈希表中没有找到该雇员");
        } else {
            System.out.printf("已经删除了id为%d姓名为%s的员工\n",emp.id,emp.name);
        }
    }

    /**
     * 修改哈希表中雇员信息
     * @param emp
     */
    public void amend(Emp emp) {
//        根据员工的id得到该员工应该在哪条链表中
        int empLinkedListNo = hashFun(emp.id);
        empLinkedLists[empLinkedListNo].amend(emp);
    }
}

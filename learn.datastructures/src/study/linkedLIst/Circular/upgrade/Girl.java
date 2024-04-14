package study.linkedLIst.Circular.upgrade;

/**
 * 因为学习到的环形链表没有实现添加插入，而是直接由方法添加指定个数的节点
 * 所以决定自己尝试实现这样的环形链表
 * 要求：
 * 插入的节点将依照编号排序
 * 争取实现双向环形链表
 * 实现指定节点出圈的操作
 * 实现指定节点的修改操作
 * 实现环形链表的遍历操作
 *
 * @author shkstart
 * @create 2021-09-23-13:21
 */
public class Girl {
    private int id;
    private String name;
    private int age;
    private Girl next;
    private Girl pre;

    public Girl(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Girl getNext() {
        return next;
    }

    public void setNext(Girl next) {
        this.next = next;
    }

    public Girl getPre() {
        return pre;
    }

    public void setPre(Girl pre) {
        this.pre = pre;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

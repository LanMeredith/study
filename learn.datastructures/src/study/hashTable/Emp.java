package study.hashTable;

/**
 * 雇员类，作为单链表的节点
 * @author shkstart
 * @create 2021-11-06-15:11
 */
public class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

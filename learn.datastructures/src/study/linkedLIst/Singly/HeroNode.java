package study.linkedLIst.Singly;

/**
 * 在单向链表HeroNodeLinkedList中
 * 要存入节点中的就是此类的对象
 * @author shkstart
 * @create 2021-09-08-19:03
 */
public class HeroNode {
    /**
     * no是排名
     * name是姓名
     * nickname是花名
     * next指向的是下一个节点
     */
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}

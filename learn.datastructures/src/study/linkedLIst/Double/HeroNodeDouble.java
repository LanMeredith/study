package study.linkedLIst.Double;


/**
 * 添加到双向链表中的节点对象，需要添加一个属性指向上一个节点，类似于单向链表节点中的next
 * @author shkstart
 * @create 2021-09-12-14:08
 */
public class HeroNodeDouble {

    /**
     * 在HeroNode的基础上，进行修改，除了已有的属性还需要添加一个新的属性pre
     * 作用是指向上一个节点
     */
    public int no;
    public String name;
    public String nickName;
    public HeroNodeDouble next;
    public HeroNodeDouble pre;

    public HeroNodeDouble(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNodeDouble{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}

package study.linkedLIst.Circular;

/**
 * 节点
 * 类同于Singly包中的HeroNode类
 * @author shkstart
 * @create 2021-09-22-20:32
 */
public class Boy {
    public int no;
    public Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }
}

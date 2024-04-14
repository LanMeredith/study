package study.tree.binaryTree.CluesBinaryTree;

/**
 * 线索化二叉树
 * 基本介绍：
 * （1）n个节点的二叉树链表中含有n+1（公式2n-(n-1)=n+1)个空指针域
 * 利用二叉链表中的空指针域，存放指向该节点在某种遍历次序下的前驱和后继节点的指针
 * 这种附加的指针称之为“线索”
 *
 * （2）这种加上了线索的二叉链表称为线索链表，相应的二叉树称为线索二叉树
 * 根据线索性质不同，线索二叉树可分为前序线索二叉树，中序线索二叉树和后序线索二叉树三种
 *
 * （3）一个节点的前一个节点，称为前驱节点
 * （4）一个节点的后一个节点，称为后继节点
 *
 * 线索化二叉树之后，Node节点的属性left和right有了如下几种情况
 * （1）left指向左子树也可能指向前驱节点
 * （2）right指向右子树，也可能指向后继节点
 *
 * 当一个二叉树以中序遍历输出时，输出顺序为
 * 81,14,91,21,15,11,61,31,71
 * 那么81的后继节点是14,61的前驱节点是11,61的后继节点是31
 * 线索化，是将一个二叉树中，没有利用到的left和right指针利用起来
 * 以叶子节点为例，叶子节点是没有子节点的节点，即叶子节点的left和right指针都为null
 * 线索化就是将为null的left和right指针利用起来
 * 在中序遍历中，81之后将输出14，那么在中序线索化方法中，81的后继节点就是14，即为81的right由null更改为指向14
 * 为了区分left和right指向的是左子树右子树还是前驱节点后继节点，我们添加了成员变量isLeftType和isRightType作为标识
 * 在本类中，当isLeftType和isRightType为true时，说明该节点的left、right指向的是前驱节点、后继节点
 * @author shkstart
 * @create 2021-11-09-13:22
 */
public class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;
    /**
     * 辅助指针，指向当前节点的上一节点
     */
    private HeroNode pre;
    /**
     * isLeftType    isRightType
     * false：左子树    右子树
     * true：前驱节点    后继节点
     */
    private boolean isLeftType;
    private boolean isRightType;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    /**
     * 中序线索化方法
     * @param node
     */
    public void infixThreadedNodes(HeroNode node) {
//        为空就不能线索化
        if (node == null) {
            return;
        }

//        线索化左子树
        infixThreadedNodes(node.left);

        /*
        前驱节点的处理
        当前节点的前驱节点就是上一节点即为pre
        将当前节点的left指向pre
        并将isLeftType设为true表示left指向的是前驱节点，而非左子树
         */
        if (node.getLeft() == null) {
            node.setLeftType(true);
            node.setLeft(pre);
        }

        /*
        后继节点的处理
        既然无法获取到当前节点的下一节点，那我们就对pre进行操作
        因为pre的下一节点是当前节点
        所以当pre不为空，且pre的right指针为空时
        说明pre的后继节点就是当前节点
         */
        if (pre != null && pre.getRight() == null) {
            pre.setRightType(true);
            pre.setRight(node);
        }
//        让当前节点成为下一节点的上一节点
        pre = node;

//        线索化右子树
        infixThreadedNodes(node.right);
    }

    /**
     * 前序线索化二叉树方法
     * @param node
     */
    public void preThreadedNodes(HeroNode node) {
//        node为空就不能线索化了
        if (node == null) {
            return;
        }

//        先对当前节点进行操作，判断当前节点的left指针是否为空
        if (node.getLeft() == null) {
//            为空的话就指向上一节点（前序、中序、后序，同一节点的上一节点都不相同）
            node.setLeftType(true);
            node.setLeft(pre);
        }

//        若上一节点不为空并且上一节点的right指针为空，就让上一节点的right指向当前节点，具体可看上述中序线索化二叉树中注解
        if (pre != null && pre.getRight() == null) {
            pre.setRightType(true);
            pre.setRight(node);
        }

//        让当前节点成为下一节点的上一节点，下面的向左递归向右递归都会对pre产生改变，让pre始终为当前节点的上一节点
        pre = node;

//        如果当前节点的left指向的不是前驱节点，则向左递归
        if (!node.isLeftType()) {
            preThreadedNodes(node.getLeft());
        }
//        如果当前节点的right指向的不是后继节点，则向右递归
        if (!node.isRightType()) {
            preThreadedNodes(node.getRight());
        }
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public boolean isLeftType() {
        return isLeftType;
    }

    public void setLeftType(boolean leftType) {
        isLeftType = leftType;
    }

    public boolean isRightType() {
        return isRightType;
    }

    public void setRightType(boolean rightType) {
        isRightType = rightType;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }
}

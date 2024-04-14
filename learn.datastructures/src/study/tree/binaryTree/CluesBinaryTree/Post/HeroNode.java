package study.tree.binaryTree.CluesBinaryTree.Post;

/**
 * @author shkstart
 * @create 2021-11-09-21:35
 */
public class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;
    private HeroNode pre;
    /**
     * isLeftType    isRightType
     * false：左子树    右子树
     * true：前驱节点    后继节点
     */
    private boolean isLeftType;
    private boolean isRightType;
    /**
     * 因为后序线索化二叉树的先后顺序是左子节点右子节点最后才是当前节点
     * 线索化后，左叶子节点的后继节点是右叶子节点，右叶子节点的后继节点是当前节点
     * 若当前节点相较于父节点是left的话，下一个应该是兄弟节点，即父节点的right
     * 所以需要一个节点指针指向父节点
     */
    private HeroNode parent;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    /**
     * 后序线索化二叉树方法
     * 除了子树线索化的先后顺序改变，其他部分与中序、前序线索化二叉树方法一致
     * @param node
     */
    public void postThreadedNodes(HeroNode node) {
//        为空不可线索化
        if (node == null) {
            return;
        }

//        线索化左右子树
        postThreadedNodes(node.getLeft());
        postThreadedNodes(node.getRight());

//        对当前节点的前驱节点处理
        if (node.getLeft() == null) {
            node.setLeftType(true);
            node.setLeft(pre);
        }
//        对当前节点的后继节点处理
        if (pre != null && pre.getRight() == null) {
            pre.setRightType(true);
            pre.setRight(node);
        }
//        让当前节点成为下一节点的上一节点
        pre = node;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public void setParent(HeroNode parent) {
        this.parent = parent;
    }

    public HeroNode getParent() {
        return parent;
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
        /*
        在当前节点添加左子节点的同时，也要对左子节点的父指针设为指向自己
        首先考虑左子节点不为空，并且左子节点的父指针为空
        这是为了避免出现在线索化二叉树时，我们对当前节点设置前驱节点，而导致前驱节点的父节点指向发生改变
         */
        if (this.left != null && this.left.getParent() == null) {
            this.left.setParent(this);
        }
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
//        此处与上述设置左子节点一样
        if (this.right != null && this.right.getParent() == null) {
            this.right.setParent(this);
        }
    }

    public HeroNode getPre() {
        return pre;
    }

    public void setPre(HeroNode pre) {
        this.pre = pre;
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
}

package study.tree.binaryTree;

/**
 * 二叉树，节点是HeroNode
 * （1）树有很多种，每个节点最多只能有两个子节点的一种形式称为二叉树
 * （2）二叉树的子节点，分别为左节点和右节点
 * （3）如果该二叉树的所有叶子节点都在最后一层，并且节点总数等于2^n-1，n为层数，我们称为满二叉树
 * （4）如果该二叉树的所有叶子节点都在最后一层或倒数第二层
 * 而且最后一层的叶子结点在左边连续，倒数第二层的叶子节点在右边连续，我们称为完全二叉树
 * @author shkstart
 * @create 2021-11-07-15:36
 */
public class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("当前二叉树为空，无法遍历");
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("当前二叉树为空，无法遍历");
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("当前二叉树为空，无法遍历");
        }
    }

    /**
     * 前序遍历查找指定节点
     * @param no
     * @return
     */
    public HeroNode preFind(int no) {
        if (this.root != null) {
            return this.root.preFind(no);
        } else {
            return null;
        }
    }

    /**
     * 中序遍历查找指定节点
     * @param no
     * @return
     */
    public HeroNode infixFind(int no) {
        if (this.root != null) {
            return this.root.infixFind(no);
        } else {
            return null;
        }
    }

    /**
     * 后序遍历查找指定节点
     * @param no
     * @return
     */
    public HeroNode postFind(int no) {
        if (this.root != null) {
            return this.root.postFind(no);
        } else {
            return null;
        }
    }

    /**
     * 二叉树删除指定节点
     * @param no
     * @return
     */
    public boolean delNode(int no) {
//        删除结果
        boolean isFlag = false;

//        判断二叉树不为空
        if (root != null) {
//            若二叉树根节点root是要删除节点，则让root为null，全部删除，就此结束
            if (root.getNo() == no) {
                root = null;
                return true;
            } else {
//                若二叉树根节点root不是要删除节点，则调用节点中的delNode方法，
                isFlag = root.delNode(no, isFlag);
                return isFlag;
            }
        } else {
            System.out.println("空树");
            return isFlag;
        }
    }
}

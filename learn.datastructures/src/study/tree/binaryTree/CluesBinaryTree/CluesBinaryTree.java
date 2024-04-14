package study.tree.binaryTree.CluesBinaryTree;

/**
 * @author shkstart
 * @create 2021-11-09-13:56
 */
public class CluesBinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    /**
     * 中序遍历线索化二叉树
     * notice：
     * 以何种方式线索化二叉树，就以何种方式遍历，只有中序线索化二叉树才能用这一中序遍历
     * explain：
     * 因为线索化后，各节点指向有变化
     * 这时需要新的方式遍历线索二叉树
     * 各节点可以通过线性方式遍历
     * 因此无需使用递归，这也提高了遍历效率
     * 遍历的次序应当和中序遍历保持一致
     */
    public void infixThreadedList() {
        HeroNode node = root;

        while (node != null) {
//            中序遍历中最先输出的是最左子节点，以线性遍历的话，我们应该先找到以当前node作为根节点的最左子节点
            while (!node.isLeftType()) {
                /*
                线索二叉树中，节点的isLeftType、isRightType都为false
                只有子节点中原为null的left或right指针被利用起来后，才会更改为false
                向着当前节点的左子节点去找，当isLeftType为true时，表示找到
                 */
                node = node.getLeft();
            }

//            打印找到的节点
            System.out.println(node);

            /*
            如果当前节点有后继节点的话，node指向后继节点
            将其输出
            如果当前节点没有后继节点，则让node指向node右指针指向的节点
            此时不直接输出，而是进行一次大循环
            explain：
            当node = node.getRight()后
            node可能是某子树的根节点，此时我们需要先输出该子树的最左节点
            */
            while (node.isRightType()) {
                node = node.getRight();
                System.out.println(node);
            }
            node = node.getRight();
        }
    }

    /**
     * 前序遍历前序线索化二叉树
     */
    public void preThreadedList() {
        HeroNode node = root;

//        输出当前节点
        System.out.println(node);
//        如果当前节点的right不指向null说明还未把二叉树遍历完成
        while (node.getRight() != null) {
//            辅助判断
            boolean isRight = false;

//            若当前节点的左指针不指向前驱节点，并且左指针不为null，则对其输出
            while (!node.isLeftType() && node.getLeft() != null) {
                node = node.getLeft();
                System.out.println(node);
//                若已移动到左指针指向的节点，则不向右指针移动
                isRight = true;
            }

//            如果当前节点的right指向后继节点，则对其输出
            while (node.isRightType()) {
                node = node.getRight();
                System.out.println(node);
            }

//            若当前节点没有向左指针移动并且右指针不为空，则由当前节点向右指针移动
            if (!isRight && node.getRight() != null) {
                node = node.getRight();
                System.out.println(node);
            }
        }
    }
}

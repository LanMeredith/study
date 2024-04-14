package study.tree.binaryTree.CluesBinaryTree.Post;

/**
 * 后序遍历后序线索化二叉树需要考虑
 * 1.当前节点为null
 * 2.找到的最左子节点不是最先输出的节点
 * 3.当前节点为根的树输出后，是否要输出当前节点的兄弟节点
 * 4.如果判断当前树的根节点就是node，则父节点为null
 *
 * @author shkstart
 * @create 2021-11-09-21:46
 */
public class Tree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    /**
     * 后序遍历后序线索化二叉树
     */
    public void postThreadedList() {
        HeroNode node = root;
        HeroNode pre = null;
        while (true) {

            /*
            先获取到node为根节点的树的最左节点
            notice：
            此最左节点未必是当前树的最先输出节点
             */
            while (!node.isLeftType()) {
                node = node.getLeft();
            }

            /*
            判断node是否为最先输出节点
            因为node.left指向前驱节点，所以不用考虑node的左子节点
            那么我们考虑右子节点的情况
            node的右子节点不可为空
            notice：当只有一个root节点时，root.right不指向后继节点，但为空
            并且node.right不指向后继节点
            notice：node.right指向后继节点，说明node就是最先输出节点

            若判断条件为true，则说明node非当前树最先输出节点
            让node移向右子节点，跳过本次循环，进行下次循环
            找到最先输出节点为止
             */
            if (node.getRight() != null && !node.isRightType()) {
                node = node.getRight();
                continue;
            }

            /*
            到这说明找到了最先输出节点
            只要node.right指向后继节点，就可以输出node
            然后标记为上一节点，node移向后继节点
             */
            while (node.isRightType()) {
                System.out.println(node);
                pre = node;
                node = node.getRight();
            }

            /*
            当node.right不指向后继节点
            那么node一定是当前树的根节点
            此时情况有四种
            先处理第一种情况，node.right就是上一节点
            说明node的右子节点已输出，那么我们直接输出node节点即可
            标记为上一节点，然后将node移向父节点
             */
            if (node.getRight() == pre && node != root) {
                System.out.println(node);
                pre = node;
                node = node.getParent();
            }

            /*
            再考虑第二种情况
            node指向的是root根节点，并且root根节点无右子节点或右子节点已输出
            满足条件则输出node并结束方法即可

            将这种情况放在第二位进行还有另一原因：
            当情况一发生并处理后，
            node移向的父节点就是root根节点
            此时就要判断是否要将其输出并结束方法
             */
            if (node == root && (node.getRight() == null || node.getRight() == pre)) {
                System.out.println(node);
                return;
            }

            /*
            情况三与四：
            原node.right与上一节点相等
            在经过情况一代码处理后，node移向父节点，且父节点不为root根节点
            此时应考虑父节点的右子节点

            而这里可以不用判断右子节点是否为空，因为后序线索化二叉树中
            以先左再有最后当前的输出顺序来看，只有当root.right为null时，才会出现线索化后right也仍为空的情况
            但root.right为null的情况在上述代码中，情况二处被处理了，所以这里不用再进行一次判断

            情况三：
            右子节点不是后继节点，说明右子节点部分需要先输出
            node移向右子节点后跳过当前循环，进行下一次循环
            与第一个if判断不同的是这里不需要对右子节点为null进行再次判断，root.right为null的话已经被情况二处理了

            情况四：
            右子节点是后继节点，那就直接把node输出
            标记为上一节点，node移向后继节点

            为什么情况四只做if对node进行一次移动，而不做while将有后继节点的node一次性全部输出？
            cause：
            经过前面的代码可以确定，在进行一次移动后，node不会指向root
            但使用while进行多次移动的话，可能会导致node最终指向root
            再将node投入循环，相当于让遍历从root根节点又重新跑一遍，从而死循环
             */
            if (!node.isRightType()) {
                node = node.getRight();
                continue;
            } else {
                System.out.println(node);
                pre = node;
                node = node.getRight();
            }
        }
    }
}

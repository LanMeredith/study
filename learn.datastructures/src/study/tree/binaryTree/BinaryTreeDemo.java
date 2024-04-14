package study.tree.binaryTree;
/**
 * @author shkstart
 * @create 2021-11-07-15:41
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
//        创建二叉树
        BinaryTree binaryTree = new BinaryTree();

//        创建节点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node1 = new HeroNode(2, "卢俊义");
        HeroNode node2 = new HeroNode(3, "吴用");
        HeroNode node3 = new HeroNode(4, "公孙胜");
        HeroNode node4 = new HeroNode(5, "关胜");

//        先手动创建二叉树
        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node3);
        node2.setRight(node4);

        binaryTree.setRoot(root);

//        测试二叉树前序遍历
        System.out.println("前序遍历");
        binaryTree.preOrder();

        System.out.println();

//        测试二叉树中序遍历
        System.out.println("中序遍历");
        binaryTree.infixOrder();

        System.out.println();

//        测试二叉树后序遍历
        System.out.println("后序遍历");
        binaryTree.postOrder();

        System.out.println();

//        测试二叉树前序遍历查找指定no的节点
        System.out.println("前序遍历查找指定no的英雄");
        HeroNode nodeTemp = binaryTree.preFind(6);
        if (nodeTemp != null) {
            System.out.println(nodeTemp.toString());
        } else {
            System.out.println("没有查找到该排名的英雄");
        }

//        测试二叉树中序遍历查找指定no的节点
        System.out.println("中序遍历查找指定no的英雄");
        nodeTemp = binaryTree.infixFind(3);
        if (nodeTemp != null) {
            System.out.println(nodeTemp.toString());
        } else {
            System.out.println("没有查找到该排名的英雄");
        }

//        测试二叉树后序遍历查找指定no的节点
        System.out.println("后序遍历查找指定no的英雄");
        nodeTemp = binaryTree.postFind(2);
        if (nodeTemp != null) {
            System.out.println(nodeTemp.toString());
        } else {
            System.out.println("没有查找到该排名的英雄");
        }
    }
}

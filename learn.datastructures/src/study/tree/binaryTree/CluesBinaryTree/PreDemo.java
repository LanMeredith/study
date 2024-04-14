package study.tree.binaryTree.CluesBinaryTree;

/**
 * 前序线索化二叉树方法测试
 * @author shkstart
 * @create 2021-11-09-17:45
 */
public class PreDemo {
    public static void main(String[] args) {
//        创建二叉树
        CluesBinaryTree tree = new CluesBinaryTree();

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
        tree.setRoot(root);

        root.preThreadedNodes(root);

        System.out.println("前序遍历线索二叉树");
        tree.preThreadedList();
    }
}

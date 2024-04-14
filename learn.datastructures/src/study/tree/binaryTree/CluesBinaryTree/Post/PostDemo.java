package study.tree.binaryTree.CluesBinaryTree.Post;

/**
 * @author shkstart
 * @create 2021-11-09-19:55
 */
public class PostDemo {
    public static void main(String[] args) {
//        创建二叉树
        Tree tree = new Tree();

//        创建节点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node1 = new HeroNode(2, "卢俊义");
        HeroNode node2 = new HeroNode(3, "吴用");
        HeroNode node3 = new HeroNode(4, "公孙胜");
        HeroNode node4 = new HeroNode(5, "关胜");
        HeroNode node5 = new HeroNode(6, "林冲");
        HeroNode node6 = new HeroNode(7, "秦明");
        HeroNode node7 = new HeroNode(8, "呼延灼");

//        先手动创建二叉树
        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node5);
        node2.setLeft(node4);
        node2.setRight(node6);
        node3.setRight(node7);
        tree.setRoot(root);

        root.postThreadedNodes(root);

        tree.postThreadedList();
    }
}

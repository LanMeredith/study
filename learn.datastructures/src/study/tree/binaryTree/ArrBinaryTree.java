package study.tree.binaryTree;

/**
 * 顺序存储二叉树基本说明：
 * 从数据存储来看，数组存储方式和树的存储方式可以相互转换
 * 即数组可以转成树，树也可以转成数组
 *
 * 顺序存储二叉树的特点
 * （1）顺序二叉树通常只考虑完全二叉树
 * （2）第n个元素的左子节点为2n+1
 * （3）第n个元素的右子节点为2n+2
 * （4）第n个元素的父节点为(n-1)/2
 * @author shkstart
 * @create 2021-11-08-21:37
 */
public class ArrBinaryTree {
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    /**
     * 因为每次调用preOrder方法需要传入一个数值
     * 这很麻烦，所以用重载，直接调用重载的此方法就可以调用preOder(0)
     */
    public void preOrder() {
        this.preOrder(0);
    }

    /**
     * 用二叉树的方式前序遍历一维数组
     * @param index
     */
    public void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }

//        输出当前这个元素
        System.out.println(arr[index]);
//        向左递归前序遍历
        if ((index * 2 + 1) < arr.length) {
            preOrder(2 * index + 1);
        }
//        向右递归前序遍历
        if ((index * 2 + 2) < arr.length) {
            preOrder(2 * index + 2);
        }
    }
}

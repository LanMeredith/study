package study.tree.binaryTree;

/**
 * 二叉树的节点
 * @author shkstart
 * @create 2021-11-07-15:25
 */
public class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    /**
     * 编写前序遍历的方法
     * 前序、中序、后序的遍历方法区别点在于第一个输出当前节点
     * 先输出左节点再输出当前节点和先输出左节点再输出右节点最后输出当前节点
     */
    public void preOrder() {
        /*
        （1）this调用本类中的属性，也就是类中的成员变量
        （2）this调用本类中的其他方法
        （3）this调用本类中的其它构造方法，调用时要放在构造方法的首行
        notice：不可在静态方法中调用this
         */
//        先输出当前节点（初始化时为root节点）
        System.out.println(this);

//        如果当前节点的左节点不为空，则左递归继续前序遍历
        if (this.left != null) {
            this.left.preOrder();
        }
//        如果当前节点的右节点不为空，则右递归继续前序遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }

        System.out.println(this);

        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }

        System.out.println(this);
    }

    /**
     * 前序遍历查找指定节点
     * @param no 指定节点的no
     * @return 指定节点
     */
    public HeroNode preFind(int no) {
//        判断当前节点是否为要查找的指定节点
        if (this.no == no) {
            return this;
        }

//        如果当前节点不是要查找的指定节点，则创建一个辅助节点resNode
        HeroNode resNode = null;
//        如果当前节点的左节点不为空，则向左递归前序查找，查找结果用辅助节点resNode接收
        if (this.left != null) {
            resNode = this.left.preFind(no);
//            判断左递归前序查找后的辅助节点是否为空，若仍为空，则表示没有找到指定节点，若不为空，则表示找到指定节点
            if (resNode != null) {
                return resNode;
            }
        }

//        上述代码中判断了向左递归前序查找是否找到了指定节点，若没有找到则判断当前节点的右节点是否为空，不为空则向右递归前序查找
        if (this.right != null) {
            resNode = this.right.preFind(no);
        }
//        此时不管找没找到，都可以直接输出辅助指针resNode，若没有找到则resNode为null，找到则为指定节点
        return resNode;
    }

    /**
     * 中序遍历查找指定节点
     * @param no
     * @return
     */
    public HeroNode infixFind(int no) {
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.infixFind(no);
            if (resNode != null) {
                return resNode;
            }
        }

        if (this.no == no) {
            return this;
        }

        if (this.right != null) {
            resNode = this.right.infixFind(no);
        }
        return resNode;
    }

    /**
     * 后序遍历查找指定节点
     * @param no
     * @return
     */
    public HeroNode postFind(int no) {
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.postFind(no);
            if (resNode != null) {
                return resNode;
            }
        }

        if (this.right != null) {
            resNode = this.right.postFind(no);
            if (resNode != null) {
                return resNode;
            }
        }

        if (this.no == no) {
            return this;
        }
        return resNode;
    }

    /**
     * 删除指定节点，并返回结果
     * @param no 指定节点
     * @param isFlag 返回结果
     * @return isFlag返回结果
     */
    public boolean delNode(int no, boolean isFlag) {
//        若当前节点的左子节点不为空并且左子节点的no就是要删除节点的no
        if (this.left != null && this.left.no == no) {
//            进行删除操作，对当前节点的left指针归为null即可
            this.left = null;
            return true;
        }

//        若当前节点的右子节点不为空，并且右子节点的no就是要删除节点的no
        if (this.right != null && this.right.no == no) {
//            进行删除操作，对当前节点的right指针归为null即可
            this.right = null;
            return true;
        }

//        到这一步，说明当前节点的左子节点和右子节点都不是要删除节点，则先向左递归
        if (this.left != null) {
            isFlag = this.left.delNode(no, isFlag);
            if (isFlag) {
                return isFlag;
            }
        }

//        向左递归仍然没有找到要删除节点,则进行向右递归
        if (this.right != null) {
            isFlag = this.right.delNode(no, isFlag);
        }
        return isFlag;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
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

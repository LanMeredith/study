package study.recursion;

/**
 * 迷宫问题，我们将设计程序去走迷宫，求出可以抵达的重点的路线
 * 在这里我们用   0表示这个位置可以走   1表示迷宫的墙   2表示路线  3表示走过这条路线，但是发现没有走通
 * 迷宫的模样：
 * 1	1	1	1	1	1	1
 * 1	0	0	0	0	0	1
 * 1	0	1	0	0	0	1
 * 1	1	1	0	0	0	1
 * 1	0	0	0	0	0	1
 * 1	0	0	0	0	0	1
 * 1	0	0	0	0	0	1
 * 1	1	1	1	1	1	1
 * 将lab[6][5]设为终点，我们从lab[1][1]的位置开始
 * @author shkstart
 * @create 2021-10-26-19:40
 */
public class Labyrinth {
    public static void main(String[] args) {
//        创建迷宫
        int[][] lab = new int[8][7];
        for (int i = 0; i < 8; i++) {
            lab[i][0] = 1;
            lab[i][6] = 1;
        }
        for (int i = 0; i < 7; i++) {
            lab[0][i] = 1;
            lab[7][i] = 1;
        }
        lab[3][1] = 1;
        lab[3][2] = 1;
        lab[2][2] = 1;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(lab[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();

//        开始探索迷宫，寻找可行路线
        pathfinding(lab, 1, 1);

//        探索完毕，查看情况，如果出现了3则说明程序往这个方向探索过，但是失败了，发现不可行，进行了标记
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(lab[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 在pathfinding中我们采用了递归的方式
     * 当我们处于一个可以行走的位置时
     * 我们先判断下方是否可走，此处进行了递归调用pathfinding
     * 层层调用下将会向下走的所有可能反馈回来，如果走不通，则会判断向右是否可走
     * 而在递归的层层调用中，如果这个点前后左右不是墙壁就是走过的路或走不通的路，则会将这个点标记为3（走不通）并返回失败
     * 这个失败的信息返回给调用他的地方
     * 得到失败信息后，就会判断其他方向的通过可行性，直到找到终点为止。
     *
     * 而在方法中，我采用的是  下，右，上，左的探索方式
     * 即为每个位置都会先判断向下可行性，若不可行则判断向右可行性……
     * 程序找到的路径和我们采用的探索方式息息相关。
     * @param lab
     * @param i
     * @param j
     * @return
     */
    public static boolean pathfinding(int[][] lab, int i, int j) {
//        如果我们走到了终点，就可以结束了
        if (lab[6][5] == 2) {
            return true;
        }

//        如果当前所处的位置不是重点，那么判断此处是否可走
        if (lab[i][j] == 0) {
//            若可以走，则行走
            lab[i][j] = 2;
//            行走到这个位置后，则进行判断此位置的下方是否可走
            if (pathfinding(lab, i + 1, j)) {
                return true;
//                判断此位置的右方是否可走
            } else if (pathfinding(lab, i, j + 1)) {
                return true;
//                判断此位置的上方是否可走
            } else if (pathfinding(lab, i - 1, j)) {
                return true;
//                判断此位置的左方是否可走
            } else if (pathfinding(lab, i, j - 1)) {
                return true;
            } else {
//                如果发现这个位置的前后左右要么是墙壁，要么是我们来时的路，要么是我们标记走不通的路，则对此处标记为3（走不通）
                lab[i][j] = 3;
                return false;
            }
        } else {
//            如果这个位置的信息不是0即为此处是墙壁、走过的路或走不通的路，则直接返回失败
            return false;
        }
    }
}

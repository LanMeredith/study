package study.sparseArray;

import java.util.Arrays;

/**
 * 学习稀疏数组
 * @author shkstart
 * @create 2021-09-03-17:24
 */
public class SparseArray {
    public static void main(String[] args) {
        /*
        创建一个原始的二维数组 11 * 11 来表示五子棋棋盘
        0：表示没有棋子
        1：表示黑子
        2：表示白子
         */
        int[][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[1][3] = 1;
        chessArr[2][3] = 2;
        chessArr[2][4] = 1;
        chessArr[3][3] = 2;

//        输出原始的二维数组
        for (int i = 0; i < chessArr.length; i++) {
            System.out.println(Arrays.toString(chessArr[i]));
        }

        /*
        将二维数组转稀疏数组
        1.先遍历二维数组，得到非零数据的个数sum
        2.根据sum就可以创建稀疏数组sparseArr int[sum + 1][3]
        3.将二维数组的有效数据存入到稀疏数组
         */
        int sum = 0;
        for (int[] tempOne :
                chessArr) {
            for (int tempTwo :
                    tempOne) {
                if (tempTwo != 0) {
                    sum++;
                }
            }
        }
        System.out.println("非零数据的个数：sum = " + sum);
//        创建对应的稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
//        给稀疏数组第一行赋值
        sparseArr[0] = new int[]{chessArr.length, chessArr[0].length, sum};
//        count用于记录当前是第几个非零数据
        int count = 0;
//        遍历二维数组，将非零的数据存放到稀疏数组中
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                if (chessArr[i][j] != 0) {
                    sparseArr[++count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr[i][j];
                }
            }
        }
//        输出稀疏数组
        System.out.println("稀疏数组：");
        for (int i = 0; i < sparseArr.length; i++) {
//            System.out.println(Arrays.toString(sparseArr[i]));
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }

        /*
        将稀疏数组还原成原始的二维数组
        1.先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
        2.在读取稀疏数组的数据，并赋给原始的二维数组即可
         */
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
//        从第二行开始读取，因为从第二行开始记录原始二维数组非零数据的位置
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
//        输出还原的二维数组
        for (int i = 0; i < chessArr2.length; i++) {
            System.out.println(Arrays.toString(chessArr2[i]));
        }
    }
}

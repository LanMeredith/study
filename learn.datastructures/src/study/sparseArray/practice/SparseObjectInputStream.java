package study.sparseArray.practice;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 将稀疏数组通过IO流存入到文件中
 * @author shkstart
 * @create 2021-09-03-19:57
 */
public class SparseObjectInputStream {
    public static void main(String[] args) {
//        1.创建原始的二维数组
        int[][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[1][3] = 1;
        chessArr[2][3] = 2;
        chessArr[2][4] = 1;
        chessArr[3][3] = 2;

        /*
        将二维数组转稀疏数组
        1.先遍历二维数组，得到非零数据的个数sum
        2.根据sum就可以创建稀疏数组sparseArr int[sum + 1][3]
        3.将二维数组的有效数据存入到稀疏数组
         */
        int sum = 0;
        for (int[] arrone :
                chessArr) {
            for (int arrtwo :
                    arrone) {
                if (arrtwo != 0) {
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

        /*
        现在有了稀疏数组sparseArr，通过ObjectOutputStream流将其输出为ObjectOutputStreamPracticeOne.data
         */
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("D:\\JAVA_IDEA\\IO\\study\\ObjectOutputStreamPracticeOne.data"));
            oos.writeObject(sparseArr);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

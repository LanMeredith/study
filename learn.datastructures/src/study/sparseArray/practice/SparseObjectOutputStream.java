package study.sparseArray.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

/**
 * @author shkstart
 * @create 2021-09-03-19:55
 */
public class SparseObjectOutputStream {
    public static void main(String[] args) {
        ObjectInputStream stream = null;
        try {
            stream = new ObjectInputStream(new FileInputStream("D:\\JAVA_IDEA\\IO\\study\\ObjectOutputStreamPracticeOne.data"));
            int[][] sparseArr = (int[][]) stream.readObject();

            /*
            将稀疏数组还原成原始的二维数组
            1.先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
            2.在读取稀疏数组的数据，并赋给原始的二维数组即可
            */
            int[][] chessArr = new int[sparseArr[0][0]][sparseArr[0][1]];
//        从第二行开始读取，因为从第二行开始记录原始二维数组非零数据的位置
            for (int i = 1; i < sparseArr.length; i++) {
                chessArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
            }
//        输出还原的二维数组
            for (int i = 0; i < chessArr.length; i++) {
                System.out.println(Arrays.toString(chessArr[i]));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stream != null) {
                    stream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

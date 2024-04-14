package practice;

import java.io.*;

/**
 * 实现图片加密操作
 * 对原图片调用一次encryption()获得加密后的图片
 * 对加密后的图片调用一次encryption()获得解密后的图片
 * @author shkstart
 * @create 2021-02-16-15:36
 */
public class Three {
    public static void main(String[] args) {

        File file1 = new File("D:\\JAVA_IDEA\\IO\\study\\img.png");
        File file2 = new File("D:\\JAVA_IDEA\\IO\\study\\copy.png");

        encryption(file1,file2);

    }

    public static boolean encryption(File file1, File file2) {
        if (file1 != null && file2 != null) {
            BufferedInputStream bufferedInputStream = null;
            BufferedOutputStream bufferedOutputStream = null;
            try {
//                先创建节点流
                FileInputStream inputStream = new FileInputStream(file1);
                FileOutputStream outputStream = new FileOutputStream(file2);
//                再创建缓冲流
                bufferedInputStream = new BufferedInputStream(inputStream);
                bufferedOutputStream = new BufferedOutputStream(outputStream);
//                进行复制操作
                byte[] b = new byte[1024];
                int len;
                while ((len = bufferedInputStream.read(b)) != -1) {
                    for (int i = 0; i < len; i++) {
//                        对数组b中的每个元素进行按位异或计算，以此完成加密
                        b[i] = (byte) (b[i] ^ 5);
                    }
                    bufferedOutputStream.write(b);
                }
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return false;
    }
}

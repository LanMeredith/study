package study.io;

import java.io.*;

/**
 * 测试FileInputStream和FileOutputStream的使用
 *
 * 结论：
 * 1.对于文本文件(.txt,.java,.c,.cpp...)，使用字符流处理
 * 2.对于非文本文件(.jpg,.mp3,.mp4,.avi,.doc,.ppt...)，使用字节流处理
 *      使用字节流处理文本文件可能会出现乱码
 *      可以用于文本文档的复制，但是不可用于读取文本文档
 * @author shkstart
 * @create 2021-02-13-16:07
 */
public class StudyFileInputStreamAndOutputStream {
    public static void main(String[] args) {
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            File file1 = new File("D:\\JAVA_IDEA\\IO\\study\\img.png");
            File file2 = new File("D:\\JAVA_IDEA\\IO\\study\\Copyimg.png");
            inputStream = new FileInputStream(file1);
            outputStream = new FileOutputStream(file2);

            byte[] cbuf = new byte[8];
            int len;
            while ((len = inputStream.read(cbuf)) != -1){
                outputStream.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

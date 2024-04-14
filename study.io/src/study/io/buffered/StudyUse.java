package study.io.buffered;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之一：缓冲流的使用
 * <p>
 * 1.缓冲流：
 * bufferInputStream
 * bufferOutputStream--flush()
 * bufferReader
 * bufferWriter--flush()
 * <p>
 * 2.作用：提供流的读取、写入速度
 * 提高读写速度的原因：内部提供了一个缓冲区
 *
 * 3.处理流，就是“套接”在已有的流的基础上
 *
 * @author shkstart
 * @create 2021-02-15-15:01
 */
public class StudyUse {
    /**
    实现非文本文件的复制
     */
    @Test
    public void test1() {
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        BufferedInputStream bufferedInput = null;
        BufferedOutputStream bufferedOutput = null;
        try {
            File file1 = new File("D:\\JAVA_IDEA\\IO\\study\\img.png");
            File file2 = new File("D:\\JAVA_IDEA\\IO\\study\\copy.png");

//            先造节点流
            inputStream = new FileInputStream(file1);
            outputStream = new FileOutputStream(file2);

//            再造缓冲流
            bufferedInput = new BufferedInputStream(inputStream);
            bufferedOutput = new BufferedOutputStream(outputStream);

//            进行复制
            byte[] b = new byte[1024];
            int len;
            while ((len = bufferedInput.read(b)) != -1) {
                bufferedOutput.write(b, 0, len);
            }

            /*
            对于read()，当参数为byte[] b,int off,int len时
            意为使用数组b装填，从off开始，到len结束
            如下则是从0开始到48结束，纵使b的容量有1024，也只用到48
            while((len = bufferedInput.read(b,0,48)) != -1){
                bufferedOutput.write(b,0,len);
            }
             */

            System.out.println("复制完成");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//            资源关闭
//            要求：先关闭外层流，再关闭内层流
            if (bufferedInput != null) {
                try {
                    bufferedInput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bufferedOutput != null) {
                try {
                    bufferedOutput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

//            说明：关闭外层流的同时，内层流也会自动的进行关闭。关于内存流的关闭，我们可以省略。
            /*
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
             */
        }
    }

    /*
    实现文本文件的复制
     */
    @Test
    public void test2(){
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            File file1 = new File("ReaderAndWriter.txt");
            File file2 = new File("D:\\JAVA_IDEA\\IO\\ReaderAndWriter.txt");

            FileReader reader = new FileReader(file1);
            FileWriter writer = new FileWriter(file2);

            bufferedReader = new BufferedReader(reader);
            bufferedWriter = new BufferedWriter(writer);

            /*
            方式一
            char[] cbuf = new char[1024];
            int len;
            while ((len = bufferedReader.read(cbuf)) != -1){
                String str = new String(cbuf,0,len);
                bufferedWriter.write(str);
            }
             */

//            方式二，使用readLine()方法，str为每一行的内容
            String str;
            while((str = bufferedReader.readLine()) != null){
//                str中不包含换行符，需要手动换行
                bufferedWriter.write(str);
//                 newLine()用于换行
                bufferedWriter.newLine();
            }

            bufferedWriter.write("文本文件缓冲流复制完成");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
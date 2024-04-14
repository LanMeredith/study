package study.io.data;

import org.junit.Test;

import java.io.*;

/**
 * 数据流
 * 1.DataInputStream和DataOutputStream
 * 2.作用：为了读取或写出基本数据类型的变量或字符串
 * @author shkstart
 * @create 2021-02-22-15:44
 */
public class StudyData {
    /**
    练习：将内存中的字符串、基本数据类型的变量写出到文件中
     */
    @Test
    public void test1(){
        DataOutputStream stream = null;
        try {
            stream = new DataOutputStream(new FileOutputStream
                    ("D:\\JAVA_IDEA\\IO\\test.txt"));
            stream.writeUTF("颜铭鹤");
//            刷新操作，将内存中的数据写入到文件中，清空缓冲区数据
            stream.flush();
            stream.writeInt(20);
            stream.flush();
            stream.writeChar('男');
            stream.flush();
        } catch (IOException e) {
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

    /**
    将文件中存储的基本数据类型变量和字符串读取到内存中，保存在变量中

    注意：读取不同类型的数据的顺序要与当初写入文件时，保存的数据的顺序一致！！！
     */
    @Test
    public void test2(){
        DataInputStream inputStream = null;
        try {
            inputStream = new DataInputStream(new FileInputStream
                    ("D:\\JAVA_IDEA\\IO\\test.txt"));
            String name = inputStream.readUTF();
            int age = inputStream.readInt();
            char gender = inputStream.readChar();
            System.out.println("name = " + name);
            System.out.println("age = " + age);
            System.out.println("gender = " + gender);
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
        }
    }
}

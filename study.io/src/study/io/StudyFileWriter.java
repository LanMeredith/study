package study.io;

import org.junit.Test;

import java.io.*;

/**
 * @author shkstart
 * @create 2021-02-13-15:37
 */
public class StudyFileWriter {
    /**
    从内存中写出数据到硬盘的文件中
    说明：
    1.输出操作，对应的File可以不存在。
    2.file对应的硬盘文件不存在，则在输出过程中会进行创建。
    file对应的硬盘文件存在，则在根据构造器进行不同的操作
    如果是FileWriter(file)/FileWriter(file,false)则会对原有文件进行覆盖
    如果是FileWriter(file,true)则会在原有文件末尾添加
    如果是对图片进行字节流复制，选择FileWriter(file,true)后，图片的内存会进行增加
     */
    @Test
    public void test1() {
        FileWriter writer = null;
        try {
//        1.提供File类的对象，指明写出到的文件
            File file = new File("ReaderAndWriter.txt");

//        2.提供FileWriter的对象，用于数据的写出
            writer = new FileWriter(file);

//        3.写出的操作
            writer.write("\n这是写入操作的测试");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
//        4.流资源的关闭
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
    利用FileReader和FileWriter完成文件的复制
    不能使用字符流来处理图片等字节数据
     */
    @Test
    public void test2(){
        FileReader reader = null;
        FileWriter writer = null;
        try {
            File file1 = new File("ReaderAndWriter.txt");
            File file2 = new File("CopyReaderAndWriter.txt");
            reader = new FileReader(file1);
            writer = new FileWriter(file2);

            char[] cbuf = new char[5];
            int len;
            while ((len = reader.read(cbuf)) != -1){
                writer.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//            无先后关闭顺序要求
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (writer != null)
                    writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

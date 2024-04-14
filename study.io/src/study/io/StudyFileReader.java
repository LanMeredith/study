package study.io;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author shkstart
 * @create 2021-02-13-11:04
 */
public class StudyFileReader {
    /**
    将ReaderAndWriter.txt文件内容读入程序中，并输出到控制台

    说明：
    1.read()的理解：返回读入的一个字符，如果达到文件末尾则返回-1
    2.异常的处理：为了保证流资源一定可以执行关闭操作。需要使用try-catch-finally处理
    3.读入的文件一定要存在，否则会报错FileNotFoundException
     */
    @Test
    public void test1(){
        FileReader fileReader = null;
        try {
//        1.实例化File对象，指明要操作的文件
            File file = new File("ReaderAndWriter.txt");
//        相较于当前Module下，如果是在main()中，则相较于当前工程下
//        想要在工程下指向当前module中的文件，可以写成study_io\\ReaderAndWriter.txt

//        2.提供具体流
            fileReader = new FileReader(file);

//        3.数据的读入
//        read()返回读入的一个字符。如果达到文件末尾，返回-1
            int len = fileReader.read();
            while(len != -1){
                System.out.print((char) len);
                len = fileReader.read();
            }

            /*方式二
            int end;
            while((end = fileReader.read()) != -1){
                System.out.println((char) end);
            }
             */

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//        4.流的关闭操作
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            /*
            先判断或者在try中判断不影响
            if (fileReader == null) {
                try{
                    fileReader.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
             */
        }
    }


    /**
    FileReader升级写法
     */
    @Test
    public void test2(){
        FileReader reader = null;
        try {
            File file = new File("ReaderAndWriter.txt");
            reader = new FileReader(file);
            char[] cbuffer = new char[5];
            int len;
//            读入操作：read(char[] cbuf)返回每次读入cbuf数组中的字符的个数。如果达到文件末尾，返回-1
            while((len = reader.read(cbuffer)) != -1){
                /*
                第一种写法
                注意：for中i不能小于cbuffer.length，因为数组的内容在第一次填充后，后续赋值都是进行覆盖
                当文本内容只剩下三个字符的时候，数组的前三个元素被覆盖成新的字符，而后两个字符则依旧是上一轮的
                在循环时则会循环五遍，将上一轮剩下没有被覆盖的字符也打印出来
                */
                for (int i = 0; i < len; i++) {
                    System.out.print(cbuffer[i]);
                }

                /*
                将字符数组转成字符串，从字符数组的零开始，到len结束，len=每次读入数组中的字符的个数
                如果在new String()中写入一个参数cbuffer的话，则会出现将上一轮剩下没有被覆盖的字符
                原因如上
                 */
                String str = new String(cbuffer,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

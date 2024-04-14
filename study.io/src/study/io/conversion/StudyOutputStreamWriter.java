package study.io.conversion;

import org.junit.Test;

import java.io.*;

/**
 * @author shkstart
 * @create 2021-02-17-13:52
 */
public class StudyOutputStreamWriter {
    @Test
    public void test1(){
        OutputStreamWriter streamWriter = null;
        try {
            FileOutputStream stream = new FileOutputStream("D:\\JAVA_IDEA\\IO\\StudyOutputStreamWriter.txt");
//            保存指定的格式
            streamWriter = new OutputStreamWriter(stream, "gbk");

            streamWriter.write("将我现在输入的内容保存在D:\\JAVA_IDEA\\IO\\StudyOutputStreamWriter.txt中，" +
                    "保存方法为gbk");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (streamWriter != null) {
                try {
                    streamWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    综合使用
    读取一个以GBK保存的文件
    复制出一个以UTF-8保存的文件
     */
    @Test
    public void test2(){
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        try {
//            读，文件以gbk编码集保存，所以要用gbk编码集读取
            FileInputStream inputStream = new FileInputStream
                    ("D:\\JAVA_IDEA\\IO\\StudyOutputStreamWriter.txt");
            inputStreamReader = new InputStreamReader(inputStream,"gbk");
//            写，用utf-8的方式保存
            FileOutputStream outputStream = new FileOutputStream
                    ("D:\\JAVA_IDEA\\IO\\StudyOutputStreamWriterCopy.txt");
            outputStreamWriter = new OutputStreamWriter(outputStream,"UTF-8");

            char[] cbuf = new char[1024];
            int len;
            while ((len = inputStreamReader.read(cbuf)) != -1) {
                String str = new String(cbuf, 0, len);
                System.out.println(str);
                outputStreamWriter.write(str);
            }
            outputStreamWriter.write("现将保存方法更改为UTF-8");
            System.out.println("完成");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStreamWriter != null) {
                    outputStreamWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

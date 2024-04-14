package study.io.print;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * @author shkstart
 * @create 2021-02-22-15:13
 */
public class StudyPrintStreamAndPrintWriter {
    /**
    打印流：PrintStream和PrintWriter
    1.提供了一系列重载的print()和println()
    2.练习
     */
    @Test
    public void test1(){
        PrintStream printStream = null;
        try {
            FileOutputStream stream = new FileOutputStream("D:\\JAVA_IDEA\\IO\\hi.txt");
//            创建打印输出流，设置为自动刷新模式（写入换行符或字节'\n'时都会刷新输出缓冲区）
            printStream = new PrintStream(stream);
//            把标准输出流（控制台输出）改成文件
            if (printStream != null) {
                System.setOut(printStream);
            }

//            输出ASCII字符
            for (int i = 0; i < 255; i++) {
                System.out.print((char) i);
//                每50个数据一行
                if (i % 50 == 0) {
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (printStream != null) {
                printStream.close();
            }
        }
    }
}

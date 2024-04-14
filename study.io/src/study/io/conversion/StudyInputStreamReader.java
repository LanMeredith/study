package study.io.conversion;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 处理流之二：转换流
 * 1.转换流属于字符流
 * InputStreamReader：将一个字节的输入流转换成字符的输入流
 * OutputStreamWriter：将一个字符的输出流转换成字节的输出流
 *
 * 2.作用：
 * 提供字节流与字符流之间的转换
 *
 * 3.解码：字节、字节数组 --> 字符、字符数组
 *   编码：字符、字符数组 --> 字节、字节数组
 *
 * 4.字符集
 * 常见编码表：
 * ASCII：美国标准信息交换码
 *      用一个字节的七位可以表示
 * ISO8859-1：拉丁码表。欧洲码表
 *      用一个字节的八位表示
 * GB2312：中国的中文编码表。最多两个字节编码所有字符
 * GBK：中国的中文编码表升级，融合了更多的中文文字符合。最多两个字节编码
 * Unicode：国际标准码，融合了目前人类使用的所有字符。为每个字符分配唯一的字符码，
 * UTF-8：变长的编码方式，可用1-4个字节来表示一个字符
 * @author shkstart
 * @create 2021-02-17-13:30
 */
public class StudyInputStreamReader {
    /**
     * InputStreamReader的使用，实现字节的输入流到字符的输入流的转换
     */
    @Test
    public void test1(){
        InputStreamReader reader = null;
        try {
            FileInputStream inputStream = new FileInputStream("CopyReaderAndWriter.txt");
//        使用系统默认的字符集
            reader = new InputStreamReader(inputStream);
//        参数二指明了字符集，具体使用哪个字符集，取决的保存文件时使用的是哪个字符集
//        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            char[] c = new char[1024];
            int len;
            while((len = reader.read(c)) != -1){
                String str = new String(c,0,len);
                System.out.println(str);
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

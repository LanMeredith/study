package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 利用FileInputStream和FileOutputStream完成如下要求：
 * 1.用FileOutputStream在指定目录下创建一个文件“July26.txt”，并向文件输出“HelloWorld”，如果文件已存在，则在原有文件内容后追加
 * 2.用FileInputStream读入“July26.txt”，并在控制台上打印出内容
 * 3.要求用try-catch-finally处理异常，并且关闭流用放在finally中
 *
 * @author shkstart
 * @create 2021-07-26-13:17
 */
public class Five {
    public static void main(String[] args) {
        FileOutputStream outputStream = null;
        FileInputStream inputStream = null;
        try {
            File file = new File("D:\\JAVA_IDEA\\IO\\July26.txt");
//            file对应的硬盘文件存在，则会根据构造器进行不同的操作,如果是FileWriter(file,true)就会在原有文件末尾添加
            outputStream = new FileOutputStream(file, true);
            inputStream = new FileInputStream(file);

//            若不存在则直接写入，若存在则进行追加
            outputStream.write("HelloWorld\n".getBytes(StandardCharsets.UTF_8));

//            将读取的数据保存在StringBuilder中
            StringBuilder builder = new StringBuilder((int) file.length());
            byte[] bytes = new byte[1024];
            int len;
            while ((len = inputStream.read(bytes)) != -1) {
                builder.append(new String(bytes, 0, len));
            }
            System.out.println(builder);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//            关闭流
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

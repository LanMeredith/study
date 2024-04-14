package practice;

import java.io.*;

/**
 * 利用Data流，完成下面操作：
 * 1.判断当前目录下是否存在一个“July26Two.dat”的文件，如果该文件不存在，则往该文件中写入一个long类型的数值：10000L
 * 2.如果该文件存在，则从该文件中读出数值，并把该数值加1之后，再存回文件中
 *
 * @author shkstart
 * @create 2021-07-26-16:13
 */
public class Six {
    public static void main(String[] args) {
        DataOutputStream outputStream = null;
        DataInputStream inputStream = null;
        try {
            File file = new File("D:\\JAVA_IDEA\\IO\\July26Two.dat");
//            判断该文件是否存在
            boolean isExist = file.exists();
//            若是不存在就进入运行
            if (!isExist) {
//                每一次newFileOutputStream对象都会让file指向的文件刷新：无file就创建，有则进行覆盖
                FileOutputStream OStream = new FileOutputStream(file);
//                数据输出流（写）
                outputStream = new DataOutputStream(OStream);
                outputStream.writeLong(10000L);
//                刷新操作，将内存中的数据写入到文件中，清空缓冲区数据
                outputStream.flush();
            } else {
                FileInputStream IStream = new FileInputStream(file);
//                数据输入流（读）
                inputStream = new DataInputStream(IStream);
                long l = inputStream.readLong();
                FileOutputStream OStream = new FileOutputStream(file);
//                数据输出流（写）
                outputStream = new DataOutputStream(OStream);
                outputStream.writeLong(++l);
                outputStream.flush();
//                将l打印出来检验成果·
                System.out.println(l);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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

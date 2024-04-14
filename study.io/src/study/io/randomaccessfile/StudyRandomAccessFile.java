package study.io.randomaccessfile;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 随机存取文件流
 * RandomAccessFile的使用
 * 1.RandomAccessFile直接继承于java.lang.Object类，实现了DataInput和DataOutput接口
 * 2.RandomAccessFile既可以作为一个输入流，又可以作为一个输出流（同一个类，但需要两个对象分别负责输入和输出）
 * 3.如果RandomAccessFile作为输出流时，写出到的文件如果不存在，则在执行过程中自动创建
 * 如果写出到的文件存在，则会对原有文件的内容进行覆盖（默认情况下，从头覆盖）
 *
 * seek(int pos)将指针定位到pos的位置
 * @author shkstart
 * @create 2021-04-13-20:42
 */
public class StudyRandomAccessFile {
    /**
    * 复制练习，将img.png文件复制到accessFile.png文件
    */
    @Test
    public void test1(){
        RandomAccessFile accessFile = null;
        RandomAccessFile accessFile1 = null;
        try {
//            做输入用
            accessFile = new RandomAccessFile(new File("D:\\JAVA_IDEA\\IO\\study\\img.png"), "r");
//            做输出用
            accessFile1 = new RandomAccessFile(new File("D:\\JAVA_IDEA\\IO\\study\\accessFile.png"), "rw");

//            进行复制
            byte[] cbuf = new byte[1024];
            int len;
            while((len = accessFile.read(cbuf)) != -1){
                accessFile1.write(cbuf, 0, len);
            }

            System.out.println("已成功复制");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (accessFile != null) {
                try {
                    accessFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (accessFile1 != null) {
                try {
                    accessFile1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
    * 在指定位置写入
    */
    @Test
    public void test2(){
        RandomAccessFile rw = null;
        try {
            File file = new File("D:\\JAVA_IDEA\\IO\\rw.txt");
            rw = new RandomAccessFile(file, "rw");
//            将指针调到角标为3的位置
            rw.seek(3);
            /*
            获取文件长度，通过将指针调到文件末尾部分，以此达到将内容输出在文件末尾
            long i = file.length();
            rw.seek(i);
            */
            rw.write("RandomAccessFile".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (rw != null) {
                try {
                    rw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 将此作为输出流时，如何做到插入效果而不覆盖。
     */
    @Test
    public void test3(){
        RandomAccessFile rw = null;
        try {
            File file = new File("D:\\JAVA_IDEA\\IO\\rw.txt");
            rw = new RandomAccessFile(file, "rw");
//            将指针调整到角标为3的位置
            rw.seek(3);

//        复制指针3后面的所有数据到StringBuilder中
            StringBuilder builder = new StringBuilder((int) file.length());
            byte[] cbuf = new byte[1024];
            int len;
            while((len = rw.read(cbuf)) != -1){
                builder.append(new String(cbuf,0,len));
            }

//            调回指针，写入内容
            rw.seek(3);
            rw.write("StringBuilder".getBytes());

//            将StringBuilder中的数据写入文件中
            rw.write(builder.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (rw != null) {
                try {
                    rw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

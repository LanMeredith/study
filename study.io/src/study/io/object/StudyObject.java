package study.io.object;

import org.junit.Test;

import java.io.*;
import java.util.Date;

/**
 * 对象流：
 * 1.ObjectInputStream 和 ObjectOutputStream
 * 2.用于存储和读取基本数据类型数据或对象的处理流
 * 它的强大之处就是可以把java中的对象写入到数据源中，也能把对象从数据源中还原出来
 * <p>
 * 序列化：用ObjectOutputStream类保存基本类型数据或对象的机制
 * 反序列化：用ObjectInputStream类读取基本类型数据或对象的机制
 * 不可序列化static和transient修饰的成员变量
 *
 * @author shkstart
 * @create 2021-03-13-14:34
 */
public class StudyObject {
    /**
    序列化过程：将内存中的java对象保存到磁盘中或通过网络传输出去
    使用ObjectOutputStream实现
     */
    @Test
    public void test1() {
        ObjectOutputStream stream = null;
        try {
//            要写入的文件
            stream = new ObjectOutputStream(new FileOutputStream
                    ("D:\\JAVA_IDEA\\IO\\3-13.dat"));
//            对该文件写入对象
            stream.writeObject(new Date());
            stream.writeObject(new Person("张三", 18));
            stream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
    反序列化：将磁盘文件中的对象还原为内存中的一个java对象
    使用ObjectInputStream实现
     */
    @Test
    public void test2() {
        ObjectInputStream input = null;
        try {
//            要读取的文件
            input = new ObjectInputStream(new FileInputStream
                    ("D:\\JAVA_IDEA\\IO\\3-13.dat"));
//            读取文件中的对象，并且进行强转
            Date date = (Date) input.readObject();
            Person per = (Person) input.readObject();
            System.out.println(date);
            System.out.println(per);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

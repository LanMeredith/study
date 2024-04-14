package study.file;


import org.junit.Test;

import java.io.File;

/**
 * File的使用
 * 1.File类的一个对象，代表一个文件或一个文件目录（俗称：文件夹）
 * 2.File类声明在java.io包下
 * 3.File类中涉及到关于文件或文件目录的创建、删除、重命名、修改时间、文件大小等方法
 *      并未涉及到写入或读取文件内容的操作。如果需要读取或写入文件内容，必须使用IO流来完成
 * 4.后续File类的对象常会作为参数传递到流的构造器中，指明读取或写入的“终点“
 * @author shkstart
 * @create 2021-02-02-14:54
 */
public class StudyFile {
    /*
    1.如何创建File类的实例
    File(String filePath)
    File(String parentPath,String childPath)
    File(File parentFile,String childPath)

    2.
    相对路径：相较于某个路径下指明的路径
    绝对路径：包含盘符在内的文件或文件目录的路径

    3.路径分隔符：
    Windows、DOS：\
    UNIX、URL：/
     */

    /**
     * 构造器一：
     */
    @Test
    public void test1(){
//        相对于当前module
        File file1 = new File("hello.txt");

//        File类提供了一个常量：public static final String separator根据操作系统动态的提供分隔符
        File file2 = new File("D:"+ File.separator+"JAVA_IDEA"+ File.separator+"code"+
                File.separator+"study"+ File.separator+"he.txt");
//        File file2 = new File("D:\\JAVA_IDEA\\code\\study\\he.txt");

        System.out.println(file1);
        System.out.println(file2);
    }

    /**构造器二、三：*/
    @Test
    public void test2(){
//        构造器二
        File file = new File("D:\\JAVA_IDEA\\code","study");
        System.out.println(file);

//        构造器三
        File file1 = new File(file, "hi.txt");
        System.out.println(file1);
    }
}

package study.file;

import org.junit.Test;

import java.io.File;
import java.util.Date;

/**
 * File的常用方法
 *
 *     public String getAbsolutePath()获取绝对路径
 *     public String getPath()获取路径
 *     public String getName()获取名称
 *     public String getParent()获取上层文件目录路径，若无则返回null
 *     public long length()获取文件长度（即为字节数）不能获取目录的长度
 *     public long lastModified()获取最后一次的修改时间，毫秒数
 *
 *     public String[] list()获取指定目录下的所有文件或者文件目录的名称数组
 *     public File[] listFiles()获取指定目录下的所有文件或者文件目录的File数组
 *
 *     public boolean renameTo(File dest)把文件重命名为指定的文件路径(文件移动）
 *     比如：file1.renameTo(file2)为例
 *         要想保证返回true，需要file1在硬盘中是存在的，且file2不能在硬盘中存在
 *
 *     public boolean isDirectory()判断是否是文件目录
 *     public boolean isFile()判断是否文件
 *     public boolean exists()判断是否存在
 *     public boolean canRead()判断是否可读
 *     public boolean canWrite()判断是否可写
 *     public boolean isHidden()判断是否隐藏
 * @author shkstart
 * @create 2021-02-03-13:52
 */
public class StudyFileUsed {
    /**
    public String getAbsolutePath()获取绝对路径
    public String getPath()获取路径
    public String getName()获取名称
    public String getParent()获取上层文件目录路径，若无则返回null
    public long length()获取文件长度（即为字节数）不能获取目录的长度
    public long lastModified()获取最后一次的修改时间，毫秒数
     */
    @Test
    public void test1(){
        File file1 = new File("hello.txt");
        File file2 = new File("D:\\JAVA_IDEA\\IO\\hi.txt");

//        获取绝对路径
        System.out.println(file1.getAbsoluteFile());
//        获取路径
        System.out.println(file1.getPath());
//        获取名称
        System.out.println(file1.getName());
//        获取上层文件目录路径，若无则返回null
        System.out.println(file1.getParent());
//        获取文件长度（即为字节数）不能获取目录的长度
        System.out.println(file1.length());
//        获取最后一次的修改时间，毫秒数
        System.out.println(new Date(file1.lastModified()));

        System.out.println();

        System.out.println(file2.getAbsoluteFile());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(new Date(file2.lastModified()));
    }


    /**
    public String[] list()获取指定目录下的所有文件或者文件目录的名称数组
    public File[] listFiles()获取指定目录下的所有文件或者文件目录的File数组
    注意：如果是文件的话则为null
     */
    @Test
    public void test2(){
        File file = new File("D:\\JAVA_IDEA\\code\\study\\bilibili\\src");

//        获取指定目录下的所有文件或者文件目录的名称数组
        String[] list = file.list();
        for (String str:
             list) {
            System.out.println(str);
        }

        System.out.println();

//        获取指定目录下的所有文件或者文件目录的File数组
        File[] files = file.listFiles();
        for (File f:
             files) {
            System.out.println(f);
        }
    }


    /**
    public boolean renameTo(File dest)把文件重命名为指定的文件路径(文件移动）
    比如：file1.renameTo(file2)为例
        要想保证返回true，需要file1在硬盘中是存在的，且file2不能在硬盘中存在
     */
    @Test
    public void test3(){
        File file1 = new File("hello.txt");
        File file2 = new File("D:\\JAVA_IDEA\\IO\\hi.txt");
        System.out.println(file1.renameTo(file2));
    }


    /**
    public boolean isDirectory()判断是否是文件目录
    public boolean isFile()判断是否文件
    public boolean exists()判断是否存在
    public boolean canRead()判断是否可读
    public boolean canWrite()判断是否可写
    public boolean isHidden()判断是否隐藏
     */
    @Test
    public void test4(){
        File file = new File("hello.txt");
//        判断是否是文件目录
        System.out.println(file.isDirectory());
//        判断是否文件
        System.out.println(file.isFile());
//        判断是否存在
        System.out.println(file.exists());
//        判断是否可读
        System.out.println(file.canRead());
//        判断是否可写
        System.out.println(file.canWrite());
//        判断是否隐藏
        System.out.println(file.isHidden());

        System.out.println();

        File file1 = new File("D:\\JAVA_IDEA\\IO");
        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());

        System.out.println();

        File file2 = new File("D:\\JAVA_IDEA\\JAVA");
        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());
    }
}

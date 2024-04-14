package practice;

import java.io.File;
import java.io.IOException;

/**
 * 利用File构造器，new一个文件目录File
 * （1）在其中创建多个文件或目录
 * （2）编写方法，实现删除file中指定文件的操作
 * @author shkstart
 * @create 2021-02-05-14:03
 */
public class One {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\JAVA_IDEA\\IO\\practice\\One");
        file.mkdirs();
        File file1 = new File(file.getParent(), "1.txt");
        File file2 = new File(file.getParent(), "2");
        System.out.println(file1.createNewFile());
        System.out.println(file2.mkdirs());

        System.out.println(delete(new File("D:\\JAVA_IDEA\\IO\\practice")));
    }
    public static boolean delete(File file){
        if (file.exists()){
            File[] files = file.listFiles();
            if (files == null){
                file.delete();
            }else{
                for (File f:
                        files) {
                    delete(f);
                }
                file.delete();
            }
            return true;
        }else{
            return false;
        }
    }
}

package study.file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * File类的创建与删除
 *
 * File创建：
 *      public boolean createNewFile()创建文件。若文件存在，则不创建，返回false
 *      public boolean mkdir()创建文件目录，若文件目录存在，则不创建。若此文件目录的上层目录也不存在，则不创建
 *      public boolean mkdirs()创建文件目录，若此文件目录的上层目录不存在，一并创建
 * 注意：如果创建文件或文件目录没有写盘符路径，那么默认在项目路径下
 * 说明：IDEA中：如果大家开发使用JUnit中的单元测试方法测试，相对路径即为当前Module下。
 *      如果大家使用main()测试，相对路径即为当前的Project下
 *      Eclipse中：不管使用单元测试方法还是使用main()测试，相对路径都是当前的Project下
 *
 * File删除：
 *      public boolean delete()删除文件或文件目录
 * 注意：JAVA中的删除不走回收站
 *     要想删除成功，文件目录下不能有子目录或文件
 * @author shkstart
 * @create 2021-02-03-15:00
 */
public class StudyFileCreateAndDelete {
    /**
     * 文件的创建与删除
     */
    @Test
    public void test1() throws IOException {
        File file = new File("D:\\JAVA_IDEA\\IO\\hi.txt");
        if (!file.exists()){
            file.createNewFile();
            System.out.println("创建成功");
        }else{
            //文件存在
            file.delete();
            System.out.println("删除成功");
        }
    }

    /**
     * 文件目录的创建与删除,要想删除成功，文件目录下不能有子目录或文件
     */
    @Test
    public void test2(){
        File file = new File("D:\\JAVA_IDEA\\IO\\study\\test");
        boolean mkdir = file.mkdir();
        if(!mkdir){
            file.mkdirs();
            System.out.println("创建成功");
        }
    }
}

package practice;

import java.io.File;

/**
 * 判断指定目录下是否有后缀名为.jpg的文件，如果有，就输出该文件的名称
 * @author shkstart
 * @create 2021-02-05-15:08
 */
public class Two {
    public static void main(String[] args) {
        File file = new File("D:\\JAVA_IDEA\\IO\\study\\test");
        if (file.exists()){
            String[] list = file.list();
            for (String str:
                 list) {
                if(str.endsWith(".jpg")){
                    System.out.println(str);
                }
            }
        }else{
            System.out.println("文件不存在");
        }
    }
}

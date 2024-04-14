import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Map的实现类Properties
 * Properties：常用来处理配置文件。key和value都是String类型
 *
 * @author shkstart
 * @create 2021-01-24-14:44
 */
public class StudyProperties {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            Properties pros = new Properties();

            fis = new FileInputStream("jdbc.properties");
            //加载流对应的文件
            pros.load(fis);

            String name = pros.getProperty("name");
            String password = pros.getProperty("password");

            System.out.println("name = " + name + ",password = " + password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

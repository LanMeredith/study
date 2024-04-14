import org.junit.Test;

import java.io.*;
import java.util.Properties;

/**
 * 了解类的加载器
 * @author shkstart
 * @create 2021-07-22-22:18
 */
public class StudyClassloader {
    @Test
    public void test() {
//        对于自定义类，使用系统类加载器进行加载，通过getClassLoader()方法获取类的加载器
        ClassLoader loader = StudyClassloader.class.getClassLoader();
        System.out.println(loader);

//        调用系统类加载器的getParent()：获取扩展类加载器
        ClassLoader loader1 = loader.getParent();
        System.out.println(loader1);

//        调用扩展类加载器的getParent()：无法获取引导类加载器
//        引导类加载器主要负责加载JAVA的核心类库，无法加载自定义类的
        ClassLoader loader2 = loader1.getParent();
        System.out.println(loader2);
    }

    /**
     * Properties：用来读取配置文件
     * @throws FileNotFoundException
     */
    @Test
    public void test2() throws IOException {
        Properties properties = new Properties();
        /*
        读取配置文件的方式一：
        此时的文件默认在当前的module下（如果是在Eclipse中则默认在当前工程下）

        FileInputStream inputStream = new FileInputStream("jdbc.properties");
        properties.load(inputStream);
        */

        /*
        如何使用方式一调用在src下的文件：
        FileInputStream inputStream = new FileInputStream("src\\jdbcone.properties");
         */

        /*
        读取配置文件的方式二：使用ClassLoader
        此时的文件默认并不在当前的module下，而是存在于当前module的src中
        先获取一个类的加载器
         */
        ClassLoader loader = StudyClassloader.class.getClassLoader();
        InputStream asStream = loader.getResourceAsStream("jdbcone.properties");
        properties.load(asStream);

        String name = properties.getProperty("name");
        String age = properties.getProperty("age");
        System.out.println("name = " + name + ", age = " + age);
    }
}

import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL：统一资源定位符，对应着互联网的某一资源地址
 * 格式：
 * https://www.bilibili.com/video/BV1Kb411W75N?p=629
 * 协议://主机名:端口号/资源地址?参数列表
 * @author shkstart
 * @create 2021-05-28-21:33
 */
public class StudyURL {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.bilibili.com/video/BV1Kb411W75N?p=629");

//            获取该URL的协议名
            System.out.println(url.getProtocol());

//            获取该URL的主机名
            System.out.println(url.getHost());

//            获取该URL的端口号
            System.out.println(url.getPort());

//            获取该URL的文件路径
            System.out.println(url.getPath());

//            获取该URL的文件名
            System.out.println(url.getFile());

//            获取该URL的查询名
            System.out.println(url.getQuery());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}

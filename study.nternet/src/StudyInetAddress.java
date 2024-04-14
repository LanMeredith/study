import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author shkstart
 * @create 2021-05-13-16:07
 * 一：网络编程中有两个主要的问题：
 * 1.如何准确地定位网络上一台或多台主机；定位主机上的特定的应用
 * 2.找到主机后，如何可靠高效地进行数据传输
 *
 * 二：网络编程中的两个要素：
 * 1.对应问题一：IP和端口号
 * 2.对应问题二：提供网络通信协议：TCP/IP参考模型（应用层、传输层、网络层、物理+数据链路层）
 *
 * 三：通信要素一：IP和端口号
 * 1.IP：唯一的标识Internet上的计算机（通信实体）
 * 2.在java中使用InetAddress类代表IP
 * 3.IP分类：IPV4和IPV6；万维网和局域网
 * 4.域名：www.baidu.com   www.atguigu.com
 *   域名解析：域名容易记忆，当连接网络时输入一个主机的域名后，域名服务器(DNS)负责将域名转化为IP地址，这样才能和主机建立联系
 * 5.本地回路地址：127.0.0.1   对应着：localhost
 * 6.如何实例化InetAddress：两个方法：getByName(String host)、getLocalHost()
 * 两个常用方法：getHostName() / getHostAddress()
 * 7.端口号：正在计算机上运行的进程
 * 要求：不同的进程有不同的端口号
 * 范围：被规定为一个16位的整数0~65535
 * 8.端口号与IP地址的组合得出一个网络套接字：Socket
 */
public class StudyInetAddress {
    public static void main(String[] args) {
        try {
//            类似于File file = new File("hello.txt");
//            InetAddress此类的一个对象就代表着一个具体的IP地址
            InetAddress inet1 = InetAddress.getByName("192.168.10.14");
            System.out.println(inet1);

            InetAddress inet2 = InetAddress.getByName("www.atguigu.com");
            System.out.println(inet2);

            InetAddress inet3 = InetAddress.getByName("127.0.0.1");
            System.out.println(inet3);

//            获取本机IP
            InetAddress inet4 = InetAddress.getLocalHost();
            System.out.println(inet4);

//            getHostName()查域名
            String hostName = inet2.getHostName();
            System.out.println(hostName);

//            getHostAddress()查地址
            String hostAddress = inet2.getHostAddress();
            System.out.println(hostAddress);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}

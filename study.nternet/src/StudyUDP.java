import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 不可靠的数据传输；以数据报形式发送，数据报限定为64K；效率高
 * UDP协议的网络编程
 * 如果是TCP先运行客户端，在等待一段时间后发现连接不上服务端，将会报错，提示连接失败
 * 但是UDP不会
 * @author shkstart
 * @create 2021-05-25-21:58
 */
public class StudyUDP {
//    发送端
    @Test
    public void sender() {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
            String str = "我是UDP方式发送的文本内容";
            byte[] data = str.getBytes();
            DatagramPacket packet = new DatagramPacket(data, 0, data.length, InetAddress.getLoopbackAddress(), 8848);
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }

//    接收端
    @Test
    public void receiver() {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(8848);
            byte[] bytes = new byte[1024];
            DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length);
            socket.receive(packet);
//        获取packet的数据，从零开始，到内容末尾结束
            String str = new String(packet.getData(),0, packet.getLength());
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}

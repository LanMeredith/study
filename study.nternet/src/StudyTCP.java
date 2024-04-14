import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 可靠的数据传输（三次握手）；进行大数据量的传输；效率低
 * 实现TCP的网络编程
 * 例子1：客户端发送信息给服务端，服务端将信息显示在控制台上
 * @author shkstart
 * @create 2021-05-16-15:24
 */
public class StudyTCP {
//    客户端
    @Test
    public void client(){
        Socket socket = null;
        OutputStream stream = null;
        try {
//            创建socket对象，指明服务器端的ip和端口号
            InetAddress host = InetAddress.getLocalHost();
            socket = new Socket(host,8848);
//            获取一个输出流，用于输出数据
            stream = socket.getOutputStream();
//            写出数据的操作
            stream.write("你好，我是客户端".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//            资源的关闭
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

//    服务端
    @Test
    public void server(){
        ServerSocket ss = null;
        Socket socket = null;
        InputStream stream = null;
        ByteArrayOutputStream baos = null;
        try {
//            创建服务器端的ServerSocket，指明自己的端口号
            ss = new ServerSocket(8848);
//            调用accept()表示接收来自于客户端的socket
            socket = ss.accept();
//            获取输入流
            stream = socket.getInputStream();

        /*
        不建议这样写，可能会出现乱码
        byte[] buffer = new byte[1024];
        int len;
        while((len = stream.read(buffer)) != -1){
            String str = new String(buffer, 0, len);
            System.out.print(str);
        }
        */

//            读取输入流中的数据
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = stream.read(buffer)) != -1) {
                baos.write(buffer,0,len);
            }
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//            关闭资源
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

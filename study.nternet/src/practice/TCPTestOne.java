package practice;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 客户端发送文件给服务端，服务端将文件保存在本地
 * @author shkstart
 * @create 2021-05-23-21:18
 */
public class TCPTestOne {
//    客户端
    @Test
    public void client(){
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        try {
//            创建socket对象，指明服务器端的ip和端口号
            socket = new Socket(InetAddress.getLocalHost(), 9090);
//            获取一个输出流，用于输出数据
            os = socket.getOutputStream();
//            访问文件
            fis = new FileInputStream("D:\\JAVA_IDEA\\IO\\study\\img.png");
//            写出数据
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fis.read(bytes)) != -1) {
                os.write(bytes,0,len);
            }
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
            if (os != null) {
                try {
                    os.close();
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
        FileOutputStream fos = null;
        try {
//            创建服务器端的ServerSocket，指明自己的端口号
            ss = new ServerSocket(9090);
//            调用accept()表示接收来自于客户端的socket
            socket = ss.accept();
//            获取输入流
            stream = socket.getInputStream();
//            接收后要保存在本地的文件
            fos = new FileOutputStream("D:\\JAVA_IDEA\\IO\\study\\img2.png");
            byte[] bytes = new byte[1024];
            int len;
            while ((len = stream.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
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

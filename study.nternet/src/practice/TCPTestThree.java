package practice;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 客户端给服务端发送文本，服务端会将文本转成大写再返回给客户端
 * @author shkstart
 * @create 2021-05-25-20:55
 */
public class TCPTestThree {
//    客户端
    @Test
    public void cliend() {
        Socket socket = null;
        OutputStream os = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
//        创建socket对象，指明服务器端的ip和端口号
            socket = new Socket(InetAddress.getLocalHost(), 8848);
//        获取一个输出流，用于输出数据
            os = socket.getOutputStream();
//        写出数据的操作
            os.write("I broke up on May 15th".getBytes());

//        关闭数据的输出
            socket.shutdownOutput();

//            接收来自服务端的返回
            is = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len2;
            while ((len2 = is.read(buffer)) != -1) {
                baos.write(buffer,0,len2);
            }
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
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
    public void server() {
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        OutputStream os = null;
        try {
//        创建服务器端的ServerSocket，指明自己的端口号
            ss = new ServerSocket(8848);
//        调用accept()表示接收来自于客户端的socket
            socket = ss.accept();
//        获取输入流
            is = socket.getInputStream();
//        读取输入流中的数据
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer,0,len);
            }

//        转成String类型
            String str = String.valueOf(baos);

//        获取一个输出流用于输出数据，返回给客户端
            os = socket.getOutputStream();
//        将String中所有的字符转换成大写并写出数据
            os.write(str.toUpperCase().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
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

package practice;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给客户端。并关闭相应的连接
 * @author shkstart
 * @create 2021-05-24-21:19
 */
public class TCPTestTwo {
//    客户端
    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
//        创建socket对象，指明服务器端的ip和端口号
            socket = new Socket(InetAddress.getLocalHost(), 7274);
//        获取一个输出流，用于输出数据
            os = socket.getOutputStream();
//        访问文件
            fis = new FileInputStream("D:\\JAVA_IDEA\\IO\\studyTCP.txt");
//        写出数据
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fis.read(bytes)) != -1) {
                os.write(bytes, 0, len);
            }

//            关闭数据的输出
            socket.shutdownOutput();

//        获取输入流，接收来自服务端的返回“发送成功”
            is = socket.getInputStream();
//        获取输入流中的数据
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
            if (baos != null) {
                try {
                    baos.close();
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
        FileOutputStream fos = null;
        OutputStream os = null;
        try {
//        创建服务器端的ServerSocket，指明自己的端口号
            ss = new ServerSocket(7274);
//        调用accept()表示接收来自于客户端的socket
            socket = ss.accept();
//        获取输入流
            is = socket.getInputStream();
//        保存文件
            fos = new FileOutputStream("D:\\JAVA_IDEA\\IO\\TCPTextTwo.txt");
            byte[] bytes = new byte[1024];
            int len;
            while ((len = is.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }

//        获取一个输出流用于输出数据，返回给客户端“发送成功”
            os = socket.getOutputStream();
//        写出数据
            os.write("发送成功".getBytes());
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
            if (is != null) {
                try {
                    is.close();
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
}

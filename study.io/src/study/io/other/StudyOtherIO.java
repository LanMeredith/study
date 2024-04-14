package study.io.other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 其他流的使用
 * 标准的输入、输出流
 * @author shkstart
 * @create 2021-02-17-15:14
 */
public class StudyOtherIO {
    /**
    1.标准的输入、输出流
    1.1
    System.in标准的输入流，默认从键盘输入
    System.out标准的输出流，默认从控制台输出
    1.2
    System类的setIn(InputStream is)/setOut(PrintStream ps)方式重新指定输入和输出的流
    1.3
    练习，从键盘输入字符串，要求将读取到的整行字符串转成大写输出，然后继续进行输入操作
    直至输入“exit”时，退出程序(使用Test测试不出结果，需要用main()）
     */
    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            reader = new BufferedReader(isr);
            while(true){
                System.out.println("请输入字符串");
                String str = reader.readLine();
                if ("exit".equalsIgnoreCase(str)) {
                    System.out.println("程序结束");
                    break;
                }
                System.out.println(str.toUpperCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

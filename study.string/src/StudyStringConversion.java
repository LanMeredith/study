import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * 复习String类与其他结构之间的转换
 *
 * @author shkstart
 * @create 2021-01-11-15:23
 */
public class StudyStringConversion {
    public static void main(String[] args) {
        /*
        String与基本数据类型、包装类之间的转换
        String => 基本数据类型、包装类    调用包装类的parseXXX()

        基本数据类型、包装类 => String
        int num = 10;
        连接运算：String s1 = num + "";
        调用String重载的ValueOf(xxx xxx)：String s1 = String.ValueOf(num);
         */
        String s1 = "123";
        int num = Integer.parseInt(s1);


       /*
       String与char[]数组之间的转换
       String => char[]     调用String的toCharArray()

       char[] => String     调用String的构造器
        */
        String s2 = "abc123";
        char[] charArray = s2.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            System.out.println(charArray[i]);
        }

        char[] arr = new char[]{'h', 'e', 'l', 'l', 'o'};
        String str = new String(arr);
        System.out.println(str);


        /*
        String与byte[]之间的转换
        编码：String => byte[]    调用String的getBytes()
        解码：byte[] => String

        编码：字符串 => 字节（二进制数据）
        解码：编码的逆过程，字节 => 字符串

        说明：解码时，要求解码使用的字符集必须与编码时使用的字符集一致，否则会出现乱码
         */
        String str1 = "abc123中国";
//        使用默认的字符集进行转换（编码）
        byte[] b1 = str1.getBytes();
        System.out.println(Arrays.toString(b1));

//        使用默认的字符集进行解码
        String str2 = new String(b1);
        System.out.println(str2);
        System.out.println();

//        使用指定的字符集进行转换，可能会出现错误
        try {
//            使用gbk字符集进行编码
            byte[] b2 = str1.getBytes("gbk");
            System.out.println(Arrays.toString(b2));
//        编码时使用的是gbk，解码时使用UTF-8会导致解码后出现乱码（编码集和解码集不一样）
            String str3 = new String(b2);
            System.out.println(str3);
//            使用gbk解码
            String str4 = new String(b2, "gbk");
            System.out.println(str4);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}

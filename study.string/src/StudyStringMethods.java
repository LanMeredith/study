/**
 * 这里是String类方法实践包下的第一个类
 * 验证了字符串类中常用的几个方法
 * @author shkstart
 * @create 2021-01-11-13:01
 */
public class StudyStringMethods {
    public static void main(String[] args) {
        String s1 = "HelloWorld";
        String s2 = "    Hello     World    ";
        String s3 = "HELLOWORLd";
//        返回字符串的长度
        System.out.println(s1.length());
//        返回某处索引处的字符串
        System.out.println(s1.charAt(2));
//        判断是否为空字符串
        System.out.println(s1.isEmpty());
//        使用默认的语言环境，将String中所有的字符转换成小写
        System.out.println(s1.toLowerCase());
//        使用默认的语言环境，将String中所有的字符转换成大写
        System.out.println(s1.toUpperCase());
//        返回字符串的副本，忽略前导空白和尾部空白
        System.out.println(s2.trim());
//        比较两个字符串的内容是否相同
        System.out.println(s1.equals(s2));
//        与equals()方法类似，但是忽略大小写
        System.out.println(s1.equalsIgnoreCase(s3));
//        将指定字符串连接到此字符串的结尾，等价于"+"
        System.out.println(s1.concat(s2));
//        比较两个字符串的大小，即为用s1-s3，如果是负数则表示s1小于s3，反之大于
        System.out.println(s1.compareTo(s3));
//        返回一个新的字符串，它是此字符串的从beginlndex开始截取到最后的一个子字符串
        System.out.println(s1.substring(5));
//        返回一个新的字符串，它是此字符串的从beginlndex开始截取到enlndex（不包含）的一个子字符串
        System.out.println(s1.substring(3,6));
//        测试此字符串是否以指定的后缀结束
        System.out.println(s1.endsWith("rld"));
//        测试此字符串是否以指定的前缀开始
        System.out.println(s1.startsWith("hello"));
//        测试此字符串从指定索引开始的子字符串是否以指定前缀开始
        System.out.println(s1.startsWith("llo",2));
//        当且仅当此字符串包含指定的char值序列时，返回true
        System.out.println(s1.contains("lo"));

        /*
        索引
        注：indexOf和lastIndexOf方法如果未找到都是返回-1
         */
//        返回指定子字符串在此字符串中第一次出现处的索引
        System.out.println(s1.indexOf("ll"));
//        返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始
        System.out.println(s1.indexOf("o",5));
//        返回指定子字符串在此字符串最右边出现处的索引
        System.out.println(s1.lastIndexOf("l"));
//        返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索
        System.out.println(s1.lastIndexOf("l",7));

        /*
        替换
         */
//        返回一个新的字符串，它是通过用newChar替换此字符串中出现的所有的oldChar得到的
        System.out.println(s1.replace("W","w"));
//        使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串
        System.out.println(s1.replace("Hello","hello"));
    }
}

package practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 对一个url进行解析
 * 要求得到协议是什么
 * 域名是什么
 * 端口是什么
 * 文件名是什么
 * @author SeedList
 * @date: 2022.11.01
 */
public class Three {
    public static void main(String[] args) {
        String content = "https://www.sohu.com:8080/abc/index.htm";
//        String content = "https://www.mx-xz.com/show.asp?id=13";
        String regStr = "(^[\\w]+)://([a-zA-Z.]+):(\\d+)[\\w-/]*/([\\w.]+$)";

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        if (matcher.matches()) {
            System.out.println("整体匹配成功" + matcher.group(0));
            System.out.println("协议名:" + matcher.group(1));
            System.out.println("域名：" + matcher.group(2));
            System.out.println("端口：" + matcher.group(3));
            System.out.println("文件名：" + matcher.group(4));
        } else {
            System.out.println("没有匹配成功");
        }
    }
}

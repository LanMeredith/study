package practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 练习正则表达式
 * 验证电子邮件格式是否合法
 * 规定电子邮件规则为
 * 1.只能有一个@
 * 2.@前面是用户名，可以是a-z A-Z 0-9 _ -字符
 * 3.@后面是域名，并且域名只能是英文字母，比如sohu.com或者tsinghua.org.cn
 * 4.写出对应的正则表达式，验证输入的字符串是否满足规则
 * @author SeedList
 * @date: 2022.11.01
 */
public class One {
    public static void main(String[] args) {
        String content = "2012713669@qq.com";

        /*
        * 匹配字母和数字以及符号“-”多次[\\w-]+
        * 匹配一个@
        * 匹配多个字母或符号“.”多次([a-zA-Z]+\.)+
        * 最后以多个字母结尾[a-zA-Z]+$
        * */
        String regStr = "^[\\w-]+@([a-zA-Z]+\\.)+[a-zA-Z]+$";

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

//        对整个字符串进行匹配，只有整个字符串都匹配才返回true
        System.out.println("matcher.matches() = " + matcher.matches());
    }
}

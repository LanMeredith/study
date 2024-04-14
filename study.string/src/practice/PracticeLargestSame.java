package practice;

/**
 * 获取两个字符串中最大相同子串。比如：
 * str1 = "abcwerthelloyuiodef“;
 * str2 = "cvhellobnm";
 * 提示：将短的那个串进行长度依次递减的子串与较长的串比较
 * @author shkstart
 * @create 2021-01-12-16:53
 */
public class PracticeLargestSame {
    public static void main(String[] args) {
        String str1 = "cvhellobnm";
        String str2 = "abcwertyuiodefhello";
//        取得较长的字符串
        String str3 = str1.length() > str2.length() ? str1 : str2;
//        取得较短的字符串
        String str4 = str1.length() < str2.length() ? str1 : str2;
        String str;
        /*
        对短的字符串str4取长度递减的子串，已知str4长度为X
        则子串的长度变化应是逐渐递减的，长度为X的子串 => 长度为X-1的子串 => 长度为X-2的子串……
        所以截取的长度i从str4的长度X开始逐渐递减
         */
        for (int i = str4.length(); i > 0; i--) {
            /*
            这里进行的是截取，每次截取的子串都是str4字符串当中的一部分
            那么截取的位置应该从零开始逐渐往后推
            而截取的长度为i，截取的位置也应该从0开始逐渐往后推，应为j到j+i
             */
            for (int j = 0; j <= str4.length() - i; j++) {
                    str = str4.substring(j, i + j);
//                如果较长的字符串中包含了截取出的子串，则返回true
                boolean isThere = str3.contains(str);
                if (isThere) {
                    System.out.println(str);
                    i = 0;
                    break;
                }
            }
        }
    }
}

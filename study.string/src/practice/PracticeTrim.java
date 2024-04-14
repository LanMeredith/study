package practice;

/**
 * 模拟一个trim方法，去除字符串两端的空格
 * @author shkstart
 * @create 2021-01-12-15:16
 */
public class PracticeTrim {
    public static void main(String[] args) {
        PracticeTrim practiceTrim = new PracticeTrim();
        String str = "   yan  ming  he  ";
        String str1 = practiceTrim.praTrim(str);
        System.out.println(str1);
    }

    public String praTrim(String str){
        int len = str.length();
        int start = 0;
        while(start < len && str.charAt(start) == ' '){
            start++;
        }
        while(len > start && str.charAt(len-1) == ' '){
            len--;
        }
        return str.substring(start,len);
    }
}

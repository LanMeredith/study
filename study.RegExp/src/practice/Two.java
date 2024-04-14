package practice;

/**
 * 验证是不是整数或者小数
 * 这道题需要考虑正负数
 * @author SeedList
 * @date: 2022.11.01
 */
public class Two {
    public static void main(String[] args) {
        String content = "-31.123";
        String regStr = "^[-+]?\\d+(\\.\\d+)?$";

        if (content.matches(regStr)) {
            System.out.println("匹配成功，是整数或小数");
        } else {
            System.out.println("匹配失败，不是整数或者小数");
        }
    }
}

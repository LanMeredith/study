package practice;

/**
 * 将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反转为”abfedcg”
 *
 * @author shkstart
 * @create 2021-01-12-15:36
 */
public class PracticeReverse {
    public static void main(String[] args) {
        String str = "我爱中国，我是中国人，我为我作为一名中国人而感到自豪";
        PracticeReverse practiceReverse = new PracticeReverse();
        str = practiceReverse.reverse(str, 5, 10);
        System.out.println(str);
        str = practiceReverse.reverseUpgrade(str,5,26);
        System.out.println(str);
    }

    public String reverse(String str, int start, int end) {
        if (str != null) {
            char arr[] = str.toCharArray();
            for (int i = start, j = end - 1; i < j; i++, j--) {
                char tmpe = arr[i];
                arr[i] = arr[j];
                arr[j] = tmpe;
            }
            return new String(arr);
        }
        return null;
    }

    public String reverseUpgrade(String str, int start, int end) {
        if (str != null) {
            StringBuilder builder = new StringBuilder(str.length());
            builder.append(str.substring(0,start));
            for (int i = end - 1; i >= start; i--) {
                builder.append(str.charAt(i));
            }
            builder.append(str.substring(end));
            return builder.toString();
        }
        return null;
    }
}

package practice;

/**
 * 获取一个字符串在另一个字符串中出现的次数。
 * 比如：获取“ ab”在 “abkkcadkabkebfkabkskab” 中出现的次数
 * @author shkstart
 * @create 2021-01-12-15:53
 */
public class PracticeOccurrences {
    public static void main(String[] args) {
        String str = "qwertdeyuuhgfdsdfghjkt" +
                "sdfghjgfasdedxcgjvhkbjlbgvcrdexcvblkjhjbgv" +
                "fjrdtecfgvuygutfrdcastgyiugysadasafdsdafgds" +
                "fadFGHFDDFRGSDAAsasagdyagsdyjgaasdyjfsaygasgfdyaw" +
                "tfdrftgyi";
//        出现的次数
        int total = 0;
//        索引到的位置
        int past = 0;
        for (int i = 0; i < str.length(); i++) {
            int current = -1;
            current = str.indexOf("de",past);
            if (current != -1){
                total++;
                /*
                在这里曾碰到一个不明显的问题，即最终得出的出现次数远远大于实际得出的出现次数
                后排查发现，取得的current下标为索引得出的第一个字符下标
                例如"de"在字符串中出现的位置是五六，索引得出的current为五
                这样导致下次从current处开始索引时，已被索引出的五六位置再次被记录一遍
                处理方式：对current加一，这样开始索引的位置为六，避免了重复记录的发生
                 */
                past = current + 1;
            }
        }
        System.out.println(total);

        String sbu = "as";
        PracticeOccurrences practiceOccurrences = new PracticeOccurrences();
        System.out.println(practiceOccurrences.occurrences(str,sbu));
    }

//    方式二
    public int occurrences(String mainStr,String sbuStr){
        if (mainStr.length() > sbuStr.length()){
//            出现的次数
            int total = 0;
//            索引到的位置
            int past = 0;
//            indexOf和lastIndexOf方法如果未找到都是返回-1，所以到返回-1时表示在剩余部分没有找到sbuStr，结束循环
            while((past = mainStr.indexOf(sbuStr,past)) != -1){
                past += sbuStr.length();
                total++;
            }
            return total;
        }else
            return 0;
    }
}

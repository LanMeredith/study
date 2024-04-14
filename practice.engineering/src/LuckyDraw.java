import java.util.Random;

/**
 * 产生一个随机数，绝对平均分布
 * 抽到哪个随机数就开始做哪一章节的题目
 * @author shkstart
 * @create 2021-07-26-13:13
 */
public class LuckyDraw {
    public static void main(String[] args) {
        Random random = new Random();
        int i = random.nextInt(11);
        System.out.println(i);
    }
}
package study.recursion;

/**
 * 八皇后问题
 * 我们可以用一个一维数组来解决问题，不一定需要二维数组
 * queen数组中，下标表示第几行，储存元素表示第几列
 * 即：queen[i] = val
 * 皇后在i行，val列
 *
 * 思路分析：
 * （1）第一个皇后放在第一行第一列
 * （2）第二个皇后放在第二行第一列，判断是否冲突
 * 若是冲突，则放在第二行第二列，再进行判断，直到找到一个合适的位置，然后放下一行
 * （3）继续第三个皇后，重复（2）的步骤
 * 直到八个皇后都放在一个不冲突的位置，即算找到了一个正解
 * （4）当得到了一个正解，在栈回退到上一个栈时，就会开始回溯
 * 即将第一个皇后放在第一行第一列的解全部的得到
 * （5）回头，将第一个皇后放在第一行第二列，重复执行（1）（2）（3）（4）步骤
 *
 * 如何产生回溯？
 * 在循环中进行递归，相当于多个循环嵌套
 * @author shkstart
 * @create 2021-10-26-20:28
 */
public class EightQueen {
    static int max = 8;
    static int[] queen = new int[max];
    static int effective = 0;
    static int sum = 0;

    public static void main(String[] args) {
//        从第一行开始放
        put(0);
        System.out.println("有效摆放方式共有：" + effective);
        System.out.println("一共进行了" + sum + "次推算");
    }

    /**
     * 摆放皇后
     * @param n 行数
     */
    public static void put(int n){
//        如果当n等于8时，即为第九行，就不需要摆放了，只需要将成功的摆法输出即可
        if (n == max) {
//            计算有效摆放方式
            effective++;
            print();
            return;
        }

        /*
        如果还没有摆完最后一行，则进入循环。
        我们只需要通过循环改变i的值，就可以改变皇后在这一行摆放的位置（改变列值）
        */
        for (int i = 0; i < max; i++) {
//            计算一共进行了多少次推算
            sum++;
//            先假设在第n行的摆放位置是i
            queen[n] = i;
//            判断这一行的这个位置是否合适，若不合适则进行下一次循环，若合适则进行下次摆放
            if (judge(n)) {
//                递归调用，对n+1行进行摆放
                put(n + 1);
            }
        }
    }

    /**
     * 判断皇后摆放的位置是否满足条件
     * 第一：不能处于同一列，即当queen[i] == queen[n]时处于同一列
     * 第二：不能在同一斜线上，在这里我们采用的方法是判断他们之间的斜率是否为一
     * Math.abs(int x)方法可以获取到x的绝对值
     * 其中Math.abs(n-i)是他们之间的行距
     * Math.abs(queen[n] - queen[i])是他们之间的列距
     * 若行距==列距，则他们处于对角线上，斜率为一，
     * 第三：不需要判断是否在同一行，因为n每次都会增加
     * @param n
     * @return
     */
    private static boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (queen[i] == queen[n] || Math.abs(n - i) == Math.abs(queen[n] - queen[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 打印数组
     */
    private static void print(){
        System.out.print("这是第" + effective + "次正解    ");
        for (int i = 0; i < max; i++) {
            System.out.print(queen[i] + "    ");
        }
        System.out.println();
    }
}

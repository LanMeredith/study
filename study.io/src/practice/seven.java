package practice;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 编写一个文本分析类
 * 设计两个方法：
 * 1.统计一个含有英文单词的文本文件的单词个数
 * 2.统计指定的文件中含有指定单词的个数
 *
 * @author shkstart
 * @create 2021-07-26-21:13
 */
public class seven {
    public static void main(String[] args) {
        FileReader reader = null;
        try {
            File file = new File("D:\\JAVA_IDEA\\IO\\July26Three.txt");
            reader = new FileReader(file);
//        创建一个StringBuilder对象，长度为file的文件长度
            StringBuilder builder = new StringBuilder((int) file.length());
            char[] chars = new char[1024];
            int len;
            while ((len = reader.read(chars)) != -1) {
//                向builder中添加内容
                builder.append(chars, 0, len);
            }
//            将builder转为字符串传入getWordNum方法中，获取文本中出现的单词数
            int x = getWordNum(builder.toString());
            System.out.println("文本中一共有" + x + "个单词。");
//            查找指定单词
            int y = getWordNumFile(builder.toString(), "I'm");
            System.out.println("指定单词存在：" + y + "个");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 统计一个含有英文单词的文本文件的单词个数
     *
     * @param fileName
     * @return
     */
    public static int getWordNum(String fileName) {
//        将获取到的文本内容转换为char[]
        char[] array = fileName.toCharArray();
//        单词数
        int x = 0;
//        定位
        int i = 0;
        do {
//            将char元素转换成SACII码，这样有利于确认当前char是否为字母
            int toASCII = array[i];
//            65到90是大写字母区间，97到122是小写字母区间
            boolean isScope = (toASCII >= 65 && toASCII <= 90) || (toASCII >= 97 && toASCII <= 122);
//            第一遍判断是否为字母，若为字母即视作单词开头
            if (isScope) {
                for (int j = i; j < array.length; j++) {
                    int toASCII2 = array[j];
//                    进行第二遍判断，当前字符是否为字母或“'”，若是则直接进入下一次循环，判断下个字符
                    boolean isScope2 = (toASCII2 >= 65 && toASCII2 <= 90) || (toASCII2 >= 97 && toASCII2 <= 122) || (toASCII2 == 39);
                    if (isScope2) {
//                        考虑情况：若为单词结尾，会因结束循环而未给单词数量加一，故添加此判断，若当前字符属于字母或“'”且为最后一个字符时满足条件
                        if ((j + 1) >= array.length) {
//                            为单词数加一
                            x++;
//                            将大循环定位更改为当前字符位置
                            i = j;
                            break;
                        }
                        continue;
                    } else {
//                        若不是，则为单词末尾，单次数量加一
                        x++;
//                        将大循环定位更改为当前字符位置
                        i = j;
                        break;
                    }
                }
            }
            i++;
        } while (i < array.length);
        return x;
    }

    /**
     * 统计指定的文件中含有指定单词的个数
     * @param formfileName
     * @param word
     * @return
     */
    public static int getWordNumFile(String formfileName, String word) {
//        将获取到的文本内容转换为char[]
        char[] chars = formfileName.toCharArray();
//        将要检索的单词转换为char[]
        char[] toCharArray = word.toCharArray();
//        指定单词的个数
        int x = 0;
//        先进行判断，要索引的单词长度是否大于获取的文本内容长度，若是大于则必定检索无果
        if (chars.length >= toCharArray.length) {
//            以获取的文本内容为主，进行循环
            for (int i = 0; i < chars.length; i++) {
//                判断文本内容转换的数组chars的当前元素i是否与要查找的单词的第一个元素相符合
                boolean isStart = (chars[i] == toCharArray[0]);
//                若是符合，进入下一重循环
                if (isStart) {
//                    此循环以要查找的单词为主
                    for (int j = 0; j < toCharArray.length; j++) {
//                        判断chars的当前元素是否等于toCharArray的当前元素，chars需要i+j是为了定位chars的数组下标
                        boolean isStart2 = chars[i + j] == toCharArray[j];
                        if (isStart2) {
//                            如果对比达到了要查找单词的最后一个，则判断此单词存在，则对单词数加一
                            if ((j + 1) >= toCharArray.length) {
//                                对比结束后chars的数组下标也应随之发生改变
                                i += j;
                                x++;
                                break;
                            }
                            continue;
                        } else {
//                            对比结束后chars的数组下标也应随之发生改变
                            i += j;
                            break;
                        }
                    }
                } else {
                    continue;
                }
            }
        } else {
            x = -1;
        }
        return x;
    }
}

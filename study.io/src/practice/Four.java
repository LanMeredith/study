package practice;

import java.io.*;
import java.util.*;

/**
 * 获取文本上每个字符出现的次数
 * @author shkstart
 * @create 2021-02-16-16:08
 */
public class Four {
    public static void main(String[] args) {
        File file = new File("D:\\JAVA_IDEA\\IO\\ReaderAndWriter.txt");
        read(file);
    }

    public static void read(File file1){
        BufferedReader bufferedReader = null;
        try {
            FileReader reader = new FileReader(file1);

            bufferedReader = new BufferedReader(reader);

            char[] cbuf = new char[1024];
            int len;
            HashMap<Character, Integer> hashMap = new LinkedHashMap<>();
            while ((len = bufferedReader.read(cbuf)) != -1){
                for (int i = 0; i < len; i++) {
                    if (cbuf[i] != ' ' && cbuf[i] != '\n') {
                        if (hashMap.containsKey(cbuf[i])){
                            hashMap.put(cbuf[i],hashMap.get(cbuf[i])+1);
                        }else {
                            hashMap.put(cbuf[i],1);
                        }
                    }
                }
            }
            System.out.println(hashMap);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

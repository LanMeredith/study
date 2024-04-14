package study.references;

import java.util.Arrays;
import java.util.function.Function;

/**
 * 数组引用
 * 可以把数组看做是一个特殊的类，则写法与构造器引用一致
 * @author shkstart
 * @create 2021-08-08-19:44
 */
public class StudyArraysRef {
    public static void main(String[] args) {
//        数组引用的原始写法
        Function<Integer, String[]> function = new Function<Integer, String[]>() {
            @Override
            public String[] apply(Integer integer) {
                return new String[integer];
            }
        };
        String[] arr = function.apply(7);
        System.out.println(Arrays.toString(arr));

        System.out.println();

//        lambda表达式写法
        Function<Integer,String[]> function1 = length -> new String[length];
        String[] arr1 = function1.apply(5);
        System.out.println(Arrays.toString(arr1));

        System.out.println();

        //        方法引用
        Function<Integer,String[]> function2 = String[]::new;
        String[] arr2 = function2.apply(9);
        System.out.println(Arrays.toString(arr2));
    }
}

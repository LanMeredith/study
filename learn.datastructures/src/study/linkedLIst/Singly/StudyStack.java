package study.linkedLIst.Singly;

import java.util.Stack;

/**
 * 演示Stack的基本使用
 * 因为还没有学到栈，但是在练习中涉及到了Stack栈，所以在这里简单的涉及一下
 *
 * 这就相当于是一个塔，先存入的数据在塔底，后存入的数据在塔顶
 * 当我们要取出数据时，将会先取出塔顶的数据
 * 即为栈的先进后出
 * @author shkstart
 * @create 2021-09-11-16:39
 */
public class StudyStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
//        入栈
        stack.add("Jack");
        stack.add("Tom");
        stack.add("Smith");

//        出栈
        while (stack.size() > 0) {
//            pop()就是将栈顶的数据取出
            System.out.println(stack.pop());
        }
    }
}

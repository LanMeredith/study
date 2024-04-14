package study.stack.InversePolish;

import java.util.*;

/**
 * 学习逆波兰表达式
 * 又称为后缀表达式，与前缀表达式相似，只是运算符位于操作符之后
 * example：(3+4)*5-6对应的逆波兰表达式为：34+5*6-
 * <p>
 * 后缀表达式的计算机求值
 * 从左至右扫描表达式，遇到数字时，将数字压入堆栈，遇到运算符时
 * 弹出栈顶的两个数，用运算符对它们做相应的计算（次顶元素和栈顶元素）
 * 并将结果入栈，重复上述过程直到表达式最右端
 * 最后运算得出的值即为表达式的结果
 * <p>
 * 此处以学习逆波兰表达式为主，所以就不采用数组或list模拟栈了
 * 而是直接调用Stack栈
 *
 * @author shkstart
 * @create 2021-10-01-9:59
 */
public class Expression {
    /**
     * 输入表达式，并将其转换为ArrayList输出
     *
     * @return
     */
    public List<String> IPExpression() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入表达式");
        String str = scanner.nextLine();
//        调用split方法可以对数据进行分隔，分隔依据是空格符
        String[] strings = str.split(" ");
        ArrayList<String> list = new ArrayList<>();
        for (String ele :
                strings) {
            list.add(ele);
        }
        return list;
    }

    /**
     * 运算
     *
     * @param num1
     * @param operator
     * @param num2
     * @return
     */
    public int operation(int num1, String operator, int num2) {
        if (operator.equals("+")) {
            num1 += num2;
        } else if (operator.equals("-")) {
            num1 -= num2;
        } else if (operator.equals("*")) {
            num1 *= num2;
        } else if (operator.equals("/")) {
            num1 /= num2;
        } else {
            throw new RuntimeException("运算符有误");
        }
        return num1;
    }

    public Expression() {
//        得到输入的逆波兰表达式
        List<String> list = IPExpression();
        Iterator<String> iterator = list.iterator();

//        创建一个栈，因为是逆波兰表达式，从左至右扫描，所以只需要一个栈就可以了
        Stack<String> stack = new Stack<>();

//        采用迭代器的方式完成对list的遍历
        while (iterator.hasNext()) {
            String next = iterator.next();
//            使用正则表达式来匹配它是否为多位数
            if (next.matches("\\d+")) {
//                入栈
                stack.push(next);
            } else {
//                由于栈的先入后出特性，所以先出栈的是后面的数
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
//                计算结果后再存入栈
                stack.push(String.valueOf(operation(num1, next, num2)));
            }
        }
        System.out.println("运算的最终结果是：" + stack.pop());
    }
}
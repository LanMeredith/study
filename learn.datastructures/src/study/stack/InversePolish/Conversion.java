package study.stack.InversePolish;

import java.util.*;

/**
 * 将中缀表达式转换成后缀表达式进行计算
 * <p>
 * 表达式转换思路分析：
 * （1）初始化两个栈，运算符栈s1和存储中间结果的栈s2
 * （2）从左至右扫描中缀表达式
 * （3）遇到操作数时，将其压入s2
 * （4）遇到运算符时，比较其与s1栈顶运算符的优先级
 * -->（4-1）如果s1为空，或栈顶运算符为左括号“(”则直接将此运算符入栈
 * -->（4-2）否则，若优先级比栈顶运算符的高，也将运算符压入s1
 * -->（4-3）否则，将s1栈顶的运算符弹出并压入s2中，再次转到（4-1）与s1中新的栈顶运算符相比较
 * （5）遇到括号时：
 * -->（5-1）如果是左括号“(”，则直接压入s1
 * -->（5-2）如果是右括号“)”，则依次弹出s1栈顶的运算符
 * 并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
 * （6）重复步骤2至5，直到表达式最右边
 * （7）将s1中剩余的运算符依次弹出并压入s2
 * （8）依次弹出s2中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式
 *
 * @author shkstart
 * @create 2021-10-01-10:59
 */
public class Conversion {
    /**
     * 重写父类的方法，将接收到的中缀表达式转为后缀表达式
     *
     * @return
     */
    public List<String> IPExpression() {
//       获取到中缀表达式， 用String str接收
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入表达式");
        String str = scanner.nextLine();

//        初始化两个栈，分别是符号栈和中间结果栈
        Stack<String> operatorStack = new Stack<>();
//        因为中间结果栈从头到尾都不需要用的pop()方法，所以采用ArrayList接收最为合适，最后的一步反转也很方便
        ArrayList<String> resultsStack = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
//            遇到操作数时，将其压入栈中
            if (isNumeric(c)) {
//                如果是一个数的话，要考虑多位数情况
                int numTemp = returnNumTemp(str, i);
                resultsStack.add(str.substring(i, numTemp + 1));
                i = numTemp;
            } else if (isArithmetic(c)) {
//                遇到运算符时，比较其与操作符栈顶运算符的优先级
                OperatorStack(operatorStack, resultsStack, c);
            } else if (c == '(' || c == ')') {
//                如果是左括号“(”，则直接压入s1
                if (c == '(') {
                    operatorStack.push(String.valueOf(c));
                } else {
//                    如果是右括号“)”，则依次弹出operatorStack栈顶的运算符,并压入resultsStack,直到遇到左括号为止
                    while (!"(".equals(operatorStack.peek())) {
                        resultsStack.add(operatorStack.pop());
                    }
//                    此时将这一对括号丢弃
                    operatorStack.pop();
                }
            }
        }

//        将operatorStack中剩余的运算符依次弹出并压入resultsStack
        while (!operatorStack.empty()) {
            resultsStack.add(operatorStack.pop());
        }

//        由于采用的是ArrayList作为中间结果栈，所以没有先入后出的特性，不需要将输出反转
        return resultsStack;
    }

    /**
     * 多位数情况下，返回的temp指向此多位数最后一位
     *
     * @param str
     * @param i
     * @return
     */
    public int returnNumTemp(String str, int i) {
        int temp = i;
        while (true) {
//            判断是否为数组的最后一个元素，并且判断该字符是否为数字或者小数点
            if ((temp + 1) < str.length() && (isNumeric(str.charAt(temp + 1)) || str.charAt(temp + 1) == '.')) {
                temp++;
            } else {
                return temp;
            }
        }
    }

    /**
     * 判断此字符是否为数字
     *
     * @param c
     * @return
     */
    public boolean isNumeric(char c) {
        if (c < 48 || c > 57) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 判断是否为加减乘除中的一项
     *
     * @param c
     * @return
     */
    public boolean isArithmetic(char c) {
        switch (c) {
            case '+':
            case '-':
            case '*':
            case '/':
                return true;
            default:
                return false;
        }
    }

    /**
     * 运算符入栈操作
     *
     * @param operatorStack
     * @param resultsStack
     * @param operator
     * @return
     */
    public void OperatorStack(Stack<String> operatorStack, ArrayList<String> resultsStack, char operator) {
//        若是操作符栈为空的话，直接将当前操作符入栈
        if (operatorStack.empty()) {
            operatorStack.push(String.valueOf(operator));
        } else {
//            得到栈顶运算符
            String peek = operatorStack.peek();
//            获取栈顶运算符的优先级与当前运算符的优先级
            int peekPriority = priority(peek.charAt(0));
            int operatorPriority = priority(operator);
//            如果栈顶运算符是"("的话，直接将当前操作符入栈
            if ("(".equals(peek)) {
                operatorStack.push(String.valueOf(operator));
            } else if (operatorPriority > peekPriority) {
//                若优先级比栈顶运算符的高，也将运算符压入s1
                operatorStack.push(String.valueOf(operator));
            } else {
//                否则，将符号栈顶的运算符弹出并压入中间结果栈中，再次转到（4-1）与符号栈中新的栈顶运算符相比较
                String pop = operatorStack.pop();
                resultsStack.add(pop);
                OperatorStack(operatorStack, resultsStack, operator);
            }
        }
    }

    /**
     * 判断当前操作符的优先级大小用0和1表示
     *
     * @return
     */
    public int priority(char operator) {
        if (operator == '+' || operator == '-') {
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * 运算
     *
     * @param num1
     * @param operator
     * @param num2
     * @return
     */
    public double operation(double num1, String operator, double num2) {
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

    public Conversion() {
//        得到输入的逆波兰表达式
        List<String> list = IPExpression();
//        迭代器
        Iterator<String> iterator = list.iterator();

//        创建一个栈，因为是逆波兰表达式，从左至右扫描，所以只需要一个栈就可以了
        Stack<String> stack = new Stack<>();

//        采用迭代器的方式完成对list的遍历
        while (iterator.hasNext()) {
            String next = iterator.next();
//            使用正则表达式来匹配它是否为多位数
            if (next.charAt(0) >= 48 && next.charAt(0) <= 57) {
//                入栈
                stack.push(next);
            } else {
//                由于栈的先入后出特性，所以先出栈的是后面的数
                double num2 = Double.parseDouble(stack.pop());
                double num1 = Double.parseDouble(stack.pop());
//                计算结果后再存入栈
                stack.push(String.valueOf(operation(num1, next, num2)));
            }
        }
        System.out.println("运算的最终结果是：" + stack.pop());
    }
}
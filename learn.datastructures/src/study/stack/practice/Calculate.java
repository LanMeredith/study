package study.stack.practice;

import java.util.Scanner;

/**
 * 使用栈完成计算一个表达式的结果
 * 不考虑括号，不考虑计算式中其他负数，只考虑第一个数为负数的情况
 * @author shkstart
 * @create 2021-09-28-16:49
 */
public class Calculate {
    /**
     * 两个栈，分别是数栈和符号栈
     * 分别用来存储数字与符号
     */
    public int[] numArr;
    public char[] operatorArr;
    public int numTop = -1;
    public int operatorTop = -1;

    public Calculate() {
        int results = results();
        System.out.println("运算的结果是：" + results);
    }

    /**
     * 输入表达式，并将其转换成字符数组返回
     *
     * @return
     */
    public char[] expression() {
        String str;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入表达式");
        str = scanner.next();
        return str.toCharArray();
    }

    /**
     * 判断当前操作符的优先级大小用0和1表示
     * 若返回的是-1说明获取到的运算符不符合规范，从此处进行截断
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
    public int operation(int num1, char operator, int num2) {
        if (operator == '+') {
            num1 += num2;
        } else if (operator == '-') {
            num1 -= num2;
        } else if (operator == '*') {
            num1 *= num2;
        } else if (operator == '/') {
            num1 /= num2;
        }
        return num1;
    }

    /**
     * 在获取当前操作符后判断是否要进行计算
     *
     * @param character
     */
    public void isOperation(char character) {
//        如果符号栈中无元素，则直接将当前操作符传入
        if (operatorTop == -1) {
            operatorArr[++operatorTop] = character;
        } else {
//            如果符号栈中有元素，则获取当前操作符的优先级和上一操作符的优先级
            int symbol1 = priority(operatorArr[operatorTop]);
            int symbol2 = priority(character);
//            对两个操作符的优先级进行比较，若当前操作符优先级更大，则直接进行插入
            if (symbol1 < symbol2) {
                operatorArr[++operatorTop] = character;
            } else {
                /*
                 * 如果当前的操作符的优先级小于或等于栈中的操作符
                 * 就需要从数栈中pop两个数，在符号栈中pop出一个符号
                 * 进行运算，将得到的结果存入数栈，最后将当前操作符存入符号栈
                 * 这里采用递归，符号栈中存储的元素尽可能被清空
                 * */
                int results = operation(numArr[numTop - 1], operatorArr[operatorTop], numArr[numTop]);
                numArr[--numTop] = results;
                --operatorTop;
                isOperation(character);
            }
        }
    }

    /**
     * 最终运算
     * @return
     */
    public int endOperation() {
        for (int i = operatorTop; i > -1; i--) {
//            由于传入的参数是num1在前num2在后，所以需要先取出在先的数，再取出在后的数并让numTop减一
            int num = operation(numArr[numTop - 1], operatorArr[operatorTop--], numArr[numTop--]);
            numArr[numTop] = num;
        }
        return numArr[numTop];
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

    public int results() {
        char[] expression = expression();
        numArr = new int[5];
        operatorArr = new char[5];

        operatorArr[0] = '+';
        numTop = 0;
        operatorTop = 0;

        for (int i = 0; i < expression.length; i++) {
            char character = expression[i];
//            判断当前的字符是否为数字
            if (isNumeric(character)) {
                /*
                设置一个辅助变量，指向这个数字在字符数字的末尾
                以123+321为例，当expression[i]指向1的时候expression[temp]应当指向3
                如此一来，expression数组从i起至temp就是123
                */
                int temp = i;
                if (temp + 1 < expression.length) {
                    while (isNumeric(expression[temp + 1])) {
                        temp++;
                    }
                }
                int end = temp + 1 - i;
//                将字符数组的这一部分截取出来，转成字符串
                String str = String.valueOf(expression, i, end);
//                再由字符串强转为int类型的整型
                int num = Integer.parseInt(str);
//                存入数栈中
                numArr[++numTop] = num;
//                因为从i到temp为止都是数字，所以下一次判断需要从temp起
                i = temp;
            } else {
//                如果第一个数是负数，则将前置的加号替换成减号即可
                if (operatorTop == 0 && operatorArr[operatorTop] == '+') {
                    operatorArr[operatorTop] = character;
                } else {
//                如果不是数字，则调用isOperation()方法进行判断是否要计算
                    isOperation(character);
                }
            }
        }
//        所有的表达式全部整合，输出结果
        return endOperation();
    }
}

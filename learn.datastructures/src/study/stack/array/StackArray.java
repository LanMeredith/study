package study.stack.array;

/**
 * 栈是一个有序列表，我们可以使用数组来模拟栈，也可以使用单向链表来模拟栈
 * 在这里我们采用数组的方式模拟栈
 * 栈：一个先进后出的有序列表
 * 为了方便，我们简化操作，将存入的数据设定为int类型的数
 * @author shkstart
 * @create 2021-09-27-8:57
 */
public class StackArray {
    public int[] arr;
    public int maxarr;
    public int top = -1;

    public StackArray(int maxarr) {
        this.maxarr = maxarr;
        arr = new int[maxarr];
    }

    /**
     * 判断Stack是否满
     * @return
     */
    public boolean isFull(){
        if (top == maxarr - 1) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 添加操作（入栈）
     * @param value
     */
    public void addStack(int value){
        if (isFull()) {
            top++;
            arr[top] = value;
        } else {
            System.out.println("arr已存满");
        }
    }

    /**
     * 删除操作（出栈）
     * @return
     * @throws NullPointerException
     */
    public int deletStack() throws  NullPointerException{
        if (top == -1) {
            throw new NullPointerException("arr为空");
        } else {
            int temp = arr[top];
            top--;
            return temp;
        }
    }

    /**
     * 遍历
     */
    public void traverseStack(){
        for (int i = top; i > -1; i--) {
            System.out.println(arr[i]);
        }
    }
}

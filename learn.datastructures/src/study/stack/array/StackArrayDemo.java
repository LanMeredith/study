package study.stack.array;

/**
 * @author shkstart
 * @create 2021-09-27-9:20
 */
public class StackArrayDemo {
    public static void main(String[] args) {
        StackArray array = new StackArray(5);
        array.addStack(5);
        array.addStack(1);
        array.addStack(1231);
        array.addStack(12341242);
        array.addStack(12342);
        array.addStack(1242);

        System.out.println(array.deletStack());
        System.out.println();

        array.traverseStack();
    }
}

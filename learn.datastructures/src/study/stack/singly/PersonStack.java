package study.stack.singly;

/**
 * @author shkstart
 * @create 2021-09-27-12:59
 */
public class PersonStack {
    public static void main(String[] args) {
        StackSingly singly = new StackSingly();
        singly.addStack(new Person(1,15,"Tom"));
        singly.addStack(new Person(4,16,"Jack"));
        singly.addStack(new Person(2,18,"Smith"));
        singly.addStack(new Person(8,1,"Victoria"));

        singly.traverseStack();
        System.out.println();

        System.out.println(singly.deletStack());
    }
}

package study.stack.singly;

/**
 * 用单向链表实现Stack栈
 * 栈具有先入后出的特点
 * 所以应该由新添加的节点指向单链表，而非单链表指向新添加的节点
 * @author shkstart
 * @create 2021-09-27-12:30
 */
public class StackSingly {
    public Person top = null;

    /**
     * 添加操作
     * 让新添的节点指向上一个被添加的节点，这样当取出时，会先取出最近被添加的节点
     * @param person
     */
    public void addStack(Person person){
        if (top == null) {
            top = person;
        } else {
            Person temp = top;
            top = person;
            top.setNext(temp);
        }
    }

    /**
     * 删除、取出操作
     * @return
     */
    public Person deletStack(){
        if (top == null) {
            throw new NullPointerException("Stack为空");
        } else {
            Person temp = top;
            top = top.getNext();
            return temp;
        }
    }

    /**
     * 遍历操作
     */
    public void traverseStack(){
        if (top == null) {
            System.out.println("Stack为空");
        } else {
            Person temp = top;
            while (true) {
                System.out.println(temp.toString());
                if (temp.getNext() == null) {
                    return;
                }
                temp = temp.getNext();
            }
        }
    }
}

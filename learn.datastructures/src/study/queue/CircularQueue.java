package study.queue;

/**
 * 将基础的数组队列进行一次升级
 * 环形队列
 * @author shkstart
 * @create 2021-09-06-12:34
 */
public class CircularQueue {
    /**
     * front为队头
     * rear为队尾
     * maxsize为队列长度
     * AQueue为数组，存储队列的数据
     */
    private int front;
    private int rear;
    private int maxsize;
    private int[] CQueue;

    /**
     * 虽然我们声明了数组的长度为maxsize
     * 但是出于对环形队列的设计考虑，我们会留出一个位置作为预留空间
     * 这个预留空间是动态的，当rear指向预留空间时，下一个位置就是front。此时不可存入
     * 这是为了避免raer == front判断数组为空
     * @param maxsize
     */
    public CircularQueue(int maxsize) {
        this.maxsize = maxsize;
        CQueue = new int[maxsize];
        /*
        设计思路：
        front由指向队列头部的前一个位置更改为指向队列头部位置
        rear由指向队列尾部位置，更改为尾部元素的后一个位置
        设计front和rear的初始值都为0，又因为这两个数声明后默认值为0，所以可以不用专门声明出来
        front = 0;
        rear = 0;
        */
    }

    /**
     * 判断队列是否满
     * 因为有预留空间，所以当数据储存到CQueue[maxsize - 2]后
     * rear = maxsize - 1，指向预留空间，不进行储存
     * 又因为这是一个环形队列，随着dequeue（出队）操作，front在数组中的指引位置向后移动
     * 故rear可以从CQueue[0]开始重新存入数据
     * 综上情况所述，要判断数组是否存满，得看rear加上预留空间的1后与front是否相等
     * @return
     */
    public boolean isFull() {
        return (rear + 1) % maxsize == front;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 添加数据到队列中
     */
    public void addQueue(int n) {
//        判断队列是否已满
        if (isFull()) {
            System.out.println("队列已满，不能加入数据");
//            return不仅可以返回方法指定类型的值，还可以结束方法的运行
            return;
        }

//        让rear后移
        CQueue[rear] = n;
        rear = (++rear) % maxsize;
    }

    /**
     * 获取队列的数据，出队列
     * @return
     */
    public int getQueue() {
//        判断队列是否已空
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能取数据");
        }

        int tmpe = front;
        front = (++front) % maxsize;
        return CQueue[tmpe];
    }

    /**
     * 显示队列的所有数据
     */
    public void showAQueue() {
        if (isEmpty()) {
            System.out.println("队列为空不能遍历");
            return;
        }

        int cqLength = (rear + maxsize - front) % maxsize;
        int tmpeFront = front;
        int tmpeRear = rear;
        for (int i = 0; i < cqLength; i++) {
            System.out.print(CQueue[tmpeFront]);
            tmpeFront = (++tmpeFront) % maxsize;
            tmpeRear = (++tmpeRear) % maxsize;

        }
    }

    /**
     * 显示队列的头数据，注意！！！不是取出数据
     * @return
     */
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据");
        }

//        因为front指向的是队列头的前一个位置，所以通过加一来指向队列头部
        return CQueue[front];
    }
}

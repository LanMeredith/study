package study.queue;

import java.util.Arrays;

/**
 * 最基本的用数组模拟队列
 * 目前数组使用一次后就不能用了
 * 没有达到复用的效果，后续改进目标：使用算法，将此数组改成环形的数组
 * @author shkstart
 * @create 2021-09-04-10:45
 */
public class ArrayQueue {
    /**
     * front为队头
     * rear为队尾
     * maxsize为队列长度
     * AQueue为数组，存储队列的数据
     */
    private int front;
    private int rear;
    private int maxsize;
    private int[] AQueue;

    public ArrayQueue(int maxsize) {
        this.maxsize = maxsize;
        AQueue = new int[maxsize];
//        指向队列头部，分析出front指向队列头的前一个位置
        front = -1;
//        指向队列尾部（就是队列最后一个数据的位置）
        rear = -1;
    }

    /**
     * 判断队列是否满
     * @return
     */
    public boolean isFull() {
        return rear == maxsize - 1;
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
        rear++;
        AQueue[rear] = n;
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

        front++;
        return AQueue[front];
    }

    /**
     * 显示队列的所有数据
     */
    public void showAQueue() {
        if (isEmpty()) {
            System.out.println("队列为空不能遍历");
            return;
        }

        System.out.println(Arrays.toString(AQueue));
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
        return AQueue[front+1];
    }
}

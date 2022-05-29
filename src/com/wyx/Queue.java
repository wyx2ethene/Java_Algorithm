package com.wyx;

/**
 * 队列是一个有序列表，可以使用数组或者链表来实现
 * 队列的遵循先进先出原则
 * 本次采用数组实现队列，因队列的输入输出分别从前后端进行，故
 * 采用front和rear记录队列前后端下标，front随着数据出队列而改变，rear随着数据进入队列而改变
 */
public class Queue {
    // 队列（数组）最大容量
    private int maxSize;
    // front指向队列头部端
    private int front;
    // rear指向队列尾部端
    private int rear;
    // 定义一个数组用于模拟队列操作数据
    private int[] arr;

    /**
     * 创建队列的构造器
     *
     * @param arrMaxSize 队列长度
     */
    private Queue(int arrMaxSize) {
        maxSize = arrMaxSize;
        // 一开始让front和rear均指向-1
        front = -1;
        rear = -1;
        arr = new int[maxSize];
    }

    /**
     * 判断队列是否已满
     *
     * @return 若队列已满则返回true否则返回false
     */
    private boolean isFull() {
        return rear == maxSize - 1;
    }

    /**
     * 判断队列是否为空
     *
     * @return 若队列为空则返回true否则返回false
     */
    private boolean isEmpty() {
        return rear == front;
    }

    /**
     * 向队列中添加单个元素
     *
     * @param num 单个元素值
     */
    private void addQueue(int num) {
        if (isFull()) {
            throw new RuntimeException("队列满，无法添加数据！");
        }
        arr[++rear] = num;
    }

    /**
     * 获取队列中的元素，模拟出队列
     *
     * @return 让先进入队列的元素先出队列
     */
    private int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取数据！");
        }
        return arr[++front];
    }

    /**
     * 展示队列中所有的数据
     */
    private void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，无可用于展示的数据！");
        }
        for (int data : arr) {
            System.out.printf("%d\t", data);
        }
        System.out.println();
    }

    /**
     * 展示队列头数据，并非取出它
     *
     * @return 返回队列头数据
     */
    private int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无可用于展示的数据！");
        }
        return arr[front + 1];
    }

    /**
     * 展示队尾元素，并非取出它
     *
     * @return 返回队尾元素
     */
    private int tailQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无可用于展示的数据！");
        }
        return arr[rear];
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);
        for (int i = 1; i < 6; i++) {
            queue.addQueue(i);
        }
        // 展示所有元素
        queue.showQueue();
        // 展示头尾元素，不取出
        System.out.println(queue.headQueue());
        System.out.println(queue.tailQueue());
        // 展示队列头元素，并模拟出队列操作(元素并未真的从数组中删除)
        System.out.println(queue.getQueue());
        System.out.println(queue.getQueue());
        // 再次展示所有元素
        queue.showQueue();
    }
}

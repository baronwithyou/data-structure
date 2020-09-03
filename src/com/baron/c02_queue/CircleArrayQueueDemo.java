package com.baron.c02_queue;

public class CircleArrayQueueDemo {
    public static void main(String[] args) throws Exception {

        ArrayQueue queue = new ArrayQueue(3);


        queue.add(100);
        queue.add(200);

        System.out.println(queue.get());
    }
}

class ArrayQueue{
    // 头指针
    int front = 0;
    // 尾指针
    int rear = 0;
    // 存放数据的数组
    int[] queue;
    // 数组的长度,用于后序判断栈是否满
    int max;

    public ArrayQueue(int max) {
        this.max = max;
        queue = new int[max];
    }

    // 判断是否队空
    public boolean isEmpty() {
        // 当头指针和尾指针指向同一个值的时候，代表该队列为空
        return front == rear;
    }

    // 判断是否队满
    public boolean isFull() {
        return (rear+1) % max == front;
    }

    // 向队列中添加元素
    public void add(int n) throws Exception  {
        if (isFull()) {
            throw new Exception("queue is full");
        }

        queue[rear] = n;
        // 将rear指针后移一位（当你理解如何判断栈满时，后移一位也很容易理解了）
        rear = (rear + 1) % max;
    }

    // 向队列中获取头元素
    public int get() throws Exception {
        if ( isEmpty() ) {
            throw new Exception("queue is empty");
        }

        int res = queue[front];
        // 将front指针后移一位
        front = (front + 1) % max;
        return res;
    }
}

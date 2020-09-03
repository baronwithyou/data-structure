package com.baron.c02_queue;


public class CircleArrayQueue {
    int maxSize;
    int[] arr;
    int front;
    int rear;

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public void add(int num) throws Exception {
        if ( isFull() ) {
            throw new Exception("队列已满");
        }

        arr[rear] = num;
        rear = (rear + 1) % maxSize;
    }

    public int get() throws Exception {
        if ( isEmpty() ) {
            throw new Exception("队列已空");
        }

        int res = arr[front];
        front = (front + 1) % maxSize;
        return res;
    }

    public static void main(String[] args) {
        CircleArrayQueue queue = new CircleArrayQueue(3);

        try {
            queue.add(10);
            queue.add(20);

            System.out.printf("%d\n", queue.get());
            System.out.printf("%d\n", queue.get());
            System.out.printf("%d\n", queue.get());
        }catch (Exception e){
            System.out.println(e);
        }
    }
}

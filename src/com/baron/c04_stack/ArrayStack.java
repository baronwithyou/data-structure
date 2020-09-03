package com.baron.c04_stack;

public class ArrayStack {
    int top = -1;
    int max;
    int[] arr;

    public ArrayStack(int max) {
        this.max = max;
        arr = new int[max];
    }

    public boolean isFull() {
        return top == max - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int n) throws Exception {
        if (isFull()) {
            throw new Exception("Stack is full.");
        }

        arr[++top] = n;
    }

    public int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty");
        }

        return arr[top--];
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }

        return arr[top];
    }

    public void list() {
        for ( int i = top; i > -1; i--) {
            System.out.println(arr[i]);
        }
    }
}

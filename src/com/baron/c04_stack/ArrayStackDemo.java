package com.baron.c04_stack;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack1 = new ArrayStack(10);

        Scanner scanner = new Scanner(System.in);
        String key;

        while (true) {
            System.out.println("make a choice:");
            System.out.println("1.push");
            System.out.println("2.pop");

            key = scanner.next();
            try {
                switch (key) {
                    case "push":
                        System.out.println("enter a number:");
                        int n = scanner.nextInt();
                        stack1.push(n);
                        break;
                    case "pop":
                        System.out.println(stack1.pop());
                        break;
                    case "peek":
                        System.out.println(stack1.peek());
                        break;
                    case "exit":
                        System.exit(1);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

package com.baron.c04_stack;

public class Calculator {
    public static void main(String[] args) throws Exception {
        ArrayStack numStack = new ArrayStack(10);
        ArrayStack operStack = new ArrayStack(10);

        String expression = "5+4*20-2";
        char c;

        for (int i = 0; i < expression.length(); i++) {
            c = expression.charAt(i);

            if (!isOper(c)) {
                numStack.push(c - 48);
                continue;
            }

            if (operStack.isEmpty()) {
                operStack.push(c);
                continue;
            }

            // 比较优先级
            char top = (char) operStack.peek();
            // 将优先级高的放进栈中
            if ( priorTo(c, top) ) {
                operStack.push(c);
                continue;
            }

            int num1 = numStack.pop();
            int num2 = numStack.pop();
            char oper = (char)operStack.pop();

            numStack.push(calculate(num1, num2, oper));
            operStack.push(c);
        }

        while (!operStack.isEmpty()) {
            int num1 = numStack.pop();
            int num2 = numStack.pop();
            char oper = (char)operStack.pop();

            numStack.push(calculate(num1, num2, oper));
        }

        System.out.printf("The result of %s is %d", expression, numStack.pop());
    }

    private static boolean isOper(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private static boolean priorTo(char a, char b) {
        return priority(a) > priority(b);
    }

    private static int priority(char c) {
        if (c == '+' || c == '-') {
            return 0;
        }

        return 1;
    }

    private static int calculate(int a, int b, char o) {
        int result = 0;
        switch (o) {
            case '+':
                result = b + a;
                break;
            case '-':
                result = b - a;
                break;
            case '*':
                result = b * a;
                break;
            case '/':
                result = b / a;
                break;
        }

        return result;
    }
}

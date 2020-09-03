package com.baron.practice;

import java.util.Stack;

public class Split {
    public static void main(String[] args) {
        System.out.println(isValid("}}}"));
    }

    public static boolean isValid(String s) {
        Stack<String> stack = new Stack<>();

        String[] arr = s.split("");
        boolean result;

        for (String value : arr) {
            if (value.equals("")) {
                continue;
            }
            if (value.equals("{") || value.equals("(") || value.equals("[")) {
                stack.push(value);
                continue;
            }

            switch (value) {
                case "}":
                    result = !stack.empty() && stack.pop().equals("{");
                    break;
                case ")":
                    result = !stack.empty() && stack.pop().equals("(");
                    break;
                case "]":
                    result = !stack.empty() && stack.pop().equals("[");
                    break;
                default:
                    result = false;
            }

            if (!result) {
                return false;
            }
        }

        return stack.empty();
    }
}

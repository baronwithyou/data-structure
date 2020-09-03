package com.baron.leetcode;

public class LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
    }

    public static int lengthOfLastWord(String s) {
        int length = s.length();
        int front = -1, rear = -1;

        for ( int i = length - 1; i >= 0; i-- ) {
            // 遇到空字符后，判断front是否有值
            if ( s.charAt(i) == ' ' && front != - 1 ) {
                break;
            }

            if ( s.charAt(i) != ' ' )  {
                if ( rear == -1 ) {
                    rear = i;
                }

                front = i;
            }

            System.out.println(rear);
            System.out.println(front);
        }
        System.out.println();

        return (rear - front + 1);
    }
}

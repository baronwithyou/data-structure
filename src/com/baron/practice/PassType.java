package com.baron.practice;

public class PassType {
    int value = 0;
    public static void main(String[] args) {
        PassType t = new PassType();

        PassType t2 = t;

        t2.value = 2000;

        System.out.println(t.value);
    }
}

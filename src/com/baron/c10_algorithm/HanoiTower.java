package com.baron.c10_algorithm;

public class HanoiTower {

    public static void main(String[] args) {
        play(3, 'A', 'B', 'C');
    }

    public static void play(int num, char a, char b, char c) {
        // 如果只需要移动一个盘，则直接从a->c
        if ( num == 1 ) {
            System.out.printf("%s -> %s\n", a, c);
            return;
        }

        // 将最上的几层挪到b上
        play(num - 1, a, c, b);

        // 最下一层挪到c上
        System.out.printf("%s -> %s\n", a, c);

        // 将b挪到c上
        play(num - 1, b, a, c);
    }
}

package com.baron.c05_recursion;

public class EightQueensPuzzleDemo {

    public static void main(String[] args) {
        EightQueenPuzzle puzzle = new EightQueenPuzzle(7);

        puzzle.play(0);

        System.out.printf("一共有%d种解法\n", puzzle.count);
    }
}

class EightQueenPuzzle {
    private int[] arr;
    private int max;
    int count;

    public EightQueenPuzzle(int max) {
        this.max = max;
        arr = new int[max];
    }

    public void play(int n) {
        // 所有的皇后已经摆放完毕
        if (n == max) {
            print();
            return;
        }

        for ( int i = 0; i < max; i++ ) {
            arr[n] = i;

            if (judge(n)) {
                play(n+1);
            }
        }
    }

    // 判断该皇后是否与其他皇后有冲突(不能在同一行、同一列、同一斜线)
    private boolean judge(int n) {
        for ( int i = 0; i < n; i++ ) {
            // 当行差等于列差-表示两个皇后在同一斜线上
            if ( arr[n] == arr[i] || Math.abs(n - i) == Math.abs(arr[n] - arr[i]) ) {
                return false;
            }
        }

        return true;
    }

    private void print() {
        count++;
        for ( int value : arr ) {
            System.out.printf("%d\t", value);
        }
        System.out.println();
    }
}
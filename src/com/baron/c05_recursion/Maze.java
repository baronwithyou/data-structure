package com.baron.c05_recursion;

public class Maze {
    public static void main(String[] args) {
        int row = 7; int col = 6;
        int[][] map = new int[row][col];

        for (int i = 0; i < col; i++ ) {
            map[0][i] = 1;
            map[row - 1][i] = 1;
        }

        for (int j = 0; j < row; j++) {
            map[j][0] = 1;
            map[j][col - 1] = 1;
        }

        map[3][1] = 1;
        map[3][2] = 1;

        for ( int[] rowValue : map ) {
            for ( int value : rowValue ) {
                System.out.printf("%d\t", value);
            }
            System.out.println();
        }

        setWay(map, 1, 1);
        System.out.println();

        for ( int[] rowValue : map ) {
            for ( int value : rowValue ) {
                System.out.printf("%d\t", value);
            }
            System.out.println();
        }
    }

    public static boolean setWay(int[][] map, int i, int j) {
        if (map[5][4] == 2) {
            return true;
        }
        if ( map[i][j] != 0 ) {
            return false;
        }

        map[i][j] = 2;
        if (setWay(map, i+1, j)) {
            return true;
        } else if (setWay(map, i, j+1)) {
            return true;
        } else if (setWay(map, i - 1, j)) {
            return true;
        } else if (setWay(map, i, j-1)) {
            return true;
        } else {
            map[i][j] = 3;
            return false;
        }
    }
}

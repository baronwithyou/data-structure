package com.baron.practice;

import java.util.Arrays;

public class Maze {


    public static void main(String[] args) {
        int m = 3, n = 3, bossSize = 2;
        int[][] bossLocation = {
                { 1, 1 },
                { 2, 2 },
        };

        // 这里我们假定1为障碍物，2为终点
        int[][] maze = new int[m+1][n+1];
        for ( int[] location : bossLocation ) {
            maze[location[0]][location[1]] = 1;
        }
        maze[m][n] = 2;

        System.out.println(Arrays.deepToString(maze));

        step(maze, m, n, 0, 0);

        System.out.println(ans);
    }

    private static int ans = 0;

    private static void step(int[][] maze, int m, int n, int i, int j) {
        System.out.printf("%d, %d\n", i, j);
        if ( i > m || j > n ) {
            return;
        }

        if ( maze[i][j] == 1) {
            return;
        }

        if ( maze[i][j] == 2 ) {
            ans++;
            return;
        }

        // 每次只能往右走或者往上走
        step(maze, m, n, i + 1, j);
        step(maze, m, n, i, j+1);
    }
}

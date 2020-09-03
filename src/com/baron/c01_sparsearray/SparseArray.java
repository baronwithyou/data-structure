package com.baron.c01_sparsearray;

public class SparseArray {
    public static void main(String[] args) {
        int x = 11, y = 11;

        int[][] chessArr = new int[x][y];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;

        SparseArray sa = new SparseArray();

        int[][] sparseArray = sa.toSparseArray(chessArr, x, y);

        for (int[] row : sparseArray) {
            System.out.printf("%d\t%d\t%d\n", row[0], row[1], row[2]);
        }

        int[][] chessArr2 = sa.toNormalArray(sparseArray);

        for (int[] row : chessArr2) {
            for (int v : row) {
                System.out.printf("%d\t", v);
            }
            System.out.println();
        }
    }

    public int getNumberSum(int[][] arr) {
        int sum = 0;
        for (int[] row : arr) {
            for (int v : row) {
                if ( v != 0 ) {
                    sum++;
                }
            }
        }

        return sum;
    }

    public int[][] toSparseArray(int[][] arr, int x, int y) {
        int sum = getNumberSum(arr);

        // 将二维数组转换成稀疏数组
        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = x;
        sparseArray[0][1] = y;
        sparseArray[0][2] = sum;

        int count = 0;
        for ( int i = 0; i < x; i ++) {
            for (int j = 0; j < y; j ++) {
                if (arr[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = arr[i][j];
                }
            }
        }

        return sparseArray;
    }

    public int[][] toNormalArray(int[][] sparseArray) {
        int x = sparseArray[0][0];
        int y = sparseArray[0][1];
        int sum = sparseArray[0][2];

        int[][] arr = new int[x][y];

        for (int i = 1; i <= sum; i++) {
            arr[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        return arr;
    }
}

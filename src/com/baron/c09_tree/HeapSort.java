package com.baron.c09_tree;

import java.util.Arrays;

public class HeapSort {

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 对某个节点进行操作 - 将最大的数置顶
     * @param tree 以数组表示爹树结构 - 从上至下，从左至右
     * @param n 树的总长度 - 因为每次排序完之后都会剔除一个数
     * @param i 需要heapify的数组下标
     */
    private static void heapify(int[] tree, int n, int i) {
        if ( i >= n ) {
            return;
        }

        int max = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if ( left < n && tree[left] > tree[max] ) {
            max = left;
        }

        if ( right < n && tree[right] > tree[max] ) {
            max = right;
        }

        if ( max != i ) {
            swap(tree, max, i);
            heapify(tree, n, max);
        }
    }

    private static void buildHeap(int[] tree) {
        // 从最后一个节点的父节点开始进行heapify
        int n = tree.length;
        int lastNode = n - 1;
        for ( int i = (lastNode - 1) / 2; i >= 0; i-- ) {
            heapify(tree, n, i);
        }
    }

    private static void heapSort(int[] tree) {
        buildHeap(tree);

        for ( int i = tree.length - 1; i >= 0; i-- ) {
            swap(tree, 0, i);

            heapify(tree, i, 0);
        }
    }

    public static void main(String[] args) {
        int[] tree = {1, 3, 6, 8, 10, 14};

        heapSort(tree);

        System.out.println(Arrays.toString(tree));
    }

}

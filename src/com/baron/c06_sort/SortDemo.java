package com.baron.c06_sort;

import java.util.Arrays;

public class SortDemo {
    final private static int size = 1000000;

    public static void main(String[] args) {
        shellSort();

//        insertSort();

//        selectSort();
//
//        bubbleSort();
    }

    public static int[] generateNums(int n) {
        if ( n == 0 ) {
            n = size;
        }
        int[] nums = new int[n];

        for ( int i = 0; i < n; i++) {
            nums[i] = (int) (Math.random() * 20);
        }

        return nums;
    }

    public static void insertSort() {
        InsertSort sort = new InsertSort();

        sort(sort, generateNums(0));
    }

    public static void bubbleSort() {
        BubbleSort sort = new BubbleSort();

        sort(sort, generateNums(0));
    }

    public static void selectSort() {
        SelectSort sort = new SelectSort();

        sort(sort, generateNums(0));
    }

    public static void shellSort() {
        ShellSort sort = new ShellSort();

        sort(sort, generateNums(10));
    }

    public static void sort(SortInterface sort, int[] nums) {
        if ( nums.length <= 50 ) {
            System.out.println(Arrays.toString(nums));
        }
        sort.sort(nums);
        if ( nums.length <= 50 ) {
            System.out.println(Arrays.toString(nums));
        }
    }

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[b];

        nums[b] = nums[a];

        nums[a] = temp;
    }
}

package com.baron.c06_sort;

public class BubbleSort extends MySort implements SortInterface{
    public BubbleSort() {
        super("BubbleSort");
    }

    public void sort(int[] nums) {
        beforeSort();

        int length = nums.length;
        for ( int i = 0; i < length; i++ ) {
            for ( int j = 1; j < length - i; j++ ) {
                // 判断j 和 j +1的大小
                if (nums[j - 1] > nums[j]) {
                    SortDemo.swap(nums, j-1, j);
                }
            }
        }

        afterSort();
    }
}

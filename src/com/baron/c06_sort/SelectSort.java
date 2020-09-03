package com.baron.c06_sort;

public class SelectSort extends MySort implements SortInterface {
    public SelectSort() {
        super("SelectSort");
    }

    @Override
    public void sort(int[] nums) {
        beforeSort();

        int length = nums.length;
        for ( int i = 0; i < length; i++ ) {
            int min = i;
            for ( int j = i; j < length; j++ ) {
                if ( nums[j] < nums[min] ) {
                    min = j;
                }
            }

            if ( i != min ) {
                SortDemo.swap(nums, i, min);
            }
        }

        afterSort();
    }
}

package com.baron.c06_sort;

public class InsertSort extends MySort implements SortInterface {
    public InsertSort() {
        super("InsertSort");
    }

    public void sort(int[] nums) {
        beforeSort();

        for ( int i = 0; i < nums.length -1; i++) {
            int targetValue = nums[i + 1];
            int insertIndex = i;

            while ( insertIndex >= 0 && targetValue < nums[insertIndex] ) {
                nums[insertIndex + 1] = nums[insertIndex];

                insertIndex--;
            }
            if ( insertIndex + 1 == i ) {
                continue;
            }

            nums[insertIndex + 1] = targetValue;
        }

        afterSort();
    }
}

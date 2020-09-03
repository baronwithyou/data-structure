package com.baron.c06_sort;

import java.util.Arrays;

public class QuickSort extends MySort implements SortInterface {

    public QuickSort() {
        super("QuickSort");
    }

    @Override
    public void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int left, int right) {
        int pivot;

        if ( left < right ) {
            pivot = partition(nums, left, right);

            quickSort(nums, left, pivot - 1);
            quickSort(nums, pivot + 1, right);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivotValue = nums[left];

        while ( left < right ) {
            while ( left < right && nums[right] > pivotValue ) {
                right--;
            }

            while ( left < right && nums[left] < pivotValue ) {
                left++;
            }

            SortDemo.swap(nums, left, right);
        }

        nums[left] = pivotValue;

        return left;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 2, 9, 8, 1, 5, 7, 3 };

        QuickSort sort = new QuickSort();

        sort.sort(nums);

//        sort.partition(nums, 0, nums.length - 1);

        System.out.println(Arrays.toString(nums));
    }
}

package com.baron.c06_sort;

import java.util.Arrays;

public class MergeSort extends MySort implements SortInterface{


    public MergeSort() {
        super("MergeSot");
    }

    @Override
    public void sort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);

            merge(nums, left, mid, right);
        }
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int l = left, r = mid + 1, index = 0;
        int[] tmp = new int[right - left + 1];

        while ( l <= mid && r <= right ) {
            if ( nums[l] <= nums[right] ) {
                tmp[index++] = nums[l++];
            } else {
                tmp[index++] = nums[r++];
            }
        }

        while ( l <= mid ) {
            tmp[index++] = nums[l++];
        }

        while ( r <= right ) {
            tmp[index++] = nums[r++];
        }

        int i = 0;
        while ( left <= right ) {
            nums[left++] = tmp[i++];
        }
    }

//    private int[] merge(int[] left, int[] right) {
//        int ll = left.length;
//        int rl = right.length;
//
//        int[] tmp = new int[ll + rl];
//        int li = 0, ri = 0, i = 0;
//
//        while ( li < ll && ri < rl ) {
//            if ( left[li] <= right[ri] ) {
//                tmp[i] = left[li];
//                li++;
//            } else {
//                tmp[i] = right[ri];
//                ri++;
//            }
//            i++;
//        }
//
//        while ( li < ll ) {
//            tmp[i] = left[li];
//            li++;
//            i++;
//        }
//
//        while ( ri < rl ) {
//            tmp[i] = right[ri];
//            ri++;
//            i++;
//        }
//
//        return tmp;
//    }
}

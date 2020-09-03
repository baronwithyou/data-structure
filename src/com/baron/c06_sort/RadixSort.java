package com.baron.c06_sort;

import java.util.Arrays;

public class RadixSort extends MySort implements SortInterface{
    public RadixSort() {
        super("RadixSort");
    }

    public static void sort2(int[] nums) {
        int[][] buckets = new int[10][nums.length];

        int[] bucketIndex = new int[10];


        int max = nums[0];
        // 首次遍历查看需要遍历几次
        for ( int num : nums ) {
            if ( num > max ) {
                max = num;
            }
        }

        int count = (max + "").length();

        int number = 1;
        while ( count >= 0 ) {
            for ( int i = 0; i < nums.length; i++ ) {
                int index = nums[i] / number % 10;

                buckets[index][bucketIndex[index]] = nums[i];
                bucketIndex[index]++;
            }

            int index = 0;
            for ( int i = 0; i < buckets.length; i++ ) {
                for ( int j = 0; j < bucketIndex[i]; j++ ) {
                    nums[index++] = buckets[i][j];
                }

                bucketIndex[i]=0;
            }

            count--;
            number *= 10;
        }


        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] nums = { 69, 12, 34, 101 };

        sort2(nums);
    }

    @Override
    public void sort(int[] nums) {

    }
}

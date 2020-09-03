package com.baron.c06_sort;

import java.util.Arrays;

public class ShellSort extends MySort implements SortInterface{


    public ShellSort() {
        super("ShellSort");
    }

//    @Override
//    public void sort(int[] nums) {
//        beforeSort();
//        int length = nums.length;
//
//        // 每次以原本的一半进行遍历，比如数组长度为10，则每次以5，2，1个数组长度为单位进行排序
//        for ( int span = length / 2; span > 0; span /= 2 ) {
//
//            // 插入排序
//            for ( int i = span; i < length; i++ ) {
//                int target = i;
//
//                int insertValue = nums[target];
//
//                while (target-span >= 0 && nums[target-span] > insertValue ) {
//                    nums[target] = nums[target-span];
//
//                    target -= span;
//                }
//
//                if ( target != i ) {
//                    nums[target] = insertValue;
//                }
//            }
//        }
//
//        afterSort();
//    }

    public void sort(int[] nums) {
        int length = nums.length;

        for ( int gap = length / 2; gap > 0; gap /=2 ) {
            for ( int i = gap; i < length; i++ ) {

                int target = i;

                int insertValue = nums[target];

                while ( target-gap >= 0 && nums[target] < nums[target-gap] ) {
                    nums[target] = nums[target-gap];

                    target -= gap;
                }

                if ( target != i ) {
                    nums[target] = insertValue;
                }
            }
        }
    }


//    @Override
//    public void sort(int[] nums) {
//        beforeSort();
//
//        int length = nums.length;
//
//        for ( int span = length / 2;  span > 0; span /= 2 ) {
//            for ( int i = span; i < length; i++ ) {
//                for ( int j = i - span; j >= 0; j-=span) {
//                    if ( nums[j] > nums[j+span] ) {
//                        SortDemo.swap(nums, j+span, j);
//                    }
//                }
//            }
//
//            span /= 2;
//        }
//
//        afterSort();
//    }
}

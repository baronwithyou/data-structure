package com.baron.c08_search;

public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6,7,8,9};

        System.out.println(search(nums, 2));
    }

    public static int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    public static int search(int[] nums, int target, int left, int right) {
        if ( left > right ) {
            return -1;
        }
        int middle = (right-left) / 2 + left;

        if ( target == nums[middle] ) {
            return middle;
        } else if ( target < nums[middle] ) {
            return search(nums, target, left, middle - 1);
        } else {
            return search(nums, target, middle+1, right);
        }
    }
}

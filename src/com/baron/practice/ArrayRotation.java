package com.baron.practice;

import java.util.Arrays;

public class ArrayRotation {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,-100,3,99};

        rotate(nums, 2);

        System.out.println(Arrays.toString(nums));
    }
    public static void rotate(int[] nums, int k) {
        int index = 0;
        int preValue = nums[index];
        int tmp;
        for (int i = 0; i < nums.length; i++) {
            index = (index + k) % nums.length;

            // 记录下需要被替换的数字
            tmp = nums[index];

            nums[index] = preValue;

            preValue = tmp;
        }
    }
}

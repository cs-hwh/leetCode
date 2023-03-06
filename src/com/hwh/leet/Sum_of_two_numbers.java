package com.hwh.leet;

import java.util.Arrays;

/**
 * @author hwh
 * @create 2023-03-06 22:50
 */
public class Sum_of_two_numbers {
    //    给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
//
//    你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
    public static void main(String[] args) {
        int[] result = twoSum(new int[]{3,2,4}, 6);
        System.out.println(Arrays.toString(result));
    }
    //暴力解法
    public static int[] twoSum(int[] nums, int target) {
        int a, b;
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            a = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == a) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }
}

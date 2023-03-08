package com.hwh.leet;

import java.util.Arrays;
import java.util.HashMap;

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
    public static int[] twoSum1(int[] nums, int target) {
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
    //使用哈希表时间复杂度O(1)，空间复杂度O(N)
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }
}

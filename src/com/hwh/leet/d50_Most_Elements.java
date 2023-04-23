package com.hwh.leet;

import java.util.Arrays;

/**
 * @author hwh
 * @create 2023-04-22 22:25
 */
public class d50_Most_Elements {
    public static void main(String[] args) {

    }
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}

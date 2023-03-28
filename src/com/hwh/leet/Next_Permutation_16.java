package com.hwh.leet;

import java.util.Arrays;

/**
 * @author hwh
 * @create 2023-03-27 19:44
 */
public class Next_Permutation_16 {
    public static void main(String[] args) {
        int[] nums = new int[]{5,1,1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {
        int j = nums.length - 1, i = nums.length- 2, tmp = 0;
        while (i >= 0 && nums[i] >=nums[j]) {
            i--;
            j--;
        }//结束循环，出现不规则的数
        if (i < 0) {//说明这个数组已经是最大的字典数了,便不再操作
            i=0;
            j=nums.length-1;
            while (i < j) {
                tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j--;
            }
        } else {
            while (j < nums.length && nums[j] > nums[i]) {
                j++;
            }//找到比nums[i]大的最少的数
            j--;
            //交换i和j此时对应的值
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            //再将i后面的数按从小到大排序
            i++;
            j = nums.length - 1;
            while (i < j) {
                tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j--;
            }
        }
    }
}

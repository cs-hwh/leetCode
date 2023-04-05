package com.hwh.leet;

/**
 * @author hwh
 * @create 2023-04-05 19:28
 */
public class d25_Maximum_Subarray_Sum {
    public static void main(String[] args) {
        int i = maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println("i = " + i);
    }

    /**
     * 思想:f[i]表示以第i个元素结尾的子数组的最大和,f[i]=max(f[i-1]+nums[i],nums[i])
     * 显然f[i]是以nums[i]结尾的，那么最大和就是f[i]是否加上前一段最大和
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int pre=0,MaxAns=nums[0];
        for(int num:nums){
            pre=Math.max(pre+num,num);
            MaxAns=Math.max(pre,MaxAns);
        }
        return MaxAns;
    }
}

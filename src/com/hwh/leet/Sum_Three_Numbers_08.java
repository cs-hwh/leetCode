package com.hwh.leet;

import java.util.*;

/**
 * @author hwh
 * @create 2023-03-15 20:56
 * 三个数a+b+c=0，必定满足a<=b<=c,且如果a不变,b增大,那么c减小,即b右移,c必左移
 */
public class Sum_Three_Numbers_08 {
    public static void main(String[] args) {
        List<List<Integer>> list = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        Arrays.toString(list.toArray());
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);
        ArrayList<List<Integer>> resultList = new ArrayList<>();
        for(int a=0;a< n;a++){
            int c=n-1;
            int target=-nums[a];
            for(int b=a+1;b<n;b++){
                while (b<c && nums[b]+nums[c]>target){
                    c--;
                }
                
            }
        }
        return resultList;
    }
}

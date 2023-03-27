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
//        List<List<Integer>> list = threeSum(new int[]{0,0,0});
        System.out.println(list);
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);
        ArrayList<List<Integer>> resultList = new ArrayList<>();
        for(int a=0;a< n;a++){
            int c=n-1;
            int target=-nums[a];
            if(a>0&&nums[a]==nums[a-1]){//相同则跳过
                continue;
            }
            for(int b=a+1;b<n;b++){
                if(b>a+1&&nums[b]==nums[b-1]){//相同则跳过
                    continue;
                }
                while (b<c && nums[b]+nums[c]>target){
                    c--;
                }
                if(b==c){
                    break;
                }
                if(nums[b]+nums[c]==target){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[a]);
                    list.add(nums[b]);
                    list.add(nums[c]);
                    resultList.add(list);
                }
                
            }
        }
        return resultList;
    }
}

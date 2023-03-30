package com.hwh.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hwh
 * @create 2023-03-28 22:05
 */
public class Sum_Of_Combinations_20 {
    public static void main(String[] args) {
        List<List<Integer>> list = combinationSum(new int[]{2}, 1);
        System.out.println(list);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = backtracking(candidates, target, 0);
        return result==null?new ArrayList<>():result;
    }
    public static List<List<Integer>> backtracking(int[] nums, int target,int index) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = index; i < nums.length; i++) {
            if(nums[i]>target){
                return list.size()==0?null:list;
            }
            else if(nums[i]==target){
                ArrayList<Integer> list1 = new ArrayList<>();
                list1.add(nums[i]);
                list.add(list1);
                return list;
            }
            else if (nums[i] < target) {
                List<List<Integer>> resultList = backtracking(nums, target - nums[i],i);
                if(resultList!=null&&resultList.size()!=0){//说明这个值有解
                    for(List<Integer> o:resultList){
                        o.add(nums[i]);
                        list.add(o);
                    }
                }

            }
        }
        return list;
    }



}

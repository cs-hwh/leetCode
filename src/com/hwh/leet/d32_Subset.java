package com.hwh.leet;

import java.util.*;

/**
 * @author hwh
 * @create 2023-04-07 11:31
 * 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class d32_Subset {
    public static void main(String[] args) {
        List<List<Integer>> subsets = subsets(new int[]{1, 2, 3});
        for(List<Integer> list:subsets){
            System.out.println(list);
        }
        }
    public static List<List<Integer>> subsets(int[] nums) {
        //结果集
        List<List<Integer>> list = new ArrayList<>();
        //将空集加入集合中
        list.add(new ArrayList<>());
        for(int i=0;i<nums.length;i++){
            int size = list.size();
            for(int j=0;j<size;j++){
                ArrayList<Integer> list1 = new ArrayList<>(list.get(j));//获取原来的子集
                list1.add(nums[i]);
                list.add(list1);//形成新的子集再放回去
            }
        }
        return list;
    }

}

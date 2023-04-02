package com.hwh.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author hwh
 * @create 2023-04-01 19:15
 */
public class Full_Arrangement_22 {
    public static void main(String[] args) {
        Full_Arrangement_22 obj = new Full_Arrangement_22();
        List<List<Integer>> list = obj.permute(new int[]{1, 2, 3});
        System.out.println(list);
    }
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> resultList = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int num:nums){
            list.add(num);
        }
        int n = nums.length;
        backtracking(n,list,resultList,0);
        return resultList;
    }

    private void backtracking(int n, ArrayList<Integer> list, ArrayList<List<Integer>> resultList, int first) {
        if(first==n){
            resultList.add(new ArrayList<>(list));
        }
        for(int i=first;i<n; i++){
            Collections.swap(list,first,i);
            backtracking(n,list,resultList,first+1);
            Collections.swap(list,first,i);
        }
    }


}

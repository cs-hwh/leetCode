package com.hwh.leet;

import java.util.HashSet;

/**
 * @author hwh
 * @create 2023-04-12 21:17
 * 首先将所有数字存入一个集合中，需要遍历数组一次，时间复杂度为 O(n)。
 * 遍历数组 nums 中的每个数字 x，如果 x - 1 不在集合中，则从 x 开始往后找连续的数字，直到找不到为止。对于每个连续序列，只有最小的数会进入 while 循环，而且每个数字最多只会被访问一次，因此整个过程的时间复杂度也是 O(n)。
 * 在遍历过程中更新最长的连续序列长度，最后返回结果即可。
 */
public class d45_The_Longest_Continuous_Sequence {
    public static void main(String[] args) {
        int i = longestConsecutive(new int[]{4, 5, 6, 9, 1, 2, 4, 3, 8, 7});
        System.out.println("i = " + i);
    }
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int maxLen=0;
        for(int num:nums){
            if(!set.contains(num-1)){//这里做了一个优化，保证只有一个序列的开头才会进入遍历
                int currentNum=num;
                int currentLen=1;
                while (set.contains(currentNum+1)){//去遍历计算序列长度
                    currentLen++;
                    currentNum++;
                }
                maxLen=maxLen>currentLen?maxLen:currentLen;
            }
        }
        return maxLen;
    }
}

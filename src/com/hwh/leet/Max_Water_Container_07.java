package com.hwh.leet;

/**
 * @author hwh
 * @create 2023-03-14 21:15
 * 求最大的装水的容器
 * 思想：双指针
 * 原理：从远到近，双指针中移动高度大的不移动小的，求不出更大解,比起逐步遍历更快
 */
public class Max_Water_Container_07 {
    public static void main(String[] args) {
        int result = maxArea(new int[]{1, 1});
        System.out.println("result = " + result);
    }
    public static int maxArea(int[] height) {
        int i=0,j=height.length-1;
        int maxCapacity=0;
        while (i<j){
            int value=Math.min(height[i],height[j])*(j-i);
            maxCapacity=maxCapacity>=value?maxCapacity:value;
            if(height[i]<=height[j]){
                i++;
            }else {
                j--;
            }

        }
        return maxCapacity;
    }
}

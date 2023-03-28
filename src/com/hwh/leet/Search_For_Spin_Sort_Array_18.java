package com.hwh.leet;

/**
 * @author hwh
 * @create 2023-03-28 20:40
 */
public class Search_For_Spin_Sort_Array_18 {
    public static void main(String[] args) {
        int i = search(new int[]{1}, 3);
        System.out.println("i = " + i);
    }
    public static int search(int[] nums, int target) {
        if(nums==null||nums.length==0){
            return -1;
        }
        int left=0;
        int right=nums.length-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }else {
                if(nums[mid]<nums[right]){//如果有序区在右边
                    if(target>nums[mid]&&target<=nums[right]){//目标数是在有序区中
                        left=mid+1;
                    }else {//反之说明有序区中没有这个数，去无序区找
                        right=mid-1;
                    }
                }else {//反之有序区在左边
                    if(target>=nums[left]&&target<nums[mid]){//目标数是在有序区中
                        right=mid-1;
                    }else {//反之说明有序区中没有这个数，去无序区找
                        left=mid+1;
                    }
                }


            }
        }
        return -1;
    }
    //这是一个基本的二分法查找
    private static int binarySearch(int[] nums, int target) {
        if(nums==null||nums.length==0){
            return -1;
        }
        int left=0;
        int right=nums.length-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return -1;
    }
}

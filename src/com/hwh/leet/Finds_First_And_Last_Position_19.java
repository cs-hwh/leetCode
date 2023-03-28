package com.hwh.leet;

/**
 * @author hwh
 * @create 2023-03-28 21:17
 */
public class Finds_First_And_Last_Position_19 {
    public static void main(String[] args) {
        int i = binarySearchLeft(new int[]{1, 2, 3, 3, 5}, 7);
        int j = binarySearchRight(new int[]{1, 2, 3, 3, 5}, 3);
        System.out.println("i = " + i);
        System.out.println("j = " + j);
//       int[] a= new int[]{i,j};
    }

    /**
     * 二分法查找左边界
     * @param nums
     * @param target
     * @return
     */
     private static int  binarySearchLeft(int[] nums, int target) {
        if(nums.length==0||nums==null){
            return -1;
        }
        int left=0;
        int right=nums.length;
        while (left<right){//结束循环条件left==right
            int mid=left+(right-left)/2;
            if(nums[mid]<target){
                left=mid+1;
            }else if(nums[mid]>=target){
                right=mid;
            }
        }
        if(left==nums.length)return -1;//target比所有数都大
        return nums[left]==target?left:-1;
     }

    /**
     * 二分法找有边界
     * @param nums
     * @param target
     * @return
     */
    private static int  binarySearchRight(int[] nums, int target) {
        if(nums.length==0||nums==null){
            return -1;
        }
        int left=0;
        int right=nums.length;
        while (left<right){//结束循环条件left==right
            int mid=left+(right-left)/2;
            if(nums[mid]<=target){
                left=mid+1;//在[mid+1,right)中找
            }else if(nums[mid]>target){
                right=mid;//在[left,mid)中找
            }
        }
        if(left==nums.length)return -1;//target比所有数都大
        return nums[left-1]==target?left-1:-1;
    }
    }

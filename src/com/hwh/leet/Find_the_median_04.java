package com.hwh.leet;

/**
 * @author hwh
 * @create 2023-03-10 22:19
 */
//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
// 请你找出并返回这两个正序数组的 中位数 。
//
//  算法的时间复杂度应该为 O(log (m+n))
public class Find_the_median_04 {
    public static void main(String[] args) {
        double result = findMedianSortedArrays(new int[]{1, 3}, new int[]{2,4});
        System.out.println("result = " + result);
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums3=new int[nums1.length+nums2.length];
        //两个指针用于合并使用
        int i1=0,i2=0,i3=0;
        int n1=nums1.length,n2= nums2.length;
        while (i1< n1 && i2<n2){//合并数组
            if(nums1[i1]<nums2[i2]){
                nums3[i3]=nums1[i1];
                i1++;
            }else {
                nums3[i3]=nums2[i2];
                i2++;
            }
            i3++;
        }
        if(i1<n1){
         System.arraycopy(nums1,i1,nums3,i3,n1-i1);
        }else if(i2<n2){
            System.arraycopy(nums2,i2,nums3,i3,n2-i2);
        }
        int length=n1+n2;
        double result=nums3[length/2];
        if(length%2==0){
           result=(result+nums3[length / 2 - 1])/2;
        }
        return result;
    }
}

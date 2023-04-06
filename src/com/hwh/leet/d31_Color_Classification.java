package com.hwh.leet;

/**
 * @author hwh
 * @create 2023-04-06 20:31
 */
public class d31_Color_Classification {
    public static void main(String[] args) {
      int[] arr=  new int[]{1,2,2,2,2,0,0,0,1,1};
        sortColors(arr);
        for(int i:arr){
            System.out.print(i);
        }
        System.out.println();
    }

    /**
     * 双指针双向靠拢大法
     *
     * @param nums
     */
    public static void sortColors(int[] nums) {
        int p0 = 0, p1 = 0, p2 = nums.length - 1;//p0指向为0的位置，p1指向为1的位置，p2指向为2的位置
        while (p1 <= p2) {
            if(nums[p1]==0){
                swap(nums,p0,p1);
                p0++;
                p1++;
            }else if(nums[p1]==2){
                swap(nums,p1,p2);
                p2--;
            }else {
                p1++;
            }
        }
    }
    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

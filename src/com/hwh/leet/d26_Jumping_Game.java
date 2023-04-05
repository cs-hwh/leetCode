package com.hwh.leet;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author hwh
 * @create 2023-04-05 19:48
 */
public class d26_Jumping_Game {
    public static void main(String[] args) {
    boolean result= canJump2(new int[]{2,3,1,1,4});
        System.out.println("result = " + result);
    }

    /**
     * f[0]能不能到最后取决于f[0]=f[0+1]||f[0+2}||f[0+n]
     * @param nums
     * @return
     * 动态规划，时间效率和空间低
     */
    public static boolean canJump(int[] nums) {
      boolean[] f=new boolean[nums.length];
      int n=nums.length-1;
      f[n]=true;
      for(int i=n-1;i>=0;i--){
          int maxNum=nums[i]+i<=n?nums[i]:n-i;
          for(int j=1;j<=maxNum;j++){
              if(f[i+j]){
                  f[i]=true;
              }
          }
      }
     return f[0];
    }

    /**
     * 使用贪心的方法求解,计算能达到的最大下标
     * @param nums
     * @return
     */
    public static boolean canJump2(int[] nums) {
        int n=nums.length;
        int maxIndex=0;
        for(int i=0;i<n;i++){
            if(i<=maxIndex){
                maxIndex=Math.max(maxIndex,nums[i]+i);
                if(maxIndex>=n-1){
                    return true;
                }
            }
        }
        return false;
    }
}

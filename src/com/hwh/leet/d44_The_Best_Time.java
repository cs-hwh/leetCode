package com.hwh.leet;

/**
 * @author hwh
 * @create 2023-04-12 10:28
 */
public class d44_The_Best_Time {
    public static void main(String[] args) {
      int [] arr=  new int[]{7,6,4,3,1};
        int i = maxProfit(arr);
        System.out.println("i = " + i);
    }
    public static int maxProfit(int[] prices) {
        int n=prices.length;
        int maxProfit=0;
        int minProfit=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
         if(prices[i]<minProfit){
             minProfit=prices[i];
         }else if(prices[i]-minProfit>maxProfit){
             maxProfit=prices[i]-minProfit;
         }
        }
        return maxProfit;
    }
}

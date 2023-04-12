package com.hwh.leet;

/**
 * @author hwh
 * @create 2023-04-12 22:16
 */
public class d46_Appears_Only_Once {
    public static void main(String[] args) {

    }
    public int singleNumber(int[] nums) {
       int single=0;
       for(int num:nums){
           single=single^num;
       }

       return single;
    }
}

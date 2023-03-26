package com.hwh.leet;

/**
 * @author hwh
 * @create 2023-03-26 21:41
 */
public class Climb_Stairs_15 {
    public static void main(String[] args) {

    }

    public int climbStairs(int n) {
        int p=0,q=0,r=1;
        for(int i=1;i<=n;i++){
            p=q;
            q=r;
            r=p+q;
        }
        return r;
    }
}

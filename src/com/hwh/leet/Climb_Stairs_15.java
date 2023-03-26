package com.hwh.leet;

/**
 * @author hwh
 * @create 2023-03-26 21:41
 * 最后一步只可能是一步或两步，那么剩下的可能就是f(n-1)+f(n-2)
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

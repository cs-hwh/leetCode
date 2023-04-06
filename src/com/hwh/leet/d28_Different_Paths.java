package com.hwh.leet;

import java.math.BigInteger;

/**
 * @author hwh
 * @create 2023-04-06 10:51
 */
public class d28_Different_Paths {
    public static void main(String[] args) {
        int i = uniquePaths2(10, 10);
        System.out.println("i = " + i);
    }

    /**
     * 纯数学解
     * 即总步数固定，就等于从 m+n−2m+n-2m+n−2 次移动中选择 m−1m-1m−1 次向下移动的方案数，即组合数：
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths1(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; ++x, ++y) {
            ans = ans * x / y;
        }
        return (int) ans;
    }

    /**
     * 动态规划
     * f[i][j]表示左上角到i,j的步数，那么f[i][j]=f[i-1][j]+f[i][j-1]
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths2(int m, int n) {
        int[][] f=new int[m][n];
        for(int i=0;i<m;i++){//由于只能向右和向下，那么f[0][0]到f[i][0]和f[0][j]的路径都只有一条
            f[i][0]=1;
        }
        for(int j=0;j<n;j++){
            f[0][j]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                f[i][j]=f[i-1][j]+f[i][j-1];
            }
        }
        return f[m-1][n-1];
    }
}

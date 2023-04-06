package com.hwh.leet;

/**
 * @author hwh
 * @create 2023-04-06 14:31
 */
public class d29_Minimum_Path_Sum {
    public static void main(String[] args) {
        int i = minPathSum(new int[][]{{1,2},{5,6},{1,1}});
        System.out.println("i = " + i);
    }

    /**
     * f[i,j]表示从0,0到i,j的最小路径,   f[i][j]=min(f[i-1][j],f[i][j-1])+grid[i][j]
     * f[0][j] || f[i][0]
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {
        int[][] f=new int[grid.length][grid[0].length];
        f[0][0]=grid[0][0];
        for(int i=1;i<grid.length;i++){
           f[i][0]=f[i-1][0]+grid[i][0];
        }
        for(int j=1;j<grid[0].length;j++){
            f[0][j]=f[0][j-1]+grid[0][j];
        }

        for(int i=1;i<grid.length;i++){
            for(int j=1;j<grid[0].length;j++){
                f[i][j]=Math.min(f[i-1][j],f[i][j-1])+grid[i][j];
            }
        }
        return f[grid.length-1][grid[0].length-1];
    }
}

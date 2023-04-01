package com.hwh.leet;

import java.util.Arrays;

/**
 * @author hwh
 * @create 2023-04-01 22:44
 */
public class Rotation_Matrix_23 {
    public static void main(String[] args) {
       int[][] arrs= new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate(arrs);
        for(int[] a:arrs){
            System.out.println(Arrays.toString(a));
        }

    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        //先转置下这个矩阵
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for(int[] a:matrix){
            System.out.println(Arrays.toString(a));
        }
        System.out.println("-------");
        //再按列反转
        for(int i=0;i<n;i++){
            for (int j = 0; j < n/2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = tmp;
            }
        }
    }
}

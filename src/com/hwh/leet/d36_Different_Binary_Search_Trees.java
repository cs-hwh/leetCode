package com.hwh.leet;

/**
 * @author hwh
 * @create 2023-04-10 19:27
 * 不同的二叉搜索树
 */
public class d36_Different_Binary_Search_Trees {
    public static void main(String[] args) {
        int i = numTrees(5);
        System.out.println(i);
    }
    public static int numTrees(int n) {
        int[] f=new int[n+1];//表示n个数有多少种二叉搜索树
        f[0]=1;
        int sum=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){//遍历1~i为根节点时组成的树的个数
                f[i]+=f[j-1]*f[i-j];
            }
        }
        return f[n];
    }
}

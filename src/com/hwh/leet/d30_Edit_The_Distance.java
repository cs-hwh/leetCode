package com.hwh.leet;

/**
 * @author hwh
 * @create 2023-04-06 19:44
 */
public class d30_Edit_The_Distance {
    public static void main(String[] args) {
        int i = minDistance("horse", "ros");
        System.out.println("i = " + i);
    }

    /**
     * 动态规划思想
     * db[i][j]代表word1的前i个字符转成word2前j个字符所需要的最少步数
     * 如果word1[i]==word2[j]那么不需要额外的操作,f[i][j]=f[i-1][j-1]
     * 不等
     * 插入   db[i][j]=db[i][j-1]+1
     * 替换   db[i][j]=db[i-1][j]+1
     * 删除   db[i][j]=db[i-1][j-1]+1
     * @param word1
     * @param word2
     * @return
     */
    public static int minDistance(String word1, String word2) {
        int m=word1.length(),n=word2.length();
        int[][] db=new int[m+1][n+1];
        for (int i=0;i<=m;i++){
            db[i][0]=i;
        }
        for(int j=0;j<=n;j++){
            db[0][j]=j;
        }
        for(int i=1;i<=m;i++){
            for (int j=1;j<=n;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    db[i][j]=db[i-1][j-1];
                }else {
                    db[i][j]=Math.min(Math.min(db[i][j-1],db[i-1][j]),db[i-1][j-1])+1;
                }
            }
        }
        return db[m][n];
    }
}

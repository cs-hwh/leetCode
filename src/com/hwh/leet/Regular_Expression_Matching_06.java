package com.hwh.leet;

/**
 * @author hwh
 * @create 2023-03-13 22:28
 *
 */
public class Regular_Expression_Matching_06 {
    public static void main(String[] args) {
        boolean result = isMatch("aa", "a");
        System.out.println(result);
    }
    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0]=true;
        for(int i=0;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(p.charAt(j-1)=='*'){
                    f[i][j]=f[i][j-2];
                    if(matching(s,p,i,j-1)){
                        f[i][j]=f[i-1][j]||f[i][j-2];
                    }
                }else {
                    if(matching(s,p,i,j)){
                        f[i][j]=f[i-1][j-1];
                    }
                }
            }
        }
        return f[m][n];
    }
    public static boolean matching(String s,String p,int i,int j){
        if(i==0){
            return false;
        }
        if(p.charAt(j-1)=='.'){
            return true;
        }
        return s.charAt(i-1)==p.charAt(j-1);
    }
}

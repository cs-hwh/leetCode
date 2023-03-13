package com.hwh.leet;

/**
 * @author hwh
 * @create 2023-03-12 22:29
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */
public class longest_palindromic_substring_05 {
    public static void main(String[] args) {
        String s = longestPalindrome1("cbbd");
        System.out.println(s);
    }

    //以动态规划的方法解决
    //
    public static String longestPalindrome1(String s) {

        int len = s.length();
        if(len<2){//长度小于2的直接返回
            return s;
        }
        int maxLen = 1;//初始值应为1
        int begin = 0;
        char[] charArray = s.toCharArray();
        boolean[][] arrays = new boolean[s.length()][s.length()];
        for (int i = 0; i < len; i++) {
            arrays[i][i] = true;
        }
        //
        for (int L = 2; L <= len; L++) {
            for (int i = 0; i < len; i++) {
                int j = L +i - 1;//j-i+1=L右边界
                if (j >= len) {//如果右边界越界
                    break;
                }
                //首先判断首尾字符是否相同
                if (charArray[i] != charArray[j]) {
                    arrays[i][j] = false;//不同肯定不是回文
                } else {
                    if(j-i<3){//防止太段的串如aba被判为false
                        arrays[i][j] = true;
                    }else {
                        arrays[i][j] = arrays[i + 1][j - 1];
                    }

                }
                if(arrays[i][j] &&j-i+1>maxLen){
                    maxLen=j-i+1;
                    begin=i;
                }

            }
        }
        return s.substring(begin,begin+maxLen);
    }

    /*
    中心扩散法
    核心思路:一个或两个字符为起点,两端字符应是相同的

    */
    public static String longestPalindrome2(String s) {


        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            //两端扩展,分别以1个或两个字符为起点
            int len1 = charactersExtended(s, i, i + 1);
            int len2 = charactersExtended(s, i, i);

            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        //注意end不会包括,故要+1
        return s.substring(start, end + 1);
    }

    //向两端扩展的方法
    private static int charactersExtended(String s, int left, int right) {
        //这里注意left>=0 && right<s.length()要放前面，不然空指针
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

}

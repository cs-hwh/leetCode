package com.hwh.leet;

import java.util.HashSet;

/**
 * @author hwh
 * @create 2023-03-09 22:19
 */
public class length_Of_Longest_Substring_03 {
    public static void main(String[] args) {
        int result = lengthOfLongestSubstring("pwwkew");
        System.out.println("result = " + result);
    }
//    pwwkew
    public static int lengthOfLongestSubstring(String s) {
        //该集合用于判断读到的字符是否出现过
        HashSet<Character> hashSet = new HashSet<>();
        int length = s.length();
        //rp右指针,lp左指针,ans最终长度
        int rp=0,lp=0,ans=0;
        for(;rp<length;rp++){
            char ch = s.charAt(rp);
            while(hashSet.contains(ch)){
                hashSet.remove(s.charAt(lp));
                lp++;
            }
            hashSet.add(ch);
            ans=Math.max(ans,rp-lp+1);
        }
        return ans;
    }
}

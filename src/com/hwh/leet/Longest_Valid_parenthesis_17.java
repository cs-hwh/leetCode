package com.hwh.leet;

import java.util.ArrayDeque;

/**
 * @author hwh
 * @create 2023-03-28 19:53
 */
public class Longest_Valid_parenthesis_17 {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses(")()())"));
    }
    public static int longestValidParentheses(String s) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(deque.isEmpty()){
                deque.push(i);
            }else {
                Integer index = deque.peek();
                if(c==')'&& s.charAt(index)=='('){
                    deque.pop();
                }else {
                    deque.push(i);
                }
            }
        }
        if(deque.isEmpty()){
            return s.length();
        }else {
            int maxLen=0;
            int i=s.length(),j=0;
            while (!deque.isEmpty()){
                j=deque.pop();
                maxLen=maxLen>(i-j-1)?maxLen:i-j-1;
                i=j;
            }
            //这里再减下，是为了排除初始段匹配了的情况
            j=-1;
            maxLen=maxLen>(i-j-1)?maxLen:i-j-1;
            return maxLen;
        }

    }

}

package com.hwh.leet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hwh
 * @create 2023-03-26 19:22
 * Parentheses are generated
 */
public class Parentheses_Are_Generated_13 {
    public static void main(String[] args) {
        List<String> list = generateParenthesis(4);
        System.out.println("list = " + list.size());
    }

    public static List<String> generateParenthesis(int n) {
        ArrayList<String> ans = new ArrayList<>();
        if (n == 1) {
            ans.add("()");
        } else {
            for (String str : generateParenthesis(n - 1)) {
                for(int i=0;i<2*(n-1);i++){
                    String tmp= str.substring(0,i)+"()"+str.substring(i);
                    if(!ans.contains(tmp)){
                        ans.add(tmp);
                    }
                }
            }
        }
        return ans;

    }

}

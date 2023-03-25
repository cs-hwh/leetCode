package com.hwh.leet;

import java.util.ArrayDeque;
import java.util.HashMap;

/**
 * @author hwh
 * @create 2023-03-23 23:16
 */
public class Valid_Parentheses_11 {
    public static void main(String[] args) {
        boolean valid = isValid("([[]])");
        System.out.println("valid = " + valid);
    }

    public static boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        ArrayDeque<Character> deque = new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(deque.isEmpty()){
                deque.push(c);
            }else {
                Character head = deque.peek();
                if(head.equals(map.get(c))){
                    deque.pop();
                }else {
                    deque.push(c);
                }
            }
        }
        return deque.isEmpty();
    }
}

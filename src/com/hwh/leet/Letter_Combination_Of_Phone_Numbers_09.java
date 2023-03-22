package com.hwh.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author hwh
 * @create 2023-03-22 21:47
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射与电话按键相同。注意 1 不对应任何字母。
 */
public class Letter_Combination_Of_Phone_Numbers_09 {
    public static void main(String[] args) {
        List<String> letterCombinations = letterCombinations("23");
        System.out.println(Arrays.toString(letterCombinations.toArray()));
    }

    public static List<String> letterCombinations(String digits) {
        ArrayList<String> list = new ArrayList<>();
        if (digits.length() == 0) {
            return list;
        }
        HashMap<Character, String> mappingMap = new HashMap<>();
        mappingMap.put('2', "abc");
        mappingMap.put('3', "def");
        mappingMap.put('4', "ghi");
        mappingMap.put('5', "jkl");
        mappingMap.put('6', "mno");
        mappingMap.put('7', "pqrs");
        mappingMap.put('8', "tuv");
        mappingMap.put('9', "wxyz");
        backtrack(list,mappingMap,digits,0,new StringBuffer());
        return list;
    }

    public static void backtrack(ArrayList<String> targetList, HashMap<Character, String> mappingMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {//如果遍历完了，就添加
            targetList.add(combination.toString());
        } else {
            //得到输入的数字
            char digit = digits.charAt(index);
            //数字对应的映射
            String letter = mappingMap.get(digit);
            int letterLength = letter.length();
            for (int i = 0; i < letterLength; i++) {
                //得到数字映射表中的字符
                combination.append(letter.charAt(i));
                backtrack(targetList, mappingMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }


    }
}

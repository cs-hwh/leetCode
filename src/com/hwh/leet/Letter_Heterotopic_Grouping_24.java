package com.hwh.leet;

import java.util.*;

/**
 * @author hwh
 * @create 2023-04-02 20:05
 */
public class Letter_Heterotopic_Grouping_24 {
    public static void main(String[] args) {
        List<List<String>> lists = groupAnagrams2(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(lists);
    }

    /**
     * 排序，相同
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str:strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s =new String(chars);
            List<String> list = map.getOrDefault(s, new ArrayList<String>());
            list.add(str);
            map.put(s,list);
        }
        return new ArrayList<>(map.values());
    }
    public static List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str:strs){
            int[] counts = new int[26];
            for(int i=0;i<str.length();i++){//纪录组成字母出现次数
                counts[str.charAt(i)-'a']++;
            }
            StringBuffer buffer = new StringBuffer();
            for(int i=0;i<26;i++){
                if(counts[i]!=0){//以字母加出现次数为键
                    buffer.append(i+'a');
                    buffer.append(counts[i]);
                }
            }
            String key=buffer.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key,list);

        }
        return new ArrayList<>(map.values());
    }
}

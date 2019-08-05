package sdu.edu.leetcode.medium;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0;i < strs.length;i++){
            char[] chrs = strs[i].toCharArray();
            Arrays.sort(chrs);
            String str = String.valueOf(chrs);
            if(!map.containsKey(str)){
                map.put(str, new ArrayList<String>());
            }
            map.get(str).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }



}

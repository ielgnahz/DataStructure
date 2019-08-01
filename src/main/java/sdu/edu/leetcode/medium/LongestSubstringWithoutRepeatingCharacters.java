package sdu.edu.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        char[] strs = s.toCharArray();
        int max = 0;
        int pre = 0;
        for(int i = 0;i < strs.length;i++){
            for(int j = pre;j < strs.length;j++){
                if(strs[i] == strs[j]){
                    //pre为i的前一个字符 重复的位置的索引
                    max = Math.max(i - pre,max);
                    pre = j + 1;
                    break;
                }
            }
        }
        return Math.max(max, s.length() - pre);
    }

    public int lengthOfLongestSubstring2(String s){
        char[] chrs = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int j = 0;
        int max = 0;
        for(int i = 0;i < chrs.length;i++){
            if(map.containsKey(chrs[i])){
                j = Math.max(j, map.get(chrs[i]));
            }
            max = Math.max(max, i - j + 1);
            map.put(chrs[i], i+1);
        }
        return max;
    }

}

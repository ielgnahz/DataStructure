package sdu.edu.leetcode.hard;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {

        int[] map = new int[256];
        int i = 0,j = 0,start = -1,len = Integer.MAX_VALUE,count = t.length();
        char[] chrs = s.toCharArray();

        for(char c : t.toCharArray()){
            map[c]++;
        }
        while(j < chrs.length){
            if(map[chrs[j++]]-- > 0){
                count--;
            }
            while(count == 0){
                if(len > j - i){
                    len = j - i;
                    start = i;
                }
                if(map[chrs[i++]]++ == 0){
                    count++;
                }
            }
        }
        return start == -1?"":s.substring(start, start + len);

    }

}

package sdu.edu.leetcode.hard;

import java.util.*;

public class SubstringwithConcatenationofAllWords {

    public List<Integer> findSubstring(String s, String[] words) {

        if(s.isEmpty() || words.length == 0){
            return Collections.emptyList();
        }
        int wl = words.length;
        int nl = words[0].length();
        Map<String, Integer> dict = new HashMap<>();
        int len = s.length();
        List<Integer> result = new ArrayList<>();
        for(int i = 0;i < words.length;i++){
            dict.put(words[i], dict.containsKey(words[i])?dict.get(words[i]) + 1:1);
        }
        /*
        dict    存储word中单词出现的数量
        tdict存储每一次遍历中单词出现的数量
        left为当前匹配的字符串的起始位置
        count记录匹配的单词的数量
         */
        for(int i = 0;i < nl;i++){
            int left = i;
            Map<String, Integer> tdict = new HashMap<>();
            int count = 0;
            for(int j = i;j <= len - nl;j+=nl){
                String str = s.substring(j, j + nl);
                if(dict.containsKey(str)){
                    tdict.put(str, tdict.containsKey(str)?tdict.get(str) + 1:1);
                    if(tdict.get(str) > dict.get(str)){
                        /*
                        当tdict中存储str单词数比dict中多时，需要left指针左移然后去掉tdict中多出的这个str，如果去掉的是其他单词则count-1;
                         */
                        while(tdict.get(str) > dict.get(str)){
                            String str2 = s.substring(left, left+ nl);
                            tdict.put(str2, tdict.get(str2) - 1);
                            if(tdict.get(str2) < dict.get(str2)){
                                count--;
                            }
                            left += nl;
                        }
                    }else{
                        count++;
                    }
                    if(count == wl){
                        result.add(left);
                        String str3 = s.substring(left, left + nl);
                        tdict.put(str3, tdict.get(str3) - 1);
                        count--;
                        left += nl;

                    }
                }else{
                    tdict.clear();
                    left = j+nl;
                    count = 0;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new SubstringwithConcatenationofAllWords().findSubstring("barfoothefoobarman", new String[]{"foo","bar"}));
    }

}

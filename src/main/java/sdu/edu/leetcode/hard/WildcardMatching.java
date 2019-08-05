package sdu.edu.leetcode.hard;

public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        /**
         * startIndex   代表当前*的位置
         * match代表匹配到*时s从哪开始遍历
         */
        int sIndex = 0, pIndex = 0, startIndex = -1,match = 0;
        while(sIndex < s.length()){
            if(pIndex < p.length() && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '?')){
                pIndex++;sIndex++;
            }else if(pIndex < p.length() && p.charAt(pIndex) == '*'){
                startIndex = pIndex;
                match = sIndex;
                pIndex++;
            }else if(startIndex != -1){
                pIndex = startIndex + 1;
                sIndex = ++match;
            }else{
                return false;
            }
        }
        while(pIndex < p.length() && p.charAt(pIndex) == '*'){
            pIndex++;
        }
        return pIndex == p.length();
    }
}

package sdu.edu.leetcode.medium;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {

        int start = 0;
        int end = 0;
        int len = 0;
        char[] chrs = s.toCharArray();
        for(int i = 0;i < chrs.length;i++){
            int len1 = expancenter(i,i, chrs);
            int len2 = expancenter(i,i+1, chrs);
            len = Math.max(len1,len2);
            if(len > end - start){
                start = i - (len + 1) / 2 + 1;
                end = i + len / 2 + 1;
            }
        }
        return s.substring(start, end + 1);

    }

    public int expancenter(int L,int R,char[] chrs){
        while(L >=0 && R < chrs.length && chrs[L] == chrs[R]){
            L--;
            R++;
        }
        return R - L - 1;
    }
}

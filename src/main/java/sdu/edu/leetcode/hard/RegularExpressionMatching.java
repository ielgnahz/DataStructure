package sdu.edu.leetcode.hard;

public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        if(p.equals("")){
            return true;
        }
        return isMatch(s.toCharArray(),0,p.toCharArray(),0);
    }

    public boolean isMatch(char[] s,int si,char[] p,int pi){
        if(pi == p.length){
            return si == s.length;
        }
        boolean flag = false;
        if(si < s.length && (s[si] == p[pi] || p[pi] == '.')){
            flag = true;
        }

        if(pi + 1 < p.length && p[pi+1] == '*'){
            return isMatch(s, si, p, pi+2) || (flag && isMatch(s, si+1, p, pi));
        }else{
            return flag && isMatch(s, si+1, p, pi+1);
        }
    }

}

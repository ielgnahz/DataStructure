package sdu.edu.leetcode.easy;

public class ImplementstrStr {

    public int strStr(String haystack, String needle) {

        if(needle.isEmpty()){return 0;}
        if(haystack.isEmpty()){return -1;}
        int nlen = haystack.length();
        int mlen = needle.length();
        if(nlen == mlen){ return haystack.compareTo(needle) == 0?0:-1;}
        int i = 0;
        int j = 0;
        while(i < haystack.length()){
            if(haystack.length() - i < needle.length()){
                break;
            }
            j = 0;
            int index = i;
            while(j < needle.length() && haystack.charAt(index) == needle.charAt(j)){
                index++;
                j++;
            }
            if(j == needle.length()){
                return i;
            }
            i++;
        }
        return -1;
    }

}

package sdu.edu.leetcode.easy;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        return MergeSort(strs, 0 ,strs.length - 1);
    }

    public String MergeSort(String[] strs, int left, int right){
        if(left == right){
            return strs[left];
        }
        int mid = (left + right) / 2;
        String str1 = MergeSort(strs, left, mid);
        String str2 = MergeSort(strs,mid + 1, right);
        return getCommons(str1, str2);
    }

    public String getCommons(String str1, String str2){
        char[] chrs1 = str1.toCharArray();
        char[] chrs2 = str2.toCharArray();
        int l1 = 0;
        while(l1 < chrs1.length && l1 < chrs2.length && chrs1[l1] == chrs2[l1]){
            l1++;
        }
        return str1.substring(0, l1);
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"flower","flow","flight"}));;
    }

}

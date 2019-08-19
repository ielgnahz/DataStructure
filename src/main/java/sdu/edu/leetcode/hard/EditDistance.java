package sdu.edu.leetcode.hard;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        char[] chrs1 = word1.toCharArray();
        char[] chrs2 = word2.toCharArray();
        int n1 = chrs1.length;
        int n2 = chrs2.length;
        int[][] dp = new int[n1 + 1][n2 + 1];
        for(int i = 1;i < n2 + 1;i++){
            dp[0][i] = i;
        }
        for(int i = 1;i < n1 + 1;i++){
            dp[i][0] = i;
        }
        for(int i = 1;i < n1 + 1;i++){
            for(int j = 1;j < n2 + 1;j++){
                if(chrs1[i - 1] == chrs2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }
            }
        }
        return dp[n1][n2];
    }
}

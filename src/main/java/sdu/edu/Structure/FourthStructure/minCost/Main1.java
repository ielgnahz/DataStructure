package sdu.edu.Structure.FourthStructure.minCost;

public class Main1 {
	public int minCost(String arr1, String arr2, int ic, int dc, int rc) {
		char[] str1 = arr1.toCharArray();
		char[] str2 = arr2.toCharArray();
		int m = str1.length;
		int n = str2.length;
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 1; i < m + 1; i++) {
			dp[i][0] = dp[i - 1][0] + dc;
		}
		for (int j = 1; j < n + 1; j++) {
			dp[0][j] = dp[0][j - 1] + ic;
		}
		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				dp[i][j] = Math.min(dp[i-1][j]+dc, dp[i][j-1]+ic);
				if(str1[i] == str2[j]){
					dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]);
				}else{
					dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]+rc);
				}
			}
		}
		return dp[m][n];
	}
	public static void main(String[] args) {
		System.out.println(new Main().minCost("ab12cd3", "abcdf", 5, 2, 3));
	}
}

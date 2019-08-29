package sdu.edu.Structure.FourthStructure.LCSE;

public class Main1 {
	public int[][] getdp(char[] str1, char[] str2) {
		int[][] dp = new int[str1.length][str2.length];
		dp[0][0] = str1[0] == str2[0] ? 1 : 0;
		for (int i = 1; i < str1.length; i++) {
			dp[i][0] = str1[i] == str2[0] ? 1 : Math
					.max(dp[i - 1][0], dp[i][0]);
		}
		for (int j = 1; j < str2.length; j++) {
			dp[0][j] = str1[0] == str2[j] ? 1 : Math
					.max(dp[0][j - 1], dp[0][j]);
		}

		for (int i = 1; i < str1.length; i++) {
			for (int j = 1; j < str2.length; j++) {
				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				if (str1[i] == str2[j]) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
				}
			}
		}
		return dp;
	}

	public String lcse(String arr1, String arr2) {
		char[] str1 = arr1.toCharArray();
		char[] str2 = arr2.toCharArray();
		int[][] dp = getdp(str1, str2);
		int l = str1.length - 1;
		int r = str2.length - 1;
		int len = dp[l][r];
		char[] res = new char[len];
		while (len >= 0) {
			if (l > 0 && dp[l][r] == dp[l - 1][r]) {
				l--;
			} else if (r > 0 && dp[l][r] == dp[l][r - 1]) {
				r--;
			} else {
				res[--len] = str1[l];
				l--;
				r--;
			}
		}
		return res.toString();
	}

	public static void main(String[] args) {
		String str1 = "1A2C3D4B56";
		String str2 = "B1D23CA45B6A";
		System.out.println(new Main().lcse(str1, str2));
	}

}

package sdu.edu.Structure.FourthStructure.isCross;

public class Main {
	public boolean isCross(String str1, String str2, String aim) {
		if (aim.length() != str1.length() + str2.length()) {
			return false;
		}
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
		char[] aims = aim.toCharArray();
		int m = arr1.length;
		int n = arr2.length;
		boolean[][] dp = new boolean[m + 1][n + 1];
		for (int i = 1; i < m+1; i++) {
			if (arr1[i-1] != aims[i-1]) {
				break;
			}
			dp[i][0] = true;
		}
		for (int j = 1; j < n+1; j++) {
			if (arr2[j-1] != aims[j-1]) {
				break;
			}
			dp[0][j] = true;
		}
		for(int i = 1;i<m+1;i++){
			for(int j = 1;j<n+1;j++){
				if((dp[i-1][j] && arr1[i-1] == aims[i+j-1]) || (dp[i][j-1] && arr2[j-1] == aims[i+j-1])){
					dp[i][j] = true;
				}
			}
		}
		return dp[m][n];
	}
	public static void main(String[] args) {
		System.out.println(new Main().isCross("AB", "12", "AB12"));
	}
}

package sdu.edu.Structure.FourthStructure.minCoins;

public class Main {
	public int minCoins(int[] arr, int aim) {
		if (arr == null || aim == 0) {
			return 0;
		}
		int n = arr.length;
		int max = Integer.MAX_VALUE;
		int[][] dp = new int[n][aim + 1];
		int left = 0;
		for (int j = 1; j < aim + 1; j++) {
			dp[0][j] = max;
			if (j - arr[0] >= 0 && dp[0][j - arr[0]] != max) {
				dp[0][j] = dp[0][j - arr[0]] + 1;
			}
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < aim + 1; j++) {
				left = max;
				if (j - arr[i] >= 0 && dp[i][j - arr[i]] != max) {
					left = dp[i][j - arr[i]] + 1;
				}
				dp[i][j] = Math.min(left, dp[i - 1][j]);
			}
		}
		return dp[n - 1][aim] != max ? dp[n - 1][aim] : -1;
	}

	public static void main(String[] args) {
		System.out.println(new Main().minCoins1(new int[] { 5, 2, 3 }, 15));
	}

	public int minCoins1(int[] arr, int aim) {
		if (arr == null || aim == 0) {
			return 0;
		}
		int n = arr.length;
		int[][] dp = new int[n][aim + 1];
		int max = Integer.MAX_VALUE;
		for (int j = 1; j < aim + 1; j++) {
			dp[0][j] = max;
		}
		if (arr[0] < aim) {
			dp[0][arr[0]] = 1;
		}
		int left = 0;
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < aim + 1; j++) {
				left = max;
				if (j - arr[i] >= 0 && dp[i - 1][j - arr[i]] != max) {
					left = dp[i - 1][j - arr[i]] + 1;
				}
				dp[i][j] = Math.min(left, dp[i - 1][j]);
			}
		}
		return dp[n - 1][aim] != max ? dp[n - 1][aim] : -1;
	}

}

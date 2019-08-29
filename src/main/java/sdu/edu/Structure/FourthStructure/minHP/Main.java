package sdu.edu.Structure.FourthStructure.minHP;

public class Main {
	public int minHP(int[][] map){
		int m = map.length-1;
		int n = map.length-1;
		int[][] dp = new int[m+1][n+1];
		dp[m][n] = Math.max(1, 1 - map[m][n]);
		for(int i = m-1;i>=0;i--){
			dp[i][n] = Math.max(1, dp[i+1][n]-map[i][n]);
		}
		for(int j = n-1;j>=0;j--){
			dp[m][j] = Math.max(1, dp[m][j+1]-map[m][j]);
		}
		int left = 0;
		int right = 0;
		for(int i = m-1;i>=0;i--){
			for(int j = n-1;j>=0;j--){
				left = Math.max(dp[i][j+1]-map[i][j], 1);
				right = Math.max(dp[i+1][j]-map[i][j], 1);
				dp[i][j] = Math.min(left, right);
			}
		}
		return dp[0][0];
		
	}
	public static void main(String[] args) {
		int[][] map = new int[][]{{-2,-3,3},{-5,-10,1},{0,30,-5}};
		System.out.println(new Main().minHP(map));
	}
}

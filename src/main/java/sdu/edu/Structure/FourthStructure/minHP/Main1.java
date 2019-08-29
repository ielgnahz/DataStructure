package sdu.edu.Structure.FourthStructure.minHP;

public class Main1 {
	public int minHP(int[][] map){
		if(map == null){
			return 0;
		}
		int m = map.length;
		int n = map[0].length;
		int[][] res = new int[m][n];
		res[m-1][n-1] = Math.max(1-map[m-1][n-1], 1);
		for(int i = m-2;i>=0;i--){
			res[i][n-1] = Math.max(1, res[i+1][n-1]-map[i][n-1]);
		}
		for(int j = n-2;j>=0;j--){
			res[m-1][j] = Math.max(1, res[m-1][j+1]-map[m-1][j]);
		}
		int left = 0;
		int right = 0;
		for(int i = m-2;i>=0;i--){
			for(int j = n-2;j>=0;j--){
				left = Math.max(res[i][j+1]-map[i][j], 1);
				right = Math.max(res[i+1][j]-map[i][j], 1);
				res[i][j] = Math.min(left, right);
			}
		}
		return res[0][0];
	}
	public static void main(String[] args) {
		System.out.println(new Main1().minHP(new int[][]{{-2,-3,3},{-5,-10,1},{0,30,-5}}));
	}
}

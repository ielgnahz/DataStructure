package sdu.edu.Structure.Chart;

import java.util.Scanner;

public class test {
	public static int surfaceArea() {

		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		int[][] grid = new int[N][M];
		for(int i = 0;i <N;i++){
			for(int j = 0;j <M;j++){
				grid[i][j] = scan.nextInt();
			}
		}

		int res = 0;

		if(grid == null || grid.length == 0 || grid[0].length==0) {
			return res;
		}

		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				res+=grid[i][j]*6;

				if(grid[i][j] > 1) {
					res-= (grid[i][j]-1)*2;
				}

				if(i>=0 && i-1>=0) {
					res-= Math.min(grid[i][j], grid[i-1][j])*2;
				}

				if(j>=0 && j-1>=0) {
					res-= Math.min(grid[i][j], grid[i][j-1])*2;
				}
			}
		}

		return res;
	}

}

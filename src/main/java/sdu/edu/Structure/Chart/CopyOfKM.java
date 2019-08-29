package sdu.edu.Structure.Chart;

import java.util.Scanner;

//KM算法求二分图的最佳匹配
/*
 * 
什么是完美匹配
如果一个二分图，X部和Y部的顶点数相等，若存在一个匹配包含X部与Y部的所有顶点，则称为完美匹配。
换句话说：若二分图X部的每一个顶点都与Y中的一个顶点匹配，**并且**Y部中的每一个顶点也与X部中的一个顶点匹配，则该匹配为完美匹配。
什么是完备匹配
如果一个二分图，X部中的每一个顶点都与Y部中的一个顶点匹配，**或者**Y部中的每一个顶点也与X部中的一个顶点匹配，则该匹配为完备匹配。
什么是最佳匹配
带权二分图的权值最大的完备匹配称为最佳匹配。
 */
public class CopyOfKM {
	public int[][] matrix;
	public int[] link;
	public boolean[] usex;
	public boolean[] usey;
	public int[] wx;
	public int[] wy;
	public int[] slack;
	public int d, N;// n数量

	public void createGraph() {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		matrix = new int[N+1][N+1];
		link = new int[N+1];
		usex = new boolean[N+1];
		usey = new boolean[N+1];
		wx = new int[N+1];
		wy = new int[N+1];
		slack = new int[N+1];
		for (int i = 1; i <= N; i++) {
			link[i] = -1;
			for (int j = 1; j <= N; j++) {
				matrix[i][j] = scan.nextInt();
			}
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				wx[i] = Math.max(wx[i], matrix[i][j]);
			}
		}
		scan.close();
	}

	public boolean dfs(int x) {
		usex[x] = true;
		for (int y = 1; y <= N; y++) {
			if (matrix[x][y] > 0 && !usey[y]) {
				int t = wx[x] + wy[y] - matrix[x][y];
				if (t == 0) {
					usey[y] = true;
					if (link[y] == -1 || dfs(link[y])) {
						link[y] = x;
						return true;
					}
				}else if (slack[y] > t) {
					slack[y] = t;
				}
			}
		}
		return false;
	}
	public void km() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				slack[i] = Integer.MAX_VALUE;
			}
			while (true) {
				usex = new boolean[N+1];
				usey = new boolean[N+1];
				System.out.println(i);
				if (dfs(i)) {
					break;
				}
				d = Integer.MAX_VALUE;
				for (int j = 1; j <= N; j++) {
					if (!usey[j] && d > slack[j]) {
						d = slack[j];
					}
				}
				for (int j = 1; j <= N; j++) {
					if (usex[j]) {
						for (int k = 1; k <= N; k++) {
							if (matrix[j][k] > 0 && !usey[k]) {
								d = Math.min(d, wx[j] + wy[k] - matrix[j][k]);
							}
						}
					}
				}
				System.out.println(d);
				for (int j = 1; j <= N; j++) {
					if (usex[j]) {
						wx[j] -= d;
					}
					if (usey[j]) {
						wy[j] += d;
					}else {
						slack[j] -= d;
					}
				}
			}
		}
		int ans = 0;
		for (int i = 1; i <= N; i++) {
				ans += matrix[link[i]][i];
		}
		System.out.println(ans);
	}
	public static void main(String[] args) {
		CopyOfKM k = new CopyOfKM();
		k.createGraph();
		k.km();
	}
}

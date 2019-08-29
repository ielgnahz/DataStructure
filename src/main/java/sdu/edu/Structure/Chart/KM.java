package sdu.edu.Structure.Chart;

import java.util.Scanner;

//KM算法求二分图的最大权分配
public class KM {
	public int[][] matrix;
	public int[] link;
	public boolean[] usex;
	public boolean[] usey;
	public int[] wx;
	public int[] wy;
	public int min,n,m;//n左边数量　m右边数量
	public void createGraph(){
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入节点数");
		int mNum = scan.nextInt();
		m = mNum;
		n = mNum;
		matrix = new int[n][m];
		link = new int[m];
		usex = new boolean[n];
		usey = new boolean[m];
		wx = new int[n];
		wy = new int[m];
		System.out.println("请输入节点信息");
		for (int i = 0; i < n; i++) {
			link[i] = -1;
			for (int j = 0; j < m; j++) {
			int w = scan.nextInt();
			matrix[i][j] = w;
		}
		}
		for (int i = 0; i < n; i++) {
			wx[i] = matrix[i][0];
			for (int j = 0; j < m; j++) {
				wx[i] = Math.max(wx[i], matrix[i][j]);
			}
		}
		scan.close();
	}
	public boolean dfs(int x){
		usex[x] = true;
		for (int y = 0; y < m; y++) {
			if(!usey[y]){
				int t = wx[x] + wy[y] - matrix[x][y];
				if(t == 0){
					usey[y] = true;
					if(link[y] == -1 || dfs(link[y])){
						link[y] = x;
						return true;
					}
				}
			}
		}
		return false;
	}
	public void km(){
		for (int i = 0; i < n; i++) {
			while(true){
				usex = new boolean[n];
				usey = new boolean[m];
				min = Integer.MAX_VALUE;
				if(dfs(i)){
					break;
				}
				for (int j = 0; j < n; j++) {
					if(usex[j]){
						for (int k = 0; k < m; k++) {
							if(!usey[k]){
								min = Math.min(min, wx[j]+wy[k]-matrix[j][k]);
							}
						}
					}
				}
				for (int j = 0; j < n; j++) {
					if(usex[j]){
						wx[j]-=min;
					}
				}
				for (int j = 0; j < m; j++) {
					if(usey[j]){
						wy[j]+=min;
					}
				}
			}
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans += matrix[link[i]][i];
		}
		System.out.println(ans);
	}
	public static void main(String[] args) {
		KM k  = new KM();
		k.createGraph();
		k.km();
	}
}

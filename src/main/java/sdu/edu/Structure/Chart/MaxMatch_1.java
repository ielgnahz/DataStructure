package sdu.edu.Structure.Chart;

import java.util.ArrayList;
import java.util.Scanner;

//求有向无环图的最小路径覆盖
//= 顶点数　- 最大匹配数 
public class MaxMatch_1 {
	public ArrayList<Integer>[] nList;
	public int[] yList;
	public boolean[] vis;
	public int size;

	@SuppressWarnings("unchecked")
	public void createGraph(Scanner scan) {
		int m = scan.nextInt();
		size = m;
		nList = new ArrayList[size+1];
		yList = new int[size+1];
		for (int i = 1; i < m; i++) {
			nList[i] = new ArrayList<>();
		}
		int n = scan.nextInt();
		for (int k = 0; k < n; k++) {
			int i = scan.nextInt();
			int j = scan.nextInt();
			nList[i].add(j);
		}
	}

	public boolean dfs(int u) {
		for (int i = 0; i < nList[u].size(); i++) {
			int to = nList[u].get(i);
			if (!vis[to]) {
				vis[to] = true;
				if (yList[to] == 0 || dfs(yList[to])) {
					yList[to] = u;
					return true;
				}
			}
		}
		return false;
	}

	public void solve() {
		int ans = 0;
		for (int i = 1; i < size; i++) {
			vis = new boolean[size+1];
			if (dfs(i)) {
				ans++;
			}
		}
		System.out.println(size - ans);
	}

	public static void main(String[] args) {
		MaxMatch_1 mm = new MaxMatch_1();
		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt();
		while(m-- != 0){
			mm.createGraph(scan);
			mm.solve();
		}
		scan.close();
	}
}

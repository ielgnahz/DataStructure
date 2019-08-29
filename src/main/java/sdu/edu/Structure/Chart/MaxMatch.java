package sdu.edu.Structure.Chart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
 * 
输入节点数
8
请输入边数
8
请输入边的信息
0 5
0 4
1 4
1 6
2 5
2 7
3 5
3 6

4
 */
//匈牙利算法求二分图的最大匹配
public class MaxMatch {
	public ArrayList<Integer>[] nList;
	public HashMap<Integer, Integer> xMap;
	public HashMap<Integer, Integer> yMap;
	public boolean[] vis;
	public int size;
	
	@SuppressWarnings("unchecked")
	public void createGraph(){
		Scanner scan = new Scanner(System.in);
		System.out.println("输入节点数");
		int m = scan.nextInt();
		size = m;
		nList = new ArrayList[size];
		xMap = new HashMap<>();
		yMap = new HashMap<>();
		for (int i = 0; i < m; i++) {
			nList[i] = new ArrayList<>();
		}
		System.out.println("请输入边数");
		int n = scan.nextInt();
		System.out.println("请输入边的信息");
		for (int k = 0; k < n; k++) {
			int i = scan.nextInt();
			int j = scan.nextInt();
			nList[i].add(j);
			nList[j].add(i);
		}
//		提前设好的谁是x谁是y,根据实际情况改变
		for (int i = 0; i < 4; i++) {
			xMap.put(i, -1);
		}
		for (int i = 4; i < 8; i++) {
			yMap.put(i, -1);
		}
		scan.close();
	}
	public int maxMatch(){
		int ans = 0;
		for (int i = 0; i < xMap.size(); i++) {
			if(xMap.get(i) == -1){
				vis = new boolean[size];
				ans+=dfs(i)?1:0;
			}
		}
		return ans;
	}
	public boolean dfs(int u){
		for (int i = 0; i < nList[u].size(); i++) {
			int v = nList[u].get(i);
			if(!vis[v]){
				vis[v] = true;
				if(yMap.get(v)==-1 || dfs(yMap.get(v))){
					yMap.put(v, u);
					xMap.put(u, v);
					return true;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		MaxMatch mm = new MaxMatch();
		mm.createGraph();
		int ans = mm.maxMatch();
		System.out.println(ans);
	}
}

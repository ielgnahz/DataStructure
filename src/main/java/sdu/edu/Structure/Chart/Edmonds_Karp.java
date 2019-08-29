package sdu.edu.Structure.Chart;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//Edmonds_Karp求网络最大流
public class Edmonds_Karp {
	public static int EdmondsKarp(int start, int end, int[][] graph) {
		int m = graph.length;
		int n = graph[0].length;
		int[][] flow = new int[m][n];
		int[] pre = new int[m];
		int[] rest = new int[m];

		int maxflow = 0;

		Queue<Integer> queue = new LinkedList<Integer>();
		while (true) {
			Arrays.fill(rest, 0);
			rest[start] = Integer.MAX_VALUE;
			queue.add(start);
			while (!queue.isEmpty()) {
				int u = queue.poll();
				for (int v = 0; v <= end; v++) {
					if (rest[v] == 0 && graph[u][v] - flow[u][v] > 0) {
						pre[v] = u;
						rest[v] = Math.min(rest[u], graph[u][v] - flow[u][v]);
						queue.offer(v);
					}
				}
			}
			maxflow += rest[end];
			if (rest[end] == 0) {
				return maxflow;
			}
			for (int u = end; u != start; u = pre[u]) {
				flow[pre[u]][u] += rest[end];
				flow[u][pre[u]] -= rest[end];
				System.out.print(u+" ");
			}
			System.out.print(start + "  ");

			System.out.println("寻找至本次的流为： " + maxflow);
		}
	}
	public static void main(String[] args) {

		//输入一个图
		int [][] cap ={  {0,5,0,0,0},
					  	{0,0,6,0,1},
				        {0,0,0,5,2},
				        {0,0,0,0,1},
				        {0,0,0,0,0},
				        };//有向图的初始容量
		int max=EdmondsKarp(0, 4, cap);
		System.out.println(max);
		
	
	}
}

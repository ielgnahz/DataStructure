package sdu.edu.Structure.Chart;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 
 * 
输入节点个数
7
输入边个数
11
输入边
0 1 7
0 3 5
1 2 8
1 3 9
1 4 7
2 4 5
3 4 15
3 5 6
4 5 8
4 6 9
5 6 11
 */
//Kruskal求最小生成树
public class Kruskal {

	class Edge implements Comparable<Edge> {
		int begin;
		int end;
		int weight;
		public Edge(int begin,int end,int weight){
			this.begin = begin;
			this.end = end;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}

	public int[][] matrix;
	public Edge[] edges;

	public void createGraph() {
		Scanner scan = new Scanner(System.in);
		System.out.println("输入节点个数");
		int m = scan.nextInt();
		System.out.println("输入边个数");
		int n = scan.nextInt();
		matrix = new int[m][m];
		edges = new Edge[n];
		int l = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				matrix[i][j] = Integer.MAX_VALUE;
				if (i == j) {
					matrix[i][j] = 0;
				}
			}
		}
		System.out.println("输入边");
		for (int k = 0; k < n; k++) {
			int i = scan.nextInt();
			int j = scan.nextInt();
			int w = scan.nextInt();
			matrix[i][j] = w;
			matrix[j][i] = w;
			edges[l] = new Edge(i,j,w);
			l++;
		}
		Arrays.sort(edges);
		scan.close();

	}

	public int findFather(int target, int[] edges) {
		while (edges[target] > 0) {
			target = edges[target];
		}
		return target;
	}

	public void kruskal() {
		int[] parent = new int[matrix.length];
		for (int i = 0; i < edges.length; i++) {
			Edge edge = edges[i];
			int beginroot = findFather(edge.begin, parent);
			int endroot = findFather(edge.end, parent);
			if (beginroot != endroot) {
				System.out.println(String.format("(%d,%d)->%d", edge.begin,
						edge.end, edge.weight));
				parent[beginroot] = endroot;
			}
		}
	}
	public static void main(String[] args) {
		Kruskal k = new Kruskal();
		k.createGraph();
		k.kruskal();
		
	}

}

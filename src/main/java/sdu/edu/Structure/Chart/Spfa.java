package sdu.edu.Structure.Chart;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 
请输入定点数
5
请输入起点下标
0
请输入边总数
8
请输入具体的边的数据
0 1 -1
0 2 4
1 2 3
1 3 2
1 4 2
3 2 5
3 1 1
4 3 -3
0 -1 2 -2 1 
 */
/*
 * 
请输入定点数
6
请输入起点下标
1
请输入边总数
18
请输入具体的边的数据
0 1 6
0 2 3
1 2 2
1 3 5
2 3 3
2 4 4
3 4 2
3 5 3
4 5 5
1 0 6
2 0 3
2 1 2
3 1 5
3 2 3
4 2 4
4 3 2
5 3 3
5 4 5
5 0 2 5 6 8 
 */
//SPFA求带负权的最短路径
public class Spfa {
	class Edge{
		int begin;
		int end;
		int weight;
		public Edge(int begin,int end,int weight){
			this.begin = begin;
			this.end = end;
			this.weight = weight;
		}
	}
	public int[] result;
	public Edge[] edge;
	public int[] num;
	public void createEdge(){
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入定点数");
		int m = scan.nextInt();
		System.out.println("请输入起点下标");
		int s = scan.nextInt();
		System.out.println("请输入边总数");
		int n = scan.nextInt();
		edge = new Edge[n];
		result = new int[m];
		num = new int[m];
		System.out.println("请输入具体的边的数据");
		for (int i = 0; i < n; i++) {
			int begin = scan.nextInt();
			int end = scan.nextInt();
			int weight = scan.nextInt();
			edge[i] = new Edge(begin, end, weight);
		}
		if(getShortPath(m, s)){
			for (int i = 0; i < result.length; i++) {
				System.out.print(result[i] + " ");
			}
		}else{
			System.out.println("含有负环");
		}
		scan.close();
	}
	public boolean getShortPath(int m,int s){
		Queue<Integer> que = new LinkedList<>();
		for (int i = 0; i < result.length; i++) {
			result[i] = Integer.MAX_VALUE;
		}
		result[s] = 0;
		que.offer(s);
		while(!que.isEmpty()){
			int node = que.poll();
			for (int i = 0; i < edge.length; i++) {
				if(node == edge[i].begin && result[edge[i].end] > result[edge[i].begin] + edge[i].weight){
					result[edge[i].end] = result[edge[i].begin] + edge[i].weight;
					if(!que.contains(edge[i].end)){
						que.add(edge[i].end);
						num[edge[i].end]++;
						if(num[edge[i].end] > m){
							return false;
						}
					}
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Spfa s = new Spfa();
		s.createEdge();
		
	}
}

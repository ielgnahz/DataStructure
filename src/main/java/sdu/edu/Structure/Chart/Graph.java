package sdu.edu.Structure.Chart;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//深度优先遍历和广度优先遍历
public class Graph {
	public int size;
	public int[][] matrix;
	public int MAX_WEIGHT = Integer.MAX_VALUE;
	public boolean[] vis;
	
	
	private void createGraph() {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入节点数：");
		int m = scan.nextInt();
		System.out.println("请输入边数");
		int n = scan.nextInt();
		System.out.println("请输入边的信息");
		size = m;
		matrix = new int[m][m];
		vis = new boolean[m];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				matrix[i][j] = MAX_WEIGHT;
			}
			matrix[i][i] = 0;
		}
		for (int k = 0; k < n; k++) {
			int i = scan.nextInt();
			int j = scan.nextInt();
			int w = scan.nextInt();
			matrix[i][j] = w;
			matrix[j][i] = w;
		}
		scan.close();
	}
	public void DFS(){
		for (int i = 0; i < matrix.length; i++) {
			if(!vis[i]){
				System.out.println("访问到"+i+"个节点");
				depthFirstSearch(i);
			}
		}
	}
	public void depthFirstSearch(int index){
		vis[index] = true;
		for (int i = 0; i < size; i++) {
			if(!vis[i] && matrix[index][i] != MAX_WEIGHT){
				System.out.println("访问到"+i+"个节点");
				depthFirstSearch(i);
			}
		}
	}
	public void BFS(){
		for (int i = 0; i < size; i++) {
			if(!vis[i]){
				broadFirstSearch(i);
			}
		}
	}
	
	public void broadFirstSearch(int index){
		vis[index] = true;
		Queue<Integer> que = new LinkedList<>();
		que.offer(index);
		int k = 0;
		while(!que.isEmpty()){
			k = que.poll();
			System.out.println("访问到第：" + k + "顶点");
			for (int i = 0; i < size; i++) {
				if(!vis[i] && matrix[k][i] != MAX_WEIGHT){
					que.offer(i);
					vis[i] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Graph g = new Graph();
		g.createGraph();
		g.BFS();
	}
}

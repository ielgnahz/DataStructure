package sdu.edu.Structure.Chart;

import java.util.Scanner;
/*
 * 
编号从１开始(有向图)
请输入节点数
6
请输入边数
8
请输入边的详细信息
0 2 10
0 4 30
0 5 100
1 2 5
2 3 50
3 5 10
4 5 60
4 3 20
v0-->v0=0
v0-->v2-->v1=15
v0-->v2=10
v0-->v4-->v3=50
v0-->v4=30
v0-->v4-->v3-->v5=60

请输入节点数(无向图)
9
请输入边数
15
请输入边的详细信息
0 1 1
0 2 5
1 2 3
1 3 7
1 4 5
2 4 1
2 5 7
3 4 2
3 6 3
4 6 6
4 7 9
4 5 3
5 7 5
6 7 2
6 8 7
v0-->v0=0
v0-->v1=1
v0-->v1-->v2=4
v0-->v1-->v2-->v4-->v3=7
v0-->v1-->v2-->v4=5
v0-->v1-->v2-->v4-->v5=8
v0-->v1-->v2-->v4-->v3-->v6=10
v0-->v1-->v2-->v4-->v3-->v6-->v7=12
v0-->v1-->v2-->v4-->v3-->v6-->v7-->v8=16
 */

public class Dijkstra {
	public int[][] matrix;//节点到其他节点的距离
	public boolean[] vis;//当前是否访问过该节点
	public int[] preNode;//前一个节点
	public int[] mindist;//0节点到其他节点的距离
	
	public void createGraph(){
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入节点数");
		int m = scan.nextInt();
		System.out.println("请输入边数");
		int n = scan.nextInt();
		System.out.println("请输入边的详细信息");
		matrix = new int[m][m];
		vis = new boolean[m];
		preNode = new int[m];
		mindist = new int[m];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				matrix[i][j] = Integer.MAX_VALUE;
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
//		for (int i = 0; i < matrix.length; i++) {
//			for (int j = 0; j < matrix.length; j++) {
//				System.out.print(matrix[i][j] +" ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		scan.close();
	}
	public void dijkstra(int vs){
		int minId = 0;
		int minWeight = 0;
		for (int i = 0; i < mindist.length; i++) {
			preNode[i] = 0;
			mindist[i] = matrix[0][i];
		}
		vis[vs] = true;
		for (int i = 1; i < matrix.length; i++) {
			minId = 0;
			minWeight = Integer.MAX_VALUE;
//			for (int l = 1; l < mindist.length; l++) {
//				System.out.print(mindist[l]+" ");
//			}
//			System.out.println();
			for (int j = 1; j < mindist.length; j++) {
				if(!vis[j] && minWeight > mindist[j]){
					minId = j;
					minWeight = mindist[j];
				}
			}
			vis[minId] = true;
			for (int j = 1; j < matrix.length; j++) {
				if(!vis[j] && matrix[minId][j] != Integer.MAX_VALUE && mindist[j] > matrix[minId][j] + minWeight){
					mindist[j] = matrix[minId][j] + minWeight;
					preNode[j] = minId;
				} 
			}
		}

		for (int i = 0; i < preNode.length; i++) {
			int si = i;
			String str = "v"+si;
			while(preNode[si] != vs){
				str="v"+preNode[si]+"-->"+str;
				si = preNode[si];
			}
			System.out.println("v"+vs+"-->"+str+"="+mindist[i]);
		}
	}
	public static void main(String[] args) {
		Dijkstra d = new Dijkstra();
		d.createGraph();
		d.dijkstra(0);
	}
}

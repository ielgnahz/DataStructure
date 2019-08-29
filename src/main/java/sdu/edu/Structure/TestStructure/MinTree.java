package sdu.edu.Structure.TestStructure;

import java.util.Scanner;
/*
 * 
9
14
0 1 10
0 5 11
1 2 18
1 6 16
1 8 12
2 3 22
2 8 8
3 4 20
3 7 16
3 8 21
4 5 26
4 7 7
5 6 17
6 7 19
 */

public class MinTree {
	public int[][] matrix;
	public int size;
	public int MAX_WEIGHT = Integer.MAX_VALUE;
	
	public void prim(){
		int[] tmpWeight = new int[size];
		int minId = 0;
		int minWeight = 0;
		int sum = 0;
		for (int i = 0; i < size; i++) {
			tmpWeight[i] = matrix[0][i];
		}
		System.out.println("从节点0开始");
		for (int i = 1; i < size; i++) {
			minId = 0;
			minWeight = MAX_WEIGHT;
			for (int j = 0; j < size; j++) {
				if(tmpWeight[j] > 0 && tmpWeight[j] < minWeight){
					minWeight = tmpWeight[j];
					minId = j;
				}
			}
			System.out.println("连接到"+minId+"权值为"+minWeight);
			sum += minWeight;
			for (int j = 1; j < size; j++) {
				if(tmpWeight[j] != 0 && tmpWeight[j] > matrix[minId][j]){
					tmpWeight[j] = matrix[minId][j];
				}
			}
		}
		System.out.println("总权值为"+sum);
	}

	private void createGraph(int index) {
		Scanner scan = new Scanner(System.in);
		System.out.println("输入节点数");
		int m = scan.nextInt();
		size = m;
		System.out.println("输入边数");
		int n = scan.nextInt();
		int[][] matri = new int[m][m];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				matri[i][j] = Integer.MAX_VALUE;
				if(i == j){
					matri[i][j] = 0;
				}
			}
		}
		System.out.println("输入边");
		for (int k = 0; k < n; k++) {
			int i = scan.nextInt();
			int j = scan.nextInt();
			int v = scan.nextInt();
			matri[i][j] = v;
			matri[j][i] = v;
		}
		matrix = matri;
		// for (int i = 0; i < matri.length; i++) {
		// for (int j = 0; j < matri[0].length; j++) {
		// System.out.print(matrix[i][j]+" ");
		// }
		// System.out.println();
		// }
		scan.close();
	}
	public static void main(String[] args) {
		MinTree mt = new MinTree();
		mt.createGraph(9);
		mt.prim();
	}
}

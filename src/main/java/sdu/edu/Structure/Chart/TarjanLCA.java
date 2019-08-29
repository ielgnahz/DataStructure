package sdu.edu.Structure.Chart;

import java.util.ArrayList;
import java.util.Scanner;

//Tajan＋并查集　求两个节点的最近公共祖先
public class TarjanLCA {
	class Node {
		int to;
		int pos;

		public Node(int to, int pos) {
			this.to = to;
			this.pos = pos;
		}
	}

	public ArrayList<Node>[] nList;
	public ArrayList<Node>[] qList;
	public int[] father;
	public boolean[] vis;
	public int[] ans;

	public int findFather(int node) {
		int fath = father[node];
		if (fath != node) {
			fath = findFather(fath);
		}
		return fath;
	}

	@SuppressWarnings("unchecked")
	public void createGraph() {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入节点数");
		int m = scan.nextInt();
		nList = new ArrayList[m];
		qList = new ArrayList[m];
		father = new int[m];
		vis = new boolean[m];
		for (int i = 0; i < m; i++) {
			nList[i] = new ArrayList<>();
			qList[i] = new ArrayList<>();
			father[i] = i;
		}
		System.out.println("请输入边数");
		int n = scan.nextInt();
		System.out.println("请输入边的信息");
		for (int k = 0; k < n; k++) {
			int i = scan.nextInt();
			int j = scan.nextInt();
			// int w = scan.nextInt();
			nList[i].add(new Node(j, 0));
		}
		System.out.println("请输入所求最近公共祖先数");
		int l = scan.nextInt();
		ans = new int[l];
		System.out.println("请输入公共祖先子节点");
		for (int k = 0; k < l; k++) {
			int i = scan.nextInt();
			int j = scan.nextInt();
			// int w = scan.nextInt();
			qList[i].add(new Node(j, k));
			qList[j].add(new Node(i, k));
		}
		scan.close();
	}

	public void tarjan(int i) {
		for (int j = 0; j < nList[i].size(); j++) {
			int to = nList[i].get(j).to;
			tarjan(to);
			father[to] = i;
		}
		vis[i] = true;
		for (int k = 0; k < qList[i].size(); k++) {
			Node node = qList[i].get(k);
			if (vis[node.to]) {
				int f = findFather(node.to);
				ans[node.pos] = f;
			}
		}
	}

	public static void main(String[] args) {
		TarjanLCA tj = new TarjanLCA();
		tj.createGraph();
		tj.tarjan(0);
		int[] ans = tj.ans;
//		 int[] father = tj.father;
		System.out.println("ans结果为:");
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
//		 System.out.println("\nfather结果为");
//		 for (int i = 0; i < father.length; i++) {
//		 System.out.print(father[i]+" ");
//		 }
		// System.out.println("\nqList结果为");
		// ArrayList<Node>[] nList = tj.nList;
		// for (int i = 0; i < nList.length; i++) {
		// for (int j = 0; j < nList[i].size(); j++) {
		// System.out.print(i+"->"+nList[i].get(j).to+" ");
		// }
		// System.out.println();
		// }
	}
}
/*
 * 
请输入节点数
12
请输入边数
11
请输入边的信息
0 1
0 2
0 3
1 4
1 5
2 6
2 7
7 8
7 9
8 10
9 11
请输入所求最近公共祖先数
4
请输入公共祖先子节点
4 5
4 6
6 10
10 11

 */
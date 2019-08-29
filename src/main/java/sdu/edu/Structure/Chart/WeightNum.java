package sdu.edu.Structure.Chart;

import java.util.Scanner;

//带权并查集
public class WeightNum {
	
	public int[] father;
	public int[] rank;
	public int findFather(int x){
		if(x == father[x]){
			return x;
		}
		int f = father[x];
		father[x] = findFather(f);
		rank[x] += rank[f];
		return father[x];
	}
	public boolean merge(int x,int y,int d){
		int fx = findFather(x);
		int fy = findFather(y);
		if(fx == fy){
			if(rank[y] - rank[x] != d){
				return false;
			}
		}
		father[fy] = fx;
		rank[fy] = rank[x] - rank[y] +d ;
		return true;
	}
	
	public void Go(){

		Scanner scan = new Scanner(System.in);
		int w = scan.nextInt();
		while(w-- != 0){
			int m = scan.nextInt();
			int n = scan.nextInt();
			boolean flag = true;
			father = new int[m+1];
			rank = new int[m+1];
			for (int i = 0; i < father.length; i++) {
				father[i] = i;
			}
			for (int i = 0; i < n; i++) {
				int x = scan.nextInt();
				int y = scan.nextInt();
				int d = scan.nextInt();
				if(!merge(x, y, d)){
					flag = false;
				}
			}
			if(flag){
				System.out.println("Bessie’s eyes are good");
			}else{
				System.out.println("Bessie is blind.");
			}
		}
		scan.close();
	}
	
	public static void main(String[] args) {
		WeightNum wn = new WeightNum();
		wn.Go();
	}
	
}
/*
2
3 3 
1 3 10
2 3 5
1 2 5
4 3
1 4 00
3 4 50
1 3 100
*/

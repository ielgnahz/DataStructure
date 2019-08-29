package sdu.edu.Structure.FifthStructure.getNum;

public class Main {
	public int getNum1(int n){
		if(n < 1){
			return 0;
		}
		return process1(1, n);
	}
	public int process1(int l,int n){
		if(l == n){
			return 1;
		}
		if(l == n-1){
			return 2;
		}
		return process1(l+1, n)+process1(l+2, n);
	}
	public int getNum2(int n){
		if(n < 1){
			return 0;
		}
		if(n == 2 || n == 1){
			return n;
		}
		int cur = 2;
		int next = 1;
		int tmp = 0;
		for(int i = n-2;i>0;i--){
			tmp = cur;
			cur+=  next;
			next = tmp;
		}
		return cur;
	}
	public int getNum3(int n){
		if(n < 1){
			return 0;
		}
		if(n == 2 || n == 1){
			return n;
		}
		int[][] base = {{1,1},{1,0}};
		int[][]res = matrixPower(base, n-2);
		return 2*res[0][0] + res[1][0];
	}
	public int[][] matrixPower(int[][] m,int p){
		int[][] tmp = new int[m.length][m[0].length];
		int[][] res = new int[m.length][m[0].length];
		for(int i = 0;i<tmp.length;i++){
			res[i][i] = 1;
		}
		tmp = m;
		for(;p!=0;p>>=1){
			if((p&1)!=0){
				res = muliMatrix(tmp, res);
			}
			tmp = muliMatrix(tmp, tmp);
		}
		return res;
	}
	public int[][] muliMatrix(int[][] m,int[][] n){
		int[][] k = new int[m.length][n[0].length];
		for(int i= 0;i<m.length;i++){
			for(int j = 0;j<n[0].length;j++){
				for(int q = 0;q<m[0].length;q++){
					k[i][j]+=m[i][q]*n[q][j];
				}
			}
		}
		return k;
	}
	public static void main(String[] args){
		System.out.println(new Main().getNum3(6));
	}
	
}

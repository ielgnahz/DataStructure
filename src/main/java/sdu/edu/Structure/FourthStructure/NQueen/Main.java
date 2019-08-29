package sdu.edu.Structure.FourthStructure.NQueen;

public class Main {
	public int num(int n){
		int[] record=  new int[n];
		return process(0,record,n);
	}
	public int process(int i,int[] record,int n){
		if(i == n){
			return 1;
		}
		int res = 0;
		for(int j = 0;j<n;j++){
			if(isValid(i,j,record)){
				record[i] = j;
				res+=process(i+1, record, n);
			}
		}
		return res;
	}
	public boolean isValid(int i,int j,int[] record){
		for(int k =0;k<i;k++){
			if(j == record[k] || Math.abs(i-k) == Math.abs(j-record[k])){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(new Main().num1(8));
	}
	
	public int num1(int n){
		if(n < 1 || n>32){
			return 0;
		}
		int upperLim = n == 32?-1:(1<<n)-1;
		return process2(upperLim,0,0,0);
	}
	
	public int process2(int upperLim,int colLim,int leftDiaLim,int rightDiaLim){
		if(upperLim == colLim){
			return 1;
		}
		int pos = 0;
		int mostRightOne = 0;
		pos = upperLim & (~(colLim | leftDiaLim | rightDiaLim));
		int res = 0;
		while(pos != 0){
			mostRightOne = pos&(~pos+1);
			pos = pos - mostRightOne;
			res+= process2(upperLim, colLim | mostRightOne, (leftDiaLim | mostRightOne)<<1, (rightDiaLim| mostRightOne)>>1);
		}
		return res;
	}
	
}

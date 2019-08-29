package sdu.edu.Structure.FourthStructure.NQueen;

public class Main1 {
	public int NQueen(int n){
		int record[] = new int[n];
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
				res+= process(i+1, record, n);
			}
		}
		return res;
	}
	public boolean isValid(int i,int j,int[] record){
		for(int k = 0;k<i;k++){
			if(j == record[k] ||Math.abs(i - k) == Math.abs(j - record[k]) ){
				return false;
			}
		}
		return true;
	}
	
	public int NQueen1(int n){
		if(n > 32 || n < 1){
			return -1;
		}
		int upperLim = n == 32?-1:(1<<n)-1;
		return process1(upperLim,0,0,0);
	}
	/**
	 * 
	 * @param upperLim 		1代表可放 	0代表不可放
	 * @param curLim		1代表放了		0代表没放
	 * @param leftDiaLim	同上
	 * @param rightDiaLim	同上
	 * pos			代表能放的地方		1代表能放		0代表不能放
	 * moreRight		代表最右边的能放的地方
	 * @return
	 */
	
	public int process1(int upperLim,int curLim,int leftDiaLim,int rightDiaLim){
		if(upperLim == curLim){
			return 1;
		}
		int pos = upperLim & (~(curLim | leftDiaLim | rightDiaLim));
		int moreRight = 0;
		int res = 0;
		while(pos != 0){
			moreRight = pos & (~pos + 1);
			res+= process1(upperLim, curLim | moreRight, (leftDiaLim | moreRight)<<1, (rightDiaLim | moreRight)>>1 );
			pos = pos - moreRight;
		}
		return res;
	}
	public static void main(String[] args) {
		System.out.println(new Main1().NQueen1(13));
	}
	
}

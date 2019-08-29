package sdu.edu.Structure.EighthStructure.printMatrixZigZag;

public class Main1 {
	public void printMatrixZigZag(int[][] arr){
		int tR = 0;
		int tC = 0;
		int dR = 0;
		int dC = 0;
		int endR = arr.length-1;
		int endC = arr[0].length-1;
		boolean flag = false;
		while(tR != endR + 1){
			printLevel(arr,tR,tC,dR,dC,flag);
			tR = tC == endC?tR+1:tR;
			tC = tC == endC?tC:tC+1;
			dC = dR == endR?dC+1:dC;
			dR = dR == endR?dR:dR+1;
			flag = !flag;
		}
	}
	public void printLevel(int[][] arr,int tR,int tC,int dR,int dC,boolean flag){
		if(flag){
			while(tR != dR + 1 ){
				System.out.print(arr[tR][tC]+" ");
				tR++;
				tC--;
			}
		}else{
			while(dR != tR-1){
				System.out.print(arr[dR][dC]+" ");
				dR--;
				dC++;
			}
		}
	}
	public static void main(String[] args) {
		new Main1().printMatrixZigZag(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}});
	}
}


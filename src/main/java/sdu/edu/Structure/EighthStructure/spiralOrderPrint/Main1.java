package sdu.edu.Structure.EighthStructure.spiralOrderPrint;

public class Main1 {
	public void spialOrderPrint(int[][] arr){
		int tR = 0;
		int tC = 0;
		int dR = arr.length-1;
		int dC = arr[0].length-1;
		while(tR <= dR && tC <= dC){
			printEdge(arr,tR++,tC++,dR--,dC--);
		}
	}
	public void printEdge(int[][] arr,int tR,int tC,int dR,int dC){
		if(tR == dR){
			for (int i = tC; i <= dC; i++) {
				System.out.print(arr[tR][i]+" ");
			}
		}else if(tC == dC){
			for (int i = tR; i <= dR; i++) {
				System.out.print(arr[i][tC]+" ");
			}
		}else{
			int curR = tR;
			int curC = tC;
			while(curC < dC){
				System.out.print(arr[tR][curC++]+" ");
			}
			while(curR < dR){
				System.out.print(arr[curR++][dC]+" ");
			}
			while(curC > tC){
				System.out.print(arr[dR][curC--]+" ");
			}
			while(curR > tR){
				System.out.print(arr[curR--][tC]+" ");
			}
		}
	}
	public static void main(String[] args) {
		new Main1().spialOrderPrint(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}});
	}
}

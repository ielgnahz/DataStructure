package sdu.edu.Structure.EighthStructure.isContains;

public class Main {
	public boolean isContains(int[][] arr,int K){
		int row = 0;
		int col = arr[0].length-1;
		while(row < arr.length && col > -1){
			if(arr[row][col] == K){
				return true;
			}else if(arr[row][col] > K){
				col--;
			}else{
				row++;
			}
		}
		return false;
	}
}

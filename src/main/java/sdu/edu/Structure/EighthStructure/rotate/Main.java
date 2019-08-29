package sdu.edu.Structure.EighthStructure.rotate;

public class Main {
	public void rotate(int[][] matrix){
		int tR = 0;
		int tC = 0;
		int dR = matrix.length-1;
		int dC = matrix[0].length-1;
		while(tR < dR){
			rotateEdge(matrix,tR++,tC++,dR--,dC--);
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	public void rotateEdge(int[][] m,int tR,int tC,int dR,int dC){
		int times = dR - tR;
		int tmp = 0;
		for (int i = 0; i < times; i++) {
			tmp = m[tR][tC+i];
			m[tR][tC+i] = m[dR-i][tC];
			m[dR-i][tC] = m[dR][dC-i];
			m[dR][dC-i] = m[tR+i][dC];
			m[tR+i][dC] = tmp;
			
//			m[tR][tC+i] = m[tR+i][dC];
//			m[tR+i][dC] = m[dR][dC-i];
//			m[dR][dC-i] = m[dR-i][tC];
//			m[dR-i][tC] = tmp;
		}
	}
	public static void main(String[] args) {
		new Main().rotate(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}});
	}
}

package sdu.edu.Structure.EighthStructure.spiralOrderPrint;

public class Main {
	public void spiralOrder(int[][] matrix) {
		int tR = 0;
		int tC = 0;
		int dR = matrix.length - 1;
		int dC = matrix[0].length - 1;
		while (tR <= dR && tC <= dC) {
			printEdge(matrix, tR++, tC++, dR--, dC--);
		}
	}

	public void printEdge(int[][] matrix, int tR, int tC, int dR, int dC) {
		if (tR == dR) {
			for (int i = 0; i <= dC; i++) {
				System.out.print(matrix[dR][i] + " ");
			}
		} else if (tC == dC) {
			for (int j = 0; j <= dR; j++) {
				System.out.print(matrix[j][tC] + " ");
			}
		} else {
			int curR = tR;
			int curC = tC;
			while (curC != dC) {
				System.out.print(matrix[tR][curC] + " ");
				curC++;
			}
			while (curR != dR) {
				System.out.print(matrix[curR][dC] + " ");
				curR++;
			}
			while (curC != tC) {
				System.out.print(matrix[dR][curC] + " ");
				curC--;
			}
			while (curR != tR) {
				System.out.print(matrix[curR][tC] + " ");
				curR--;
			}
		}

	}

	public static void main(String[] args) {
		new Main().spiralOrder(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 },
				{ 9, 10, 11, 12 }, { 13, 14, 15, 16 } });
	}
}

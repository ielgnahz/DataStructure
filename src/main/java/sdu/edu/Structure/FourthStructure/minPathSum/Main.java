package sdu.edu.Structure.FourthStructure.minPathSum;

public class Main {
	public int minPathSum(int[][] m) {
		if (m == null) {
			return 0;
		}
		int[][] res = new int[m.length][m[0].length];
		for (int i = 1; i < res.length; i++) {
			res[i][0] = m[i - 1][0] + m[i][0];
		}
		for (int i = 1; i < res[0].length; i++) {
			res[0][i] = m[0][i - 1] + m[0][i];
		}
		for (int i = 1; i < res.length; i++) {
			for (int j = 1; j < res[0].length; j++) {
				res[i][j] = Math.min(res[i - 1][j], res[i][j - 1]) + m[i][j];
			}
		}
		return res[res.length - 1][res[0].length - 1];
	}

	public int minPathSum1(int[][] m) {
		if (m == null) {
			return 0;
		}
		int length = Math.min(m.length, m[0].length);
		int end = Math.max(m.length, m[0].length);
		int[] res = new int[length];
		boolean flag = end == m.length;
		res[0] = m[0][0];
		for (int i = 1; i < end; i++) {
			res[i] = res[i-1]+(flag ? m[0][i] : m[i][0]);
			System.out.print(res[i]+" ");
		}
		System.out.println();
		for (int i = 1; i < length; i++) {
			res[0] += (flag ? m[i][0] : m[0][i]);
			for (int j = 1; j < end; j++) {
				res[j] = Math.min(res[j - 1], res[j]) + m[i][j];
				System.out.print(res[j] + " ");
			}
			System.out.println();
		}
		// for (int i = 1; i < res.length; i++) {
		// System.out.print(res[i]+" ");
		// }
		return res[res.length - 1];
	}

	public static void main(String[] args) {
		int[][] m = { { 1, 3, 5, 9 }, { 8, 1, 3, 4 }, { 5, 0, 6, 1 },
				{ 8, 8, 4, 0 } };
		System.out.println(new Main().minPathSum1(m));
	}
}

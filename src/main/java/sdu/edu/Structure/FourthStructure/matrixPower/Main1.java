package sdu.edu.Structure.FourthStructure.matrixPower;

public class Main1 {
	public int f1(int n) {
		if (n == 1 || n == 2) {
			return 1;
		}
		return f1(n - 1) + f1(n - 2);
	}

	public int f2(int n) {
		int pre = 1;
		int res = 1;
		int tmp = 0;
		if (n == 1 || n == 2) {
			return 1;
		}
		for (int i = 3; i <= n; i++) {
			tmp = res;
			res = res + pre;
			pre = tmp;
		}
		return res;
	}

	public int f3(int n) {
		if (n == 1 || n == 2) {
			return 1;
		}
		int[][] base = { { 1, 1 }, { 1, 0 } };
		int[][] res = matrixPower(base, n - 2);
		return res[0][0] + res[0][1];
	}

	public int[][] matrixPower(int[][] base, int p) {
		int[][] tmp = base;
		int[][] res = new int[base.length][base[0].length];
		for (; p != 0; p >>= 1) {
			if ((p & 1) != 0) {
				res = muliMatrix(res, tmp);
			}
			tmp = muliMatrix(tmp, tmp);
		}
		return res;
	}

	public int q1(int n) {
		if (n == 1 || n == 2) {
			return n;
		}
		return q1(n - 1) + q1(n - 2);
	}

	public int q2(int n) {
		if (n == 1 || n == 2) {
			return n;
		}
		int pre = 1;
		int res = 2;
		int tmp = 0;
		for (int i = 3; i <= n; i++) {
			tmp = res;
			res = res + pre;
			pre = tmp;
		}
		return res;
	}

	public int q3(int n) {
		if (n == 1 || n == 2) {
			return n;
		}
		int[][] base = { { 1, 1 }, { 1, 0 } };
		int[][] res = matrixPower(base, n - 2);
		return 2 * res[0][0] + res[1][0];
	}

	public int u1(int n) {
		if (n == 1 || n == 2 || n == 3) {
			return n;
		}
		return u1(n - 1) + u1(n - 3);
	}

	public int u2(int n) {
		if (n == 1 || n == 2 || n == 3) {
			return n;
		}
		int p1 = 1;
		int p2 = 2;
		int p3 = 3;
		int pre = 0;
		for (int i = 4; i <= n; i++) {
			pre = p3;
			p3 += p1;
			p1 = p2;
			p2 = pre;
		}
		return p3;
	}

	public int u3(int n) {
		if (n == 1 || n == 2 || n == 3) {
			return n;
		}
		int[][] base = { { 1, 1, 0 }, { 0, 0, 1 }, { 1, 0, 0 } };
		int[][] res = matrixPower(base, n - 2);
		return 3 * res[0][0] + 2 * res[1][0] + res[2][0];
	}

	public int[][] muliMatrix(int[][] m1, int[][] m2) {
		int[][] res = new int[m1.length][m2[0].length];
		for (int i = 0; i < m2[0].length; i++) {
			for (int j = 0; j < m1.length; j++) {
				for (int m = 0; m < m1[i].length; m++) {
					res[i][j] += m1[i][m] * m2[m][j];
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(new Main1().u2(6));
	}
}

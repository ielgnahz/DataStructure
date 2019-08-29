package sdu.edu.Structure.FourthStructure.matrixPower;

public class Main {
	public int f1(int n) {
		if (n == 2 || n == 1) {
			return 1;
		}
		return f1(n - 1) + f1(n - 2);
	}

	public int f2(int n) {
		int pre = 1;
		int now = 1;
		int next = 0;
		for (int i = 2; i < n; i++) {
			next = now;
			now = now + pre;
			pre = next;
		}
		return now;
	}

	public int f3(int n) {
		if (n == 1 || n == 2) {
			return 1;
		}
		int[][] m = { { 1, 1 }, { 1, 0 } };
		int[][] res = maxtrixPower(m, n - 2);
		return res[0][0] + res[0][1];

	}

	public int s1(int n) {
		if (n == 1 || n == 2) {
			return n;
		}
		return s1(n - 1) + s1(n - 2);
	}

	public int s2(int n) {
		int pre = 1;
		int now = 2;
		int next = 0;
		for (int i = 2; i < n; i++) {
			next = pre + now;
			pre = now;
			now = next;
		}
		return now;
	}

	public int s3(int n) {
		if (n == 1 || n == 2) {
			return n;
		}
		int[][] base = { { 1, 1, }, { 1, 0 } };
		int[][] res = maxtrixPower(base, n - 2);
		return 2 * res[0][0] + res[1][0];
	}

	public int c1(int n) {
		if (n == 1 || n == 2 || n == 3) {
			return n;
		}
		return c1(n - 1) + c1(n - 3);
	}

	public int c2(int n) {
		if (n == 1 || n == 2 || n == 3) {
			return n;
		}
		int prepre = 1;
		int pre = 2;
		int now = 3;
		int next = 0;
		for (int i = 3; i < n; i++) {
			next = prepre + now;
			prepre = pre;
			pre = now;
			now = next;
		}
		return now;
	}
	public int c3(int n) {
		if (n == 1 || n == 2 || n == 3) {
			return n;
		}
		int[][] base = { { 1, 1, 0 }, { 0, 0, 1 }, { 1, 0, 0 } };
		int[][] res = maxtrixPower(base, n - 3);
		return 3 * res[0][0] + 2 * res[1][0] + res[2][0];
	}

	public int[][] maxtrixPower(int[][] m, int p) {
		int[][] res = new int[m.length][m[0].length];
		for (int i = 0; i < res.length; i++) {
			res[i][i] = 1;
		}
		int[][] tmp = m;
		for (; p != 0; p >>= 1) {
			if ((p & 1) != 0) {
				res = muliMatrix(res, tmp);
			}
			tmp = muliMatrix(tmp, tmp);
		}
		return res;
	}

	public int[][] muliMatrix(int[][] m1, int[][] m2) {
		int[][] res = new int[m1.length][m2[0].length];
		for (int i = 0; i < m2[0].length; i++) {
			for (int j = 0; j < m1.length; j++) {
				for (int k = 0; k < m1[0].length; k++) {
					res[i][j] += m1[i][k] * m2[k][j];
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(new Main().f1(3));
	}
}

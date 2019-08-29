package sdu.edu.Structure.EighthStructure.minPathValue;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public int minPathValue(int[][] m) {
		int[][] map = new int[m.length][m[0].length];
		int r = 0;
		int c = 0;
		Queue<Integer> rQ = new LinkedList<Integer>();
		Queue<Integer> cQ = new LinkedList<>();
		rQ.add(0);
		cQ.add(0);
		while (!rQ.isEmpty()) {
			r = rQ.poll();
			c = cQ.poll();
			if (r == map.length - 1 && c == map[0].length - 1) {
				return map[r][c];
			}
			walkTo(r - 1, c, rQ, cQ, map, m, map[r][c]);
			walkTo(r + 1, c, rQ, cQ, map, m, map[r][c]);
			walkTo(r, c - 1, rQ, cQ, map, m, map[r][c]);
			walkTo(r, c + 1, rQ, cQ, map, m, map[r][c]);
		}
		return 0;
	}

	public void walkTo(int toR, int cR, Queue<Integer> rQ, Queue<Integer> cQ,
			int[][] map, int[][] m, int pre) {
		if (toR < 0 || toR == map.length || cR < 0 || cR == map[0].length
				|| map[toR][cR] != 0 || m[toR][cR] == 0) {
			return;
		}
		map[toR][cR] = pre + 1;
		rQ.add(toR);
		cQ.add(cR);
	}
}

package sdu.edu.Structure.EighthStructure.minPathValue;

import java.util.LinkedList;
import java.util.Queue;

public class Main1 {
	public int minPathValue(int[][] arr) {
		int r = 0;
		int c = 0;
		int[][] map = new int[arr.length][arr[0].length];
		map[0][0] = 1;
		Queue<Integer> rq = new LinkedList<Integer>();
		Queue<Integer> cq = new LinkedList<>();
		rq.add(0);
		cq.add(0);
		while (!rq.isEmpty()) {
			r = rq.poll();
			c = cq.poll();
			if (r == map.length - 1 && c == map[0].length - 1) {
				return map[r][c];
			}
			walkTo(map[r][c], r - 1, c, map, arr, rq, cq);
			walkTo(map[r][c], r + 1, c, map, arr, rq, cq);
			walkTo(map[r][c], r, c - 1, map, arr, rq, cq);
			walkTo(map[r][c], r, c + 1, map, arr, rq, cq);
		}
		return 0;
	}

	public void walkTo(int pre, int r, int c, int[][] map, int[][] arr,Queue<Integer> rq,Queue<Integer> cq) {
		if (r == map.length || c == map[0].length || map[r][c] != 0
				|| arr[r][c] == 0) {
			return;
		}
		map[r][c] = pre + 1;
		rq.add(r);
		cq.add(c);
	}
}

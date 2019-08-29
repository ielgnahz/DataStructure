package sdu.edu.Structure.FStructure.getMaxRecSize;

import java.util.Stack;

public class Main {
	public int getMaxRecSize(int[][] map) {
		int[] height = new int[map[0].length];
		int maxArea = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
			}
			maxArea = Math.max(maxArea, maxRecSize(height));
		}
		return maxArea;
	}

	public int maxRecSize(int height[]) {
		Stack<Integer> stack = new Stack<>();
		int maxArea = 0;
		for (int i = 0; i < height.length; i++) {
			while (!stack.isEmpty() && height[stack.peek()] >= height[i]) {
				int j = stack.pop();
				int k = stack.isEmpty() ? -1 : stack.peek();
				maxArea = Math.max(maxArea, (i - k - 1) * height[j]);
			}
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			int j = stack.pop();
			int k = stack.isEmpty() ? -1 : stack.peek();
			maxArea = Math.max(maxArea, (height.length - k - 1) * height[j]);
		}
		return maxArea;
	}

	public static void main(String[] args) {
		Main m = new Main();
		int[][] map = { { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 0, 1, 0 } };
		System.out.println(m.getMaxRecSize(map));
	}
}

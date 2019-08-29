package sdu.edu.Structure.FStructure.getNumfromMaxsubmin;

import java.util.LinkedList;

public class Main {
	public int getNum(int height[], int num) {
		LinkedList<Integer> qmin = new LinkedList<>();
		LinkedList<Integer> qmax = new LinkedList<>();
		int i = 0, j = 0, res = 0;
		while (i < height.length) {
			while (j < height.length) {
				while (!qmin.isEmpty() && qmin.peekLast() >= height[j]) {
					qmin.pollLast();
				}
				qmin.push(j);
				while (!qmax.isEmpty() && qmax.peekLast() <= height[j]) {
					qmax.pollLast();
				}
				qmax.push(j);
				if (height[qmax.peekFirst()] - height[qmin.peekFirst()] > num) {
					break;
				}
				j++;
			}
			if (qmax.peekFirst() == i) {
				qmax.pollFirst();
			}
			if (qmin.peekFirst() == i) {
				qmin.pollFirst();
			}
			res = j - i;
			i++;
		}
		return res;
	}
}

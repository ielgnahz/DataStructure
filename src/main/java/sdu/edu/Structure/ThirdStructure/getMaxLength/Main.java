package sdu.edu.Structure.ThirdStructure.getMaxLength;

import java.util.HashMap;

public class Main {
	public int getMaxLength(Node head, int sum) {
		HashMap<Integer, Integer> sumMap = new HashMap<>();
		sumMap.put(0, 0);
		return preOrder(head, 1, sum, 0, 0, sumMap);
	}
	public int preOrder(Node head, int level, int sum, int preSum, int maxLen,
			HashMap<Integer, Integer> sumMap) {
		if (head == null) {
			return maxLen;
		}
		int curSum = preSum + head.value;
		if (sumMap.containsKey(curSum - sum)) {
			maxLen = Math.max(maxLen, level - sumMap.get(curSum - sum));
		}
		if (!sumMap.containsKey(curSum)) {
			sumMap.put(curSum, level);
		}
		maxLen = preOrder(head.left, level + 1, sum, curSum, maxLen, sumMap);
		maxLen = preOrder(head.right, level + 1, sum, curSum, maxLen, sumMap);

//		if(level == sumMap.get(curSum)){
//			sumMap.remove(curSum);
//		}
		return maxLen;
	}

	public static void main(String[] args) {
		Node n1 = new Node(-2);
		Node n2 = new Node(2);
		Node n3 = new Node(-9);
		Node n4 = new Node(1);
		Node n5 = new Node(0);
		Node n6 = new Node(2);
		Node n7 = new Node(1);
		Node n8 = new Node(1);
		Node n9 = new Node(6);
		Node n10 = new Node(4);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		n5.left = n8;
		n5.right = n9;
		n8.left = n10;
		Main m = new Main();
		System.out.println(m.getMaxLength(n1, 4));
	}
}

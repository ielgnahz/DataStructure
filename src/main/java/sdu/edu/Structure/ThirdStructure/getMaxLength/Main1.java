package sdu.edu.Structure.ThirdStructure.getMaxLength;

import java.util.HashMap;

public class Main1 {
	public int getMaxLength(Node head,int sum){
		if(head == null){
			return 0;
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 0);
		return preOrder(head,0,1,sum,0,map);
	}
	public int preOrder(Node head,int maxLen,int level,int sum,int preSum,HashMap<Integer, Integer> map){
		if(head == null){
			return maxLen;
		}
		int curSum = preSum + head.value;
		if(map.containsKey(curSum- sum)){
			maxLen = Math.max(maxLen, level - map.get(curSum - sum));
		}
		if(!map.containsKey(curSum)){
			map.put(curSum, level);
		}
		maxLen = preOrder(head.left, maxLen, level+1, sum, curSum, map);
		maxLen = preOrder(head.right, maxLen, level+1, sum, curSum, map);
		if(level == map.get(curSum)){
			map.remove(curSum);
		}
		return maxLen;
	}
	public static void main(String[] args) {
		Node n1 = new Node(-3);
		Node n2 = new Node(3);
		Node n3 = new Node(-9);
		Node n4 = new Node(1);
		Node n5 = new Node(0);
		Node n6 = new Node(2);
		Node n7 = new Node(1);
		Node n8 = new Node(1);
		Node n9 = new Node(6);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		n5.left = n8;
		n5.right = n9;
		Main1 m = new Main1();
		System.out.println(m.getMaxLength(n1, -9));
	}
	
	
}

package sdu.edu.Structure.ThirdStructure.biggestSubBST;

public class Main1 {
	public Node biggestSubBST(Node head) {
		if(head == null){
			return null;
		}
		int[] record = new int[3];
		return posOrder(head,record);
	}
	public Node posOrder(Node head,int[] record){
		if(head == null){
			record[0] = 0;
			record[1] = Integer.MIN_VALUE;
			record[2] = Integer.MAX_VALUE;
			return null;
		}
		Node left = head.left;
		Node right = head.right;
		int value = head.value;
		Node leftE = posOrder(head.left, record);
		int lSize = record[0];
		int lMax = record[1];
		int lMin = record[2];
		Node rightE = posOrder(head.right, record);
		int rSize = record[0];
		int rMax = record[1];
		int rMin = record[2];
		record[1] = Math.max(value, rMax);
		record[2] =  Math.min(value, lMin);
		if(left == leftE && right == rightE && value < rMin && value > lMax ){
			record[0] = lSize + rSize + 1;
			return head;
		}
		record[0] = Math.max(lSize, rSize);
		return lSize > rSize?leftE:rightE;
		
	}


}

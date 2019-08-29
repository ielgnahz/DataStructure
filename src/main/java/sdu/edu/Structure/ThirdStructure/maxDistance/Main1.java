package sdu.edu.Structure.ThirdStructure.maxDistance;

public class Main1 {
	public int maxDistance(Node head) {
		if(head == null){
			return 0;
		}
		int[] record = new int[1];
		return posOrder(head,record);
	}
	
	public int posOrder(Node head,int[] record){
		if(head == null){
			record[0] = 0;
			return 0;
		}
		
		int lMax = posOrder(head.left, record);
		int maxfromLeft = record[0];
		int rMax = posOrder(head.right, record);
		int maxfromRight = record[0];
		record[0] = Math.max(maxfromLeft, maxfromRight) + 1;
		return Math.max(lMax, Math.max(rMax, maxfromLeft+maxfromRight+1));
	}
}

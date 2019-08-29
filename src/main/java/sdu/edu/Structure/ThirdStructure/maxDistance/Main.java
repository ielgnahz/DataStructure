package sdu.edu.Structure.ThirdStructure.maxDistance;

public class Main {
	public int maxDistance(Node head){
		int[] record = new int[1];
		return preOrder(head,record);
	}
	public int preOrder(Node head,int[] record){
		if(head == null){
			record[0] = 0;
			return 0;
		}
		int lMax = preOrder(head.left,record);//左子树中距离的最大值
		int maxfromLeft = record[0];//左子树中到左子树头节点的最大值
		int rMax = preOrder(head.right,record);
		int maxfromRight = record[0];
		int curNodeLen = maxfromLeft + maxfromRight + 1;
		record[0] = Math.max(maxfromLeft, maxfromRight) + 1;//当前节点到子节点的最大距离
		return Math.max(curNodeLen, Math.max(lMax, rMax));
	}
}

package sdu.edu.Structure.ThirdStructure.generateTree;

public class Main {
	public Node generateTree(int[] arr){
		if(arr == null || arr.length == 0){
			return null;
		}
		return generateNode(arr,0,arr.length-1);
	}
	public Node generateNode(int[] arr,int start,int end){
		if(start > end){
			return null;
		}
		int mid = (start + end) / 2;
		Node head = new Node(mid);
		head.left = generateNode(arr, start, mid-1);
		head.right = generateNode(arr, mid+1, end);
		return head;
	}
}

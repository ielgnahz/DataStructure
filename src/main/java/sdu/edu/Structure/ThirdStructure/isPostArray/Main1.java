package sdu.edu.Structure.ThirdStructure.isPostArray;

public class Main1 {
	public boolean isPostArray(int[] arr) {
		if(arr == null){
			return false;
		}
		return posOrder(arr,0,arr.length-1);
	}
	public boolean posOrder(int[]arr,int start,int end){
		if(start == end){
			return true;
		}
		int less = -1;
		int more = end;
		for(int i = start;i<end;i++){
			if(arr[i] < arr[end]){
				less = i;
			}else{
				more = more == end?i:more;
			}
		}
		if(less == -1 || more == end){
			return posOrder(arr, start, end-1);
		}
		if(less != more-1){
			return false;
		}
		return posOrder(arr, start, less) && posOrder(arr, more, end-1);
		
		
	}


	public Node postArrayToBST(int[] arr) {
		if(arr == null){
			return null;
		}
		return posOrderNode(arr,0,arr.length-1);
	}
	public Node posOrderNode(int[] arr,int start,int end){
		if(start > end){
			return null;
		}
		int less = -1;
		int more = end;
		for(int i = 0;i<arr.length;i++){
			if(arr[i] < arr[end]){
				less = i;
			}else{
				more = more == end?i:more;
			}
		}
		Node head = new Node(arr[end]);
		head.left = posOrderNode(arr, start, less);
		head.right = posOrderNode(arr, more, end-1);
		return head;
	}
}

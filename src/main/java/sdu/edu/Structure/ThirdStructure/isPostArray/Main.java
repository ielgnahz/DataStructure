package sdu.edu.Structure.ThirdStructure.isPostArray;

public class Main {
	public boolean isPostArray(int[] arr) {
		if (arr == null || arr.length == 0) {
			return false;
		}
		return isPost(arr, 0, arr.length - 1);
	}

	public boolean isPost(int[] arr, int start, int end) {
		if (start == end) {
			return true;
		}
		int less = -1;
		int more = end;
		for (int i = 0; i < end; i++) {
			if (arr[end] < arr[i]) {
				less = i;
			} else {
				more = more == end ? i : more;
			}
		}
		if (less == -1 || end == more) {
			return isPost(arr, start, end - 1);
		}
		if (less != more - 1) {
			return false;
		}
		return isPost(arr, start, less) && isPost(arr, more, end - 1);

	}

	public Node posArrayToBST(int[] posArr) {
		if (posArr == null) {
			return null;
		}
		return posToBST(posArr, 0, posArr.length - 1);
	}
	public Node posToBST(int[] posArr,int start,int end){
		if(start == end){
			return new Node(start);
		}
		int less = -1;
		int more = end;
		for(int i = start;i<end;i++){
			if(posArr[i] < posArr[end]){
				less = i;
			}else{
				more = more == end?i:more;
			}
		}
		Node head = new Node(posArr[end]);
		head.left = posToBST(posArr, start, less);
		head.right = posToBST(posArr, more, end - 1);
		return head;
	}
}

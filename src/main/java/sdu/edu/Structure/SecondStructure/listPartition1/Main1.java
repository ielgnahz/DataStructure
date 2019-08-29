package sdu.edu.Structure.SecondStructure.listPartition1;

public class Main1 {
	public Node  listPartition1(Node head,int pivot){
		if(head == null){
			return null;
		}
		Node cur = head;
		int i = 0;
		while(cur != null){
			i++;
			cur = cur.next;
		}
		cur = head;
		Node[] arr = new Node[i];
		for(int j = 0;j<arr.length;j++){
			arr[j] = cur;
			cur = cur.next;
		}
		int small = -1;
		int big = arr.length;
		int index = 0;
		while(index != big){
			if(arr[index].value < pivot){
				swap(arr, ++small, index++);
			}else if(arr[index].value == pivot){
				index++;
			}else{
				swap(arr, index, --big);
			}
		}
		head = arr[0];
		for(i = 1;i<arr.length;i++){
			arr[i-1].next = arr[i];
		}
		arr[arr.length-1].next = null;
		return head;
	}
	public void swap(Node[] arr,int a,int b){
		Node cur = arr[a];
		arr[a] = arr[b];
		arr[b] = cur;
	}
}

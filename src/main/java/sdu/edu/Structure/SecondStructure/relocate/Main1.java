package sdu.edu.Structure.SecondStructure.relocate;

public class Main1 {
	public void relocate(Node head){
		if(head == null || head.next == null){
			return;
		}
		Node cur = head;
		Node right = head.next;
		while(right.next != null && right.next.next != null){
			cur = cur.next;
			right = right.next.next;
		}
		right = cur.next;
		cur.next = null;
		merge(head,right);
	}
	public void merge(Node left,Node right){
		Node next = null;
		while(left != null){
			next = right.next;
			right.next = left.next;
			left.next = right;
			left = right.next;
			right = next;
		}
		
	}
}

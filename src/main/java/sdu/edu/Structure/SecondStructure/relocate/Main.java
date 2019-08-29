package sdu.edu.Structure.SecondStructure.relocate;

public class Main {
	public void relocate(Node head){
		if(head == null){
			return;
		}
		Node mid = head;
		Node right = head.next;
		while(right.next != null && right.next.next != null){
			mid = mid.next;
			right = right.next.next;
		}
		right = mid.next;
		mid.next = null;
		
	}
	public void mergeLR(Node head,Node right){
		Node cur1 = head;
		Node cur2 = right;
		Node next = null;
		while(cur1 != null){
			next = cur2.next;
			cur2.next = cur1.next;
			cur1.next = cur2;
			cur1 = cur2.next;
			cur2 = next;
		}
		cur1.next = cur2;
	}
}

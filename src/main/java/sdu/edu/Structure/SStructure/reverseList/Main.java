package sdu.edu.Structure.SStructure.reverseList;

public class Main {
	public Node reverseList(Node head){
		Node pre = null;
		Node next = null;
		while(head!=null){
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}
	public DoubleNode reverseDoubleList(DoubleNode head){
		DoubleNode pre = null;
		DoubleNode next = null;
		while(head != null){
			next = head.next;
			head.next = pre;
			head.last = next;
			pre = head;
			head = next;
		}
		return pre;
	}
}

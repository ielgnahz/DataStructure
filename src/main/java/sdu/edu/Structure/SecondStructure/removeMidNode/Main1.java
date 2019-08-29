package sdu.edu.Structure.SecondStructure.removeMidNode;

public class Main1 {
	public Node removeMidNode(Node head) {
		if (head == null) {
			return null;
		}
		if(head.next.next == null){
			return head.next;
		}
		Node pre = head;
		Node cur = head.next.next;
		while(cur.next != null && cur.next.next != null){
			pre = pre.next;
			cur = cur.next.next;
		}
		pre.next = pre.next.next;
		return head;
	}
}

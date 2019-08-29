package sdu.edu.Structure.SecondStructure.removeLastKthNode;

public class Main1 {
	public Node removeLastKthNode(Node head, int k) {
		if (head == null) {
			return null;
		}
		Node cur = head;
		while (cur != null) {
			k--;
			cur = cur.next;
		}
		if (k > 0) {
			return null;
		}
		if(k == 0){
			return head.next;
		}
		cur = head;
		while(++k != 0){
			cur = cur.next;
		}
		cur.next = cur.next.next;
		return head;
	}
}

package sdu.edu.Structure.SecondStructure.insertNum;

public class Main {
	public Node insertNum(Node head, int num) {
		Node node = new Node(num);
		if (head == null) {
			node.next = node;
			return node;
		}
		Node pre = head;
		Node cur = head.next;
		while (cur != head) {
			if (cur.value >= num && pre.value <= num) {
				break;
			}
			cur = cur.next;
			pre = pre.next;
		}
		pre.next = node;
		node.next = cur;
		return cur.value < num ? cur : node;
	}
}

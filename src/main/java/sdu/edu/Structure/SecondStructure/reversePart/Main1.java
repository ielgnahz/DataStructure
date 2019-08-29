package sdu.edu.Structure.SecondStructure.reversePart;

public class Main1 {
	public static void main(String[] args) {
		System.out.println(3%3);
	}
	public Node reversePart(Node head, int from, int to) {
		if (head == null || from > to) {
			return null;
		}
		Node fPos = null;
		Node tPos = null;
		int len = 0;
		Node cur = head;
		while (cur != null) {
			len++;
			fPos = len == from - 1 ? cur : fPos;
			tPos = len == to + 1 ? cur : tPos;
		}
		Node node1 = fPos == null?head:fPos.next;
		Node node2 = node1.next;
		node1.next = tPos;
		Node next = null;
		while(node2 != tPos){
			next = node2.next;
			node2.next = node1;
			node1 = node2;
			node2 = next;
		}
		if(fPos != null){
			fPos.next = node1;
			return head;
		}
		return node1;
	}
}

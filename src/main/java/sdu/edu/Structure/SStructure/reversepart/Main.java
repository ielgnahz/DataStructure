package sdu.edu.Structure.SStructure.reversepart;

public class Main {
	public Node reversePart(Node head, int from, int to) {
		Node curNode = head;
		Node fpos = null;
		Node tpos = null;
		int len = 0;
		while(curNode != null){
			len++;
			fpos = len == from-1?curNode:fpos;
			tpos = len == to+1?curNode:tpos;
			curNode = curNode.next;
		}
		Node next = null;
		Node node1 = fpos == null?head:fpos.next;
		Node node2 = node1.next;
		node1.next = tpos;
		while(node2!=tpos){
			next = node2.next;
			node2.next = node1;
			node1 = node2;
			node2 = next;
		}
		if(fpos!=null){
			fpos.next = node1;
			return head;
		}
		return node1;
	}
}

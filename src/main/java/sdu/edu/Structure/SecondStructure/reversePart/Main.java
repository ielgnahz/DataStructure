package sdu.edu.Structure.SecondStructure.reversePart;
//反转部分单向链表
public class Main {
	public Node reversePart(Node head,int from,int to){
		int n =0;
		Node tPos = null;
		Node fPre = null;
		Node curNode = head;
		while(curNode != null){
			n++;
			fPre = n == from - 1 ?curNode:fPre;
			tPos = n == to + 1 ?curNode:tPos;
		}
		Node node1 = fPre == null?head:fPre.next;
		Node node2 = node1.next;
		node1.next = tPos;
		Node next = null;
		while(node2 != tPos){
			next = node2.next;
			node2.next = node1;
			node1 = node2;
			node2 = next;
		}
		if(fPre != null){
			fPre.next = node1;
			return head;
		}
		return head;
	}
}

package sdu.edu.Structure.SecondStructure.copyListWithRand;

import java.util.HashMap;

public class Main {
	public Node copyListWithRand(Node head){
		HashMap<Node, Node> map = new HashMap<>();
		Node curNode = head;
		while(curNode != null){
			map.put(curNode, new Node(curNode.value));
			curNode = curNode.next;
		}
		curNode = head;
		while(curNode != null){
			map.get(curNode).next = curNode.next;
			map.get(curNode).rand = curNode.rand;
			curNode = curNode.next;
		}
		return map.get(head);
	}
	public Node copyListWithRand2(Node head){
		Node curNode = head;
		Node next = null;
		while(curNode != null){
			next = curNode.next;
			curNode.next = new Node(curNode.value);
			curNode.next.next = next;
			curNode = next;
		}
		curNode = head;
		while(curNode != null){
			next = curNode.next;
			next.rand = curNode.rand!=null?curNode.rand.next:null;
			curNode = next.next;
		}
		curNode = head.next;
		Node cur = head;
		while(cur!=null){
			next = cur.next.next;
			cur.next = next;
			curNode.next = next!=null?next.next:null;
			cur = next;
			curNode = next.next;
		}
		return curNode;
	}
}

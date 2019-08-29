package sdu.edu.Structure.SecondStructure.copyListWithRand;

import java.util.HashMap;

public class Main1 {
	public Node copyListWithRand(Node head){
		if(head == null){
			return null;
		}
		Node cur = head;
		HashMap<Node, Node> map = new HashMap<>();
		while(cur != null){
			map.put(cur, new Node(cur.value));
			cur = cur.next;
		}
		cur = head;
		while(cur != null){
			map.get(cur).next = map.get(cur.next);
			map.get(cur).rand = map.get(cur.rand);
			cur = cur.next;
		}
		return map.get(head);
	}
	
	public Node copyListWithRand1(Node head){
		if(head == null){
			return null;
		}
		Node cur = head;
		while(cur != null){
			Node node = new Node(cur.value);
			node = cur.next;
			cur.next = node;
			cur = cur.next.next;
		}
		cur = head;
		while(cur != null){
			cur.next.rand = cur.rand == null?null:cur.rand.next;
			cur = cur.next.next;
		}
		Node res = head.next;
		cur = head;
		Node next = null;
		Node copyNext = null;
		while(cur != null){
			next = cur.next.next;
			copyNext = cur.next;
			cur.next = next;
			copyNext.next = next == null?null:next.next;
			cur = next;
			cur.next = next.next;
		}
		return res;
	}
}

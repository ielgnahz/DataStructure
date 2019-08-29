package sdu.edu.Structure.SStructure.copyListWithRand;

import java.util.HashMap;

public class Main {
	public Node copyListWithRand1(Node head){
		HashMap<Node, Node> map = new HashMap<>();
		Node cur = head;
		while(cur!=null){
			map.put(cur, new Node(cur.value));
		}
		cur = head;
		while(cur!=null){
			map.get(cur).rand = cur.rand;
			map.get(cur).next = cur.next;
			cur = cur.next;
		}
		return map.get(head);
		
	}
	public Node copyListWithRand2(Node head){
		Node cur = head;
		Node next = null;
		while(cur != null){
			next = cur.next;
			Node ne = new Node(cur.value);
			cur.next = ne;
			ne.next = next;
			cur = next;
		}
		cur = head;
		Node head1 = cur.next;
		next = null;
		while(cur!=null){
			next = cur.next.next;
			cur.next.rand = cur.rand==null?null:cur.rand.next;
			cur.next.next = next==null?null:next.next;
			cur.next =  next;
			cur = next;
		}
		return head1;
	}
}

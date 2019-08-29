package sdu.edu.Structure.SecondStructure.removeRep1;

import java.util.HashSet;

public class Main {
	public Node removeRep1(Node head){
		if(head == null){
			return null;
		}
		HashSet<Integer> set = new HashSet<>();
		Node cur = head.next;
		Node pre = head;
		set.add(head.value);
		while(cur != null){
			if(set.contains(cur.value)){
				pre.next = cur.next;
			}else{
				set.add(cur.value);
				pre = pre.next;
			}
			cur = cur.next;
		}
		return head;
	}
	
	public Node removeRep2(Node head){
		if(head == null){
			return null;
		}
		Node cur = head;
		Node pre = head;
		Node next = null;
		while(cur != null){
			pre = cur;
			next = cur.next;
			while(next != null){
				if(next.value == cur.value){
					pre.next = next.next;
				}else{
					pre = pre.next;
				}
				next = next.next;
			}
			cur = cur.next;
		}
		return head;
	}
}

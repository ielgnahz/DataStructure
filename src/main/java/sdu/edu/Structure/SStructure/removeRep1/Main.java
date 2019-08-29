package sdu.edu.Structure.SStructure.removeRep1;

import java.util.HashSet;

public class Main {
	public Node removeRep1(Node head) {
		HashSet<Integer> set = new HashSet<>();
		Node cur = head.next;
		Node pre = head;
		set.add(head.value);
		while (cur != null) {
			if (set.contains(cur.value)) {
				pre.next = cur.next;
			} else {
				set.add(cur.value);
				pre = pre.next;
			}
			cur = cur.next;
		}
		return head;
	}

	public Node removeRep2(Node head) {
		Node cur1 = head;
		Node cur2 = null;
		Node pre = null;
		while (cur1 != null) {
			cur2 = cur1.next;
			pre = cur1;
			while (cur2 != null) {
				if (cur2.value == cur1.value) {
					pre.next = cur2.next;
				} else {
					pre = pre.next;
				}
				cur2 = cur2.next;
			}
			cur1 = cur1.next;
		}
		return head;
	}
}

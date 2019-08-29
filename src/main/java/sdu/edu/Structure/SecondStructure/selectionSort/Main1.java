package sdu.edu.Structure.SecondStructure.selectionSort;

public class Main1 {
	public Node selectionSort(Node head) {
		if (head == null) {
			return null;
		}
		Node cur = head;
		Node small = null;
		Node smallPre = null;
		Node tail = null;
		while (cur != null) {
			smallPre = getSmallestNode(cur);
			if (smallPre != null) {
				small = smallPre.next;
				smallPre.next = small.next;
				small.next = null;
			} else {
				small = cur;
			}

			cur = cur == small ? cur.next : cur;
			if (tail != null) {
				tail.next = small;
				;
			} else {
				head = small;
			}
			tail = small;
		}
		return head;
	}

	public Node getSmallestNode(Node head) {
		Node cur = head.next;
		Node pre = null;
		Node small = head;
		Node smallPre = null;
		while (cur != null) {
			if (cur.value < small.value) {
				small = cur;
				smallPre = pre;
			}
			pre = cur;
			cur = cur.next;
		}
		return smallPre;
	}
}

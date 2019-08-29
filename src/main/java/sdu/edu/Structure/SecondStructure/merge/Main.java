package sdu.edu.Structure.SecondStructure.merge;

public class Main {
	public Node merge1(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return head1 == null ? head2 : head1;
		}

		Node head = head1.value < head2.value ? head1 : head2;
		Node cur1 = head == head1 ? head1.next : head1;
		Node cur2 = head == head2 ? head2.next : head2;
		Node tail = head;
		while (cur1 != null && cur2 != null) {
			if (cur1.value < cur2.value) {
				tail.next = cur1;
				tail = tail.next;
				cur1 = cur1.next;
			} else {
				tail.next = cur2;
				tail = tail.next;
				cur2 = cur1.next;
			}
		}
		if (cur1 != null) {
			tail.next = cur1;
		}
		if (cur2 != null) {
			tail.next = cur2;
		}
		return head;
	}

	public Node merge2(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return head1 == null ? head2 : head1;
		}
		Node head = head1.value < head2.value ? head1 : head2;
		Node cur1 = head == head1 ? head1 : head2;
		Node cur2 = head == head1 ? head2 : head1;
		Node pre = null;
		Node next = null;
		while (cur1 != null && cur2 != null) {
			if (cur1.value < cur2.value) {
				pre = cur1;
				cur1 = cur1.next;
			} else {
				next = cur2.next;
				pre.next = cur2;
				cur2.next = cur1;
				pre = cur2;
				cur2 = next;
			}
		}
		pre.next = cur2 == null ? cur1 : cur2;
		return head;
	}
}

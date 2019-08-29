package sdu.edu.Structure.SecondStructure.getIntersectNode;

public class Main {
	public boolean getIntersectNode(Node head1, Node head2) {
		Node n1 = getLoopNode(head1);
		Node n2 = getLoopNode(head2);
		if (n1 == null && n2 == null) {
			Node node = noLoop(head1, head2);
			if (node != null) {
				return true;
			}
		} else {
			Node node = bothLoop(head1, n1, head2, n2);
			if (node != null) {
				return true;
			}
		}
		return false;
	}

	public Node getLoopNode(Node head) {
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}
		Node n1 = head;
		Node n2 = n1.next.next;
		while (n1 != n2) {
			if (n2.next == null || n2.next.next == null) {
				return null;
			}
			n1 = n1.next;
			n2 = n2.next.next;
		}
		n1 = head;
		while (n1 != n2) {
			n1 = n1.next;
			n2 = n2.next;
		}
		return n1;
	}

	public Node noLoop(Node head1, Node head2) {
		int n = 0;
		Node cur1 = head1;
		Node cur2 = head2;
		while (cur1 != null) {
			n++;
			cur1 = cur1.next;
		}
		while (cur2 != null) {
			n--;
			cur2 = cur2.next;
		}
		cur1 = n > 0 ? head1 : head2;
		cur2 = cur1 == head1 ? head2 : head1;
		n = Math.abs(n);
		while (n-- != 0) {
			cur1 = cur1.next;
		}
		while (cur1 != cur2) {
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return cur2;
	}

	public Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
		if (loop1 == loop2) {
			Node cur1 = head1;
			Node cur2 = head2;
			int n = 0;
			while (cur1 != loop1) {
				n++;
				cur1 = cur1.next;
			}
			while (cur2 != loop1) {
				n--;
				cur2 = cur2.next;
			}
			cur1 = n > 0 ? head1 : head2;
			cur2 = cur1 == head1 ? head2 : head1;
			n = Math.abs(n);
			while (n != 0) {
				n--;
				cur1 = cur1.next;
			}
			while (cur1 != cur2) {
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
			return cur1;
		} else {
			Node cur1 = loop1.next;
			while (cur1 != loop2) {
				if (cur1 == loop1) {
					return null;
				}
				cur1 = cur1.next;
			}
			return cur1;
		}
	}

}

package sdu.edu.Structure.SecondStructure.getIntersectNode;

public class Main1 {
	public static void main(String[] args) {
		int n = 1;
		while (n-- != 0) {
			System.out.println(1);
		}
	}

	public Node getIntersectNode(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		Node l1 = getLoopNode(head1);
		Node l2 = getLoopNode(head2);
		if (l1 == null && l2 == null) {
			return noLoop(head1, head2);
		}
		if (l1 != null && l2 != null) {
			return bothLoop(head1, head2);
		}
		return null;
	}

	public Node getLoopNode(Node head) {
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}
		Node n1 = head.next;
		Node n2 = head.next.next;
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

	public Node noLoop(Node n1, Node n2) {
		if (n1 == null || n2 == null) {
			return null;
		}
		int l1 = 0;
		int l2 = 0;
		Node c1 = n1;
		Node c2 = n2;
		while (c1 != null) {
			l1++;
			c1 = c1.next;
		}
		while (c2 != null) {
			l2++;
			c2 = c2.next;
		}
		int len = Math.abs(l1 - l2);
		c1 = l1 > l2 ? n1 : n2;
		c2 = c1 == n1 ? n2 : n1;
		while (len-- != 0) {
			c1 = c1.next;
		}
		while (c1 != c2) {
			c1 = c1.next;
			c2 = c2.next;
		}
		return c1;
	}

	public Node bothLoop(Node h1, Node h2) {
		if (h1 == null || h2 == null) {
			return null;
		}
		Node l1 = getLoopNode(h1);
		Node l2 = getLoopNode(h2);
		if (l1 == l2) {
			Node c1 = h1;
			Node c2 = h2;
			int len1 = 0;
			int len2 = 0;
			while (c1 != l1) {
				len1++;
				c1 = c1.next;
			}
			while (c2 != l2) {
				len2++;
				c2 = c2.next;
			}
			int n = Math.abs(len1 - len2);
			c1 = len1 > len2 ? h1 : h2;
			c2 = c1 == h1 ? c2 : c1;
			while (n-- != 0) {
				c1 = c1.next;
			}
			while (c1 != c2) {
				c1 = c1.next;
				c2 = c2.next;
			}
			return c1;
		} else {
			Node c1 = l1.next;
			while (c1 != l1) {
				if (c1 == l2) {
					return l1;
				}
				c1 = c1.next;
			}
			return null;
		}
	}

}

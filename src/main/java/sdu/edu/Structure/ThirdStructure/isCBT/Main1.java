package sdu.edu.Structure.ThirdStructure.isCBT;

import java.util.LinkedList;
import java.util.Queue;

public class Main1 {
	public boolean isCBT(Node head) {
		if (head == null) {
			return false;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.offer(head);
		boolean leaf = false;
		Node l = null;
		Node r = null;
		while (!queue.isEmpty()) {
			head = queue.poll();
			l = head.left;
			r = head.right;
			if ((leaf && (l != null || r != null)) || (l == null && r != null)) {
				return false;
			}
			if (l != null) {
				queue.offer(l);
			}
			if (r != null) {
				queue.offer(r);
			} else {
				leaf = true;
			}
		}
		return true;
	}
}

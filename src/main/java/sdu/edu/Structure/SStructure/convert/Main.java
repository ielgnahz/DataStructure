package sdu.edu.Structure.SStructure.convert;

public class Main {
	public Node convert2(Node head) {
		if (head == null) {
			return null;
		}
		Node last = process(head);
		head = last.right;
		last.right = null;
		return head;
	}

	public Node process(Node head) {
		Node leftE = process(head.left);
		Node rightE = process(head.right);
		Node leftS = leftE == null ? null : leftE.right;
		Node rightS = rightE == null ? null : rightE.right;

		if (leftE != null && rightE != null) {
			leftE.right = head;
			head.left = leftE;
			head.right = rightS;
			rightS.left = head;
			rightE.right = leftS;
			return rightE;
		} else if (leftE != null) {
			leftE.right = head;
			head.left = leftE;
			head.right = leftS;
			return head;
		} else if (rightE != null) {
			head.right = rightS;
			rightS.left = head;
			rightE.right = head;
			return rightE;
		} else {
			head.right = head;
			return head;
		}
	}
}

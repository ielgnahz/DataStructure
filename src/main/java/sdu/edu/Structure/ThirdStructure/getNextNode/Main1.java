package sdu.edu.Structure.ThirdStructure.getNextNode;

public class Main1 {
	public Node getNextNode(Node node) {
		if (node == null) {
			return null;
		}
		if (node.right != null) {
			Node cur = node.right;
			while (cur.left != null) {
				cur = cur.left;
			}
			return cur;
		} else {
			Node parent = node.parent;
			while (parent != null && parent.left != node) {
				node = parent;
				parent = parent.parent;
			}
			return parent;

		}
	}
}

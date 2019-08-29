package sdu.edu.Structure.ThirdStructure.serialByPre;

import java.util.LinkedList;
import java.util.Queue;

public class Main1 {
	public String serialByPre(Node head) {
		if (head == null) {
			return "#!";
		}
		String res = head.value + "!";
		res += serialByPre(head.left);
		res += serialByPre(head.right);
		return res;
	}

	public Node reconByPreString(String res) {
		String[] re = res.split("!");
		Queue<String> queue = new LinkedList<>();
		for (int i = 0; i < re.length; i++) {
			queue.offer(re[i]);
		}
		return reconpreOrder(queue);
	}

	public Node reconpreOrder(Queue<String> queue) {
		String value = queue.poll();
		if (value.equals("#")) {
			return null;
		}
		Node head = new Node(Integer.valueOf(value));
		head.left = reconpreOrder(queue);
		head.right = reconpreOrder(queue);
		return head;
	}

	public String serialByLevel(Node head) {
		if (head == null) {
			return "#!";
		}
		String res = head.value + "!";
		Queue<Node> queue = new LinkedList<>();
		while (!queue.isEmpty()) {
			head = queue.poll();
			if (head.left != null) {
				queue.offer(head.left);
				res += head.left.value;
			} else {
				res += "#!";
			}
			if (head.right != null) {
				queue.offer(head.right);
				res += head.right.value + "!";
			} else {
				res += "#!";
			}
		}
		return res;
	}

	public Node reconByLevelString(String levelStr) {
		String[] res = levelStr.split("!");
		Node head = generateNode(res[0]);
		Node newhead = head;
		Queue<Node> queue = new LinkedList<>();
		queue.offer(head);
		int index = 1;
		while (!queue.isEmpty()) {
			head = queue.poll();
			head.left = generateNode(res[index++]);
			head.right = generateNode(res[index++]);
			if (head.left != null) {
				queue.offer(head.left);
			}
			if (head.right != null) {
				queue.offer(head.right);
			}
		}
		return newhead;
	}

	public Node generateNode(String res) {
		if (res.equals("#")) {
			return null;
		}
		return new Node(Integer.valueOf(res));
	}

}

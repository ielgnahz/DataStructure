package sdu.edu.Structure.ThirdStructure.serialByPre;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
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
		String[] val = res.split("!");
		Queue<String> queue = new LinkedList<>();
		for (int i = 0; i < val.length; i++) {
			queue.offer(val[i]);
		}
		return reconPreOrder(queue);
	}

	public Node reconPreOrder(Queue<String> queue) {
		String head = queue.poll();
		if (head.equals("#")) {
			return null;
		}
		Node node = new Node(Integer.valueOf(head));
		node.left = reconPreOrder(queue);
		node.right = reconPreOrder(queue);
		return node;
	}

	public String serialByLevel(Node head) {
		if (head == null) {
			return "#!";
		}
		String res = head.value + "!";
		Queue<Node> queue = new LinkedList<>();
		queue.offer(head);
		Node cur = null;
		while (!queue.isEmpty()) {
			cur = queue.poll();
			if (cur.left != null) {
				queue.offer(cur.left);
				res += cur.left.value + "!";
			} else {
				res += "#!";
			}
			if (cur.right != null) {
				queue.offer(cur.right);
				res += cur.right.value + "!";
			} else {
				res += "#!";
			}
		}
		return res;
	}

	public Node reconByLevel(String line) {
		String val[] = line.split("!");
		int index = 0;
		Node head = generateNode(val[index++]);
		Queue<Node> queue = new LinkedList<>();
		queue.offer(head);
		Node node = null;
		while(!queue.isEmpty()){
			node = queue.poll();
			node.left = generateNode(val[index++]);
			node.right = generateNode(val[index++]);
			if(node.left != null){
				queue.offer(node.left);
			}
			if(node.left != null){
				queue.offer(node.right);
			}
		}
		return head;
		
	}

	public Node generateNode(String node) {
		if(node.equals("#")){
			return null;
		}
		return new Node(Integer.valueOf(node));
	}
}

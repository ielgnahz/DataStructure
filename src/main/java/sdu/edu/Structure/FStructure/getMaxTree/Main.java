package sdu.edu.Structure.FStructure.getMaxTree;

import java.util.HashMap;
import java.util.Stack;

public class Main {
	public Node getMaxTree(int[] tree) {
		Node[] nArr = new Node[tree.length];
		Stack<Node> stack = new Stack<>();
		HashMap<Node, Node> lmap = new HashMap<>();
		HashMap<Node, Node> rmap = new HashMap<>();
		for (int i = 0; i < nArr.length; i++) {
			while (!stack.isEmpty() && stack.peek().value < nArr[i].value) {
				popStackMap(stack, lmap);
			}
			stack.push(nArr[i]);
		}
		while (!stack.isEmpty()) {
			popStackMap(stack, lmap);
		}

		for (int i = nArr.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && stack.peek().value < nArr[i].value) {
				popStackMap(stack, rmap);
			}
			stack.push(nArr[i]);
		}
		while (!stack.isEmpty()) {
			popStackMap(stack, rmap);
		}

		Node head = null;
		for (int i = 0; i < nArr.length; i++) {
			Node curNode = nArr[i];
			Node lNode = lmap.get(curNode);
			Node rNode = rmap.get(curNode);
			if (lNode == null && rNode == null) {
				head = curNode;
			} else if (lNode == null) {
				if (rNode.left == null) {
					rNode.left = curNode;
				} else {
					rNode.right = curNode;
				}
			}else if(rNode == null){
				if(lNode.left == null){
					lNode.left = curNode;
				}else{
					lNode.right = curNode;
				}
			}else{
				Node parent = lNode.value<curNode.value?lNode:rNode;
				if(parent.left == null){
					parent.left = curNode;
				}else{
					parent.right = curNode;
				}
			}
		}
		return head;
	}

	public void popStackMap(Stack<Node> stack, HashMap<Node, Node> map) {
		Node curNode = stack.pop();
		if (stack.isEmpty()) {
			map.put(curNode, null);
		} else {
			map.put(curNode, stack.peek());
		}
	}

	public void popNode(HashMap<Integer, Integer> map, Stack<Integer> stack) {
		int i = stack.pop();
		if (stack.isEmpty()) {
			map.put(i, null);
		} else {
			map.put(i, stack.peek());
		}
	}
}

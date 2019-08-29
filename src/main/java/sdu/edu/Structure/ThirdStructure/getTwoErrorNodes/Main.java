package sdu.edu.Structure.ThirdStructure.getTwoErrorNodes;

import java.util.Stack;

public class Main {
	public void getTwoErrorNodes(Node head){
		Stack<Node> stack = new Stack<>();
		stack.push(head);
		Node pre = null;
		Node []err = new Node[2];
		while(!stack.isEmpty() || head != null){
			if(head != null){
				stack.push(head);
				head = head.left;
			}else{
				head = stack.pop();
				if(pre != null && pre.value > head.value){
					err[0] = err[0] == null?pre:err[0];
					err[1] = head;
				}
				pre = head;
				head = head.right;
			}
			
		}
	}
}

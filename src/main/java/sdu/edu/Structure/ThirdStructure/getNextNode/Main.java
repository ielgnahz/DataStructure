package sdu.edu.Structure.ThirdStructure.getNextNode;

public class Main {
	public Node getNextNode(Node head){
		if(head == null){
			return null;
		}
		if(head.right!= null){
			return getLeftNode(head.right);
		}else{
			Node parent = head.parent;
			while(parent != null && parent.right == head){
				head = parent;
				parent = head.parent;
			}
			return parent;
		}
	}
	public Node getLeftNode(Node head){
		while(head.left != null){
			head = head.left;
		}
		return head;
	}
}

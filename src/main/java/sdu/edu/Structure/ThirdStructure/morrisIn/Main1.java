package sdu.edu.Structure.ThirdStructure.morrisIn;

public class Main1 {
	public void morrisIn(Node head){
		if(head == null){
			return;
		}
		Node cur1 = head;
		Node cur2 = null;
		while(cur1 != null){
			cur2 = cur1.left;
			if(cur2 != null){
				while(cur2.right != null && cur2.right != cur1){
					cur2 = cur2.right;
				}
				if(cur2.right == null){
					cur2.right = cur1;
					cur1 = cur1.left;
					continue;
				}else{
					cur2.right = null;
				}
			}
			System.out.println(cur1.value);
			cur1 = cur1.right;
		}
		
	}
	public void morrisPre(Node head){
		if(head == null){
			return;
		}
		Node cur1 = head;
		Node cur2 = null;
		while(cur1 != null){
			cur2 = cur1.left;
			if(cur2!= null){
				while(cur2.right != cur1 && cur2.right != null){
					cur2 = cur2.right;
				}
				if(cur2.right == null){
					cur2.right = cur1;
					System.out.println(cur1.value);
					cur1 = cur1.left;
					continue;
				}else{
					cur2.right = null;
				}
			}else{
				System.out.println(cur1.value);
			}
			cur1 = cur1.right;
		}
	}
	public void morrisPos(Node head){
		if(head == null){
			return;
		}
		Node cur1 = head;
		Node cur2 = null;
		while(cur1 != null){
			cur2 = cur1.left;
			if(cur2 != null){
				while(cur2.right != null && cur2.right != cur1){
					cur2 = cur2.right;
				}
				if(cur2.right == null){
					cur2.right = cur1;
					cur1 = cur1.left;
					continue;
				}else{
					cur2.right = null;
					printEdge(cur1.left);
				}
			}
			cur1 = cur1.right;
			
		}
		printEdge(head);
	}
	
	public void printEdge(Node head){
		if(head == null){
			return;
		}
		head = reverse(head);
		Node tail = head;
		while(head != null){
			System.out.println(head.right);
			head = head.right;
		}
		reverse(tail);
	}
	public Node reverse(Node head){
		Node pre = null;
		Node next = null;
		while(head != null){
			next = head.right;
			head.right = pre;
			pre = head;
			head = next;
		}
		return pre;
	}
}	

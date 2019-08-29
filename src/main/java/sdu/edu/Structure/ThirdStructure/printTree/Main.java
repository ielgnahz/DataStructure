package sdu.edu.Structure.ThirdStructure.printTree;

public class Main {
	public void printTree(Node head){
		System.out.println("Binary Tree:");
		printInOrder(head,0,"H",17);
		
	}
	public void printInOrder(Node head,int height,String to,int len){
		if(head == null){
			return;
		}
		printInOrder(head.right,height+1,"v",len);
		String val = to + head.value + to;
		int lenL = (len - val.length())/2;
		int lenR = len - val.length() - lenL;
		System.out.println(getSpace(height * len)+getSpace(lenL)+val+getSpace(lenR));
		printInOrder(head.left,height+1,"∧",len);
	}
	public String getSpace(int num){
		StringBuffer sb = new StringBuffer("");
		for(int i =0;i<num;i++){
			sb.append(" ");
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		Node h1 = new Node(1);
		Node h2 = new Node(2);
		Node h3 = new Node(3);
		Node h4 = new Node(4);
		Node h5 = new Node(5);
		Node h6 = new Node(6);
		Node h7 = new Node(7);
		h1.left = h2;
		h1.right = h3;
		h2.left = h4;
		h4.right = h7;
		h3.left = h5;
		h3.right = h6;
		Main main = new Main();
		main.printTree(h1);
	}
}

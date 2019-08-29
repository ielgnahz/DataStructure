package sdu.edu.Structure.SecondStructure.removeNodeWired;

public class Main {
	public void removeNodeWired(Node node) {
		if(node == null){
			return;
		}
		Node next = node.next;
		if(next == null){
			throw new RuntimeException("can not remvoe last node.");
		}
		node.value = next.value;
		node.next = next.next;
	}
}

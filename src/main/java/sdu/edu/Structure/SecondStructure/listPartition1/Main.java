package sdu.edu.Structure.SecondStructure.listPartition1;

public class Main {
	public Node listPartition1(Node head,int pivot){
		if(head == null){
			return null;
		}
		Node curNode = head;
		int i = 0;
		while(curNode != null){
			i++;
			curNode = curNode.next;
		}
		curNode = head;
		Node []nodeArr = new Node[i];
		for(int j = 0;j<i;j++){
			nodeArr[j] = curNode;
			curNode = curNode.next;
		}
		arrPartition(nodeArr, pivot);
		for(int j = 1;j<nodeArr.length;j++){
			nodeArr[j-1].next = nodeArr[j];
		}
		nodeArr[nodeArr.length-1].next = null;
		return nodeArr[0];
	}
	public void arrPartition(Node[] arrNode,int pivot){
		int small = -1;
		int big = arrNode.length;
		int index = 0;
		while(index != big){
			if(arrNode[index].value < pivot){
				swap(arrNode, ++small, index++);
			}else if(arrNode[index].value == pivot){
				index++;
			}else{
				swap(arrNode, index, --big);
			}
		}
		
	}
	public void swap(Node[] arrNode,int a,int b){
		Node tmp = arrNode[a];
		arrNode[a] = arrNode[b];
		arrNode[b] = tmp;
	}
	
	public Node listPartition2(Node head,int pivot){
		Node sH = null;
		Node sT = null;
		Node eH = null;
		Node eT = null;
		Node bH = null;
		Node bT = null;
		Node next = null;
		while(head != null){
			next = head.next;
			if(head.value < pivot){
				if(sH == null){
					sH = head;
					sT = head;
				}else{
					sT.next = head;
					sT = head;
				}
			}else if(head.value == pivot){
				if(eH == null){
					eH = head;
					eT = head;
				}else{
					eT.next = head;
					eT = head;
				}
			}else{
				if(bH == null){
					bH = head;
					bT = head;
				}else{
					bT.next = head;
					bT = head;
				}
			}
		}
		if(sH != null){
			sT.next = eH;
			eT = eT == null?sT:eT;
		}
		if(eT != null){
			eT.next = bH;
		}
		return sH != null?sH:eH != null?eH:bH;
	}
}

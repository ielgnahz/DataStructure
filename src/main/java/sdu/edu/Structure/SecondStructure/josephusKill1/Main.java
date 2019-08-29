package sdu.edu.Structure.SecondStructure.josephusKill1;
//环形单链表的约瑟夫问题

public class Main {
	public Node josephusKill1(Node head,int m){
		Node last = head;
		while(last.next != head){
			last = last.next;
		}
		int count = 0;
		while(last != head){
			if(++ count == m){
				last.next = head.next;
				count = 0;
			}else{
				last=last.next; 
			}
			head = last.next;
		}
		return last;
	}
	public Node josephusKill2(Node head,int m){
		int i =0;
		Node curNode = head;
		while(curNode != null){
			i++;
			curNode = curNode.next;
		}
		int cur = giveLive(i,m);
		int j = 0;
		curNode = head;
		while(++j != cur){
			curNode = curNode.next;
		}
		return curNode;
	}
	public int giveLive(int i,int m){
		if(i == 1){
			return 1;
		}
		return (giveLive(i-1,m) + m - 1) % i + 1;
	}
}

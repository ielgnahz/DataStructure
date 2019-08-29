package sdu.edu.Structure.SStructure.josephusKill1;

public class Main {
	public Node josephusKill1(Node head,int m){
		Node last = head;
		while(last.next != head){
			last = last.next;
		}
		int count = 0;
		while(last != head){
			if(++count == m){
				last.next = head.next;
				count = 0;
			}else{
				last = last.next;
			}
			head = last.next;
		}
		return head;
	}
	public Node josehusKill2(Node head,int m){
		Node cur = head.next;
		int tmp = 1;
		while(cur!=head){
			tmp++;
			cur = cur.next;
		}
		int real = getlive(tmp,m);
		while(--real!=0){
			head = head.next;
		}
		head.next = head;//截断节点
		return head;
	}
	public int getlive(int i,int m){
		if(i == 1){
			return 1;
		}
		return (getlive(i-1,m) + m - 1)%i+1;
	}
}

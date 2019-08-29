package sdu.edu.Structure.Tree;

public class Main {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        Node n = reverseByK(n1, 3);
        while(n != null){
            System.out.println(n.val);
            n = n.next;
        }

    }
    
    public static Node reverseByK(Node head,int k){
        Node dummy = new Node(0);
        dummy.next = head;
        int i = 0;
        Node cur = head;
        Node pre = dummy;
        while(cur != null){
            if(i == k){
                pre = reverse(pre,cur);
                i = 0;
            }else{
                i++;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
    
    public static Node reverse(Node left,Node right){
        Node pre = left.next;
        Node cur = pre.next;
        Node next = null;
        Node head = pre;
        pre.next = right;
        while(cur != right){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        left.next = pre;
        return head;
    }
    
    
    static class Node{
        Node next;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    
}

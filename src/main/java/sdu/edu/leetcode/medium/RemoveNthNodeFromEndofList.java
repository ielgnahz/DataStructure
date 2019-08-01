package sdu.edu.leetcode.medium;

import sdu.edu.leetcode.Util.ListNode;

public class RemoveNthNodeFromEndofList {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        ListNode cur2 = dummy;
        cur2.next = head;

        while(n != 0 && head != null){
            head = head.next;
            n--;
        }

        if(n != 0){
            return dummy.next;
        }
        while(head != null){
            head = head.next;
            cur2 = cur2.next;
        }
        cur2.next = cur2.next.next;
        return dummy.next;
    }

}

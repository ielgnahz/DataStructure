package sdu.edu.leetcode.medium;

import sdu.edu.leetcode.Util.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){

        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        int c = 0;
        while(l1 != null && l2 != null){
            int cur = (l1.val + l2.val + c) % 10;
            c = (l1.val + l2.val + c) / 10;
            head.next = new ListNode(cur);
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            int cur = (l1.val + c) % 10;
            c = (l1.val + c) / 10;
            head.next = new ListNode(cur);
            head = head.next;
            l1 = l1.next;
        }

        while(l2 != null){
            int cur = (l2.val + c) % 10;
            c = (l2.val + c) / 10;
            head.next = new ListNode(cur);
            head = head.next;
            l2 = l2.next;
        }

        if(c != 0){
            head.next = new ListNode(c);
        }
        return dummy.next;
    }
}

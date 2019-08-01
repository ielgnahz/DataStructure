package sdu.edu.leetcode.medium;

import sdu.edu.leetcode.Util.ListNode;

public class SwapNodesinPairs {

    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode next = head.next;

        while(cur != null && next != null){
            cur.next = next.next;
            pre.next = next;
            next.next = cur;
            pre = cur;
            cur = cur.next;
            next = cur != null?cur.next:null;
        }
        return dummy.next;



    }

}

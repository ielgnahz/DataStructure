package sdu.edu.leetcode.hard;

import sdu.edu.leetcode.Util.ListNode;

public class ReverseNodesinkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k <= 1) return head;
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        dummy.next = head;
        while(pre != null){
            pre = reverse(pre ,k);
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode left, int k){
        ListNode right = left;
        while(right != null && k != 0){
            right = right.next;
            k--;
        }
        if(right == null){
            return null;
        }else{
            right = right.next;
            ListNode pre = left.next;
            ListNode cur  = pre.next;
            ListNode next = null;
            ListNode head = pre;
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
    }


}

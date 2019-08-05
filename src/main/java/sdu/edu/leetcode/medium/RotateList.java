package sdu.edu.leetcode.medium;

import sdu.edu.leetcode.Util.ListNode;

public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0){
            return head;
        }
        ListNode cur = head.next;
        ListNode pre = head;
        int len = 2;
        while(cur.next != null){
            pre = pre.next;
            cur = cur.next;
            len++;
        }
        k %= len;

        while(k != 0){
            cur.next = head;
            pre.next = null;
            head= cur;
            cur = pre;
            ListNode zero = head;
            while(zero.next.next != null){
                zero = zero.next;
            }
            pre = zero;
            k--;
        }
        return head;
    }

}

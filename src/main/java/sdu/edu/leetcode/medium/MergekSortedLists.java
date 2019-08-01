package sdu.edu.leetcode.medium;

import sdu.edu.leetcode.Util.ListNode;

public class MergekSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        return MergeSort(lists, 0, lists.length - 1);
    }

    public ListNode MergeSort(ListNode[] lists, int left, int right){
        if(left == right){
            return lists[left];
        }
        int mid = (left + right) / 2;
        ListNode l = MergeSort(lists, left, mid);
        ListNode r = MergeSort(lists, mid + 1, right);
        return getAdd(l, r);
    }

    public ListNode getAdd(ListNode l, ListNode r){
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while(l != null && r != null){
            if(l.val < r.val){
                head.next = l;
                head = head.next;
                l = l.next;
            }else{
                head.next = r;
                head = head.next;
                r = r.next;
            }
        }
        if(l != null){
            head.next = l;
        }
        if(r != null){
            head.next = r;
        }
        return dummy.next;
    }

}

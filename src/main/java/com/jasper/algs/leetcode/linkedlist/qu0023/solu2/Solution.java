package com.jasper.algs.leetcode.linkedlist.qu0023.solu2;

import com.jasper.algs.leetcode.linkedlist.ListNode;

/**
 * 0023. 合并K个排序链表
 *
 * <p> 分治合并
 */
class Solution {
	public ListNode mergeKLists(ListNode[] lists) {
		
        return mergeKLists(lists, 0, lists.length-1);
    }

    ListNode mergeKLists(ListNode[] lists, int left, int right) {
        if(left > right) return null;
        if(left==right) return lists[left];
        int mid = (left+right)/2;
        return mergeKLists(mergeKLists(lists, left, mid), mergeKLists(lists, mid+1, right));
    }

    ListNode mergeKLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), cur = dummy;
        while(l1!=null && l2!=null) {
            if(l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        if(l1==null) cur.next = l2;
        else cur.next = l1;
        return dummy.next;
    }
}
package com.jasper.algs.leetcode.linkedlist.qu0023.solu1;

import com.jasper.algs.leetcode.linkedlist.ListNode;

/**
 * 0023. 合并K个排序链表
 *
 * <p> 顺序合并
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
    	int k = lists.length;
        ListNode dummy = new ListNode(0);
        for(int i=0; i<k; i++) {
            ListNode l1 = dummy.next, l2 = lists[i], cur = dummy;
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
            else if(l2==null) cur.next = l1;
        }

        return dummy.next;
    }
}
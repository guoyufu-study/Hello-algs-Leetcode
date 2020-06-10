package com.jasper.algs.leetcode.linkedlist.qu0234.solu1;

import com.jasper.algs.leetcode.linkedlist.ListNode;

/**
 * 0234. 回文链表
 * 
 * <p>
 * 找中间节点 + 反转链表 + 相同链表
 */
class Solution {

	public boolean isPalindrome(ListNode head) {
        // 找到中间节点
        ListNode slow=head, fast=head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 反转链表
        ListNode prev = null, cur = head, next = head;
        while(cur!=slow) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        // 相同链表
        ListNode left = prev, right = slow;
        if(fast!=null) right = slow.next;
        while(right!=null) {
            if(left.val!=right.val)
                return false;
            left = left.next;
            right = right.next;
        }


        return true;
    }
}

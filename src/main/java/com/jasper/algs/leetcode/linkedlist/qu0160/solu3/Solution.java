package com.jasper.algs.leetcode.linkedlist.qu0160.solu3;

import com.jasper.algs.leetcode.linkedlist.ListNode;

/**
 * 0160. 相交链表
 * 
 * <p> 双指针
 */
public class Solution {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 边界
        if(headB==null || headA==null)
            return null;

        // 尾节点相同，则相交
        ListNode a=headA, b=headB;
        while(a.next!=null) a = a.next;
        while(b.next!=null) b = b.next;
        if(a!=b) 
        	return null;

        
        a=headA; b=headB;
        int twice = 2;
        while (twice>0) {
        	while(a!=null && b!=null) {
                a = a.next;
                b = b.next;
            }
        	
            if(a==null) a= headB;
            else b = headA;
            
            twice--;
        }
        
        while(a!=b) {
            a = a.next;
            b = b.next;
        }
        
        return a;
    }
}

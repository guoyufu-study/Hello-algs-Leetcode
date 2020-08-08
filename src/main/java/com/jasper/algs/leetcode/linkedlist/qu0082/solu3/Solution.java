package com.jasper.algs.leetcode.linkedlist.qu0082.solu3;

import com.jasper.algs.leetcode.linkedlist.ListNode;

/**
 * 0082. 删除排序链表中的重复元素 II
 * 
 * <p> 滑动窗口
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
    	
    	// 边界
    	if(head == null || head.next == null) 
    		return head;
    	
        ListNode dummy = new ListNode(0);  // 建立一个虚拟头结点
        ListNode tail = dummy;  // 定义一个尾巴，用于尾插法。
        for (ListNode l = head, r = head; l != null; l = r) {
            while (r != null && r.val == l.val) r = r.next;  // 只要r不为空并且与l的值相等则一直向后移动
            if (l.next == r) {  // 若长度为1，则通过尾插法加入。
                tail.next = l;  // 基本的尾插法                                         
                tail = l;                                               
                tail.next = null;  // 这里记得将尾部的后面置为null，不然可能后面会带着一些其他的节点。
            }
        }
        return dummy.next;
    }
}
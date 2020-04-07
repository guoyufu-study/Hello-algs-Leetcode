package com.jasper.algs.leetcode.linkedlist.qu0021;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	ListNode ans = new ListNode(0);//哑节点
    	ListNode curr = ans;//指针
    	
    	while(l1!=null && l2!=null) {
    		if(l1.val > l2.val) {
    			curr.next = l2;
    			l2 = l2.next;
    		} else {
    			curr.next = l1;
    			l1 = l1.next;
    		}
    		curr = curr.next;
    	}
    	
    	if(l1==null) curr.next = l2;
    	else curr.next = l1;
    	
    	return ans.next;
    }
    
    
    public static void main(String[] args) {
    	int[] a1 = {1,2,4};
    	int[] a2 = {1,3,4};
    	ListNode l1 = array2List(a1);
    	ListNode l2 = array2List(a2);
    	new Solution().mergeTwoLists(l1, l2);
	}
    
    private static ListNode array2List(int[] a) {
    	ListNode tmp = new ListNode(a[0]), ans = tmp;
    	for (int i = 1; i < a.length; i++) {
			ListNode node = new ListNode(a[i]);
			tmp.next = node;
			tmp = tmp.next;
		}
    	return ans;
    }
}
package com.jasper.algs.contest.biweekly.bc10.qu1214.solu2;

import java.util.Deque;
import java.util.LinkedList;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 1214. 查找两棵二叉搜索树之和
 * 
 * <p> 双指针
 */
class Solution {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
    	Deque<TreeNode> stack1 = new LinkedList<TreeNode>();
    	while(root1!=null) {
    		stack1.push(root1);
    		root1 = root1.left;
    	}
    	Deque<TreeNode> stack2 = new LinkedList<TreeNode>();
    	while(root2!=null) {
    		stack2.push(root2);
    		root2 = root2.right;
    	}
    	
    	while(!stack1.isEmpty() && !stack2.isEmpty()) {
    		root1 = stack1.peek();
    		root2 = stack2.peek();
    		int sum = root1.val + root2.val;
    		if(sum == target)
    			return true;
    		if(sum < target) {
    			stack1.poll();
				root1 = root1.right;
				while(root1!=null) {
		    		stack1.push(root1);
		    		root1 = root1.left;
		    	}
    		} else {
    			stack2.poll();
    			root2 = root2.left;
    			while(root2!=null) {
    				stack2.push(root2);
    				root2 = root2.right;
    			}
    		}
    	}
    	return false;
    }
}
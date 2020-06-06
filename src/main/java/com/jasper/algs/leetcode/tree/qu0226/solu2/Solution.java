package com.jasper.algs.leetcode.tree.qu0226.solu2;

import java.util.LinkedList;
import java.util.Queue;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 0226. 翻转二叉树
 * 
 * <p> 迭代实现
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
    	
    	if(root==null)
    		return root;
    	
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.offer(root);
    	while(!queue.isEmpty()) {
    		// 出队
    		TreeNode poll = queue.poll();
    		
    		// 左右子树入队
    		if(poll.left != null) queue.add(poll.left);
    		if(poll.right != null) queue.add(poll.right);
    		
    		// 交换左右子节点
    		TreeNode tmp = poll.left;
    		poll.left = poll.right;
    		poll.right = tmp;
    	}
    	
    	return root;
    }
}
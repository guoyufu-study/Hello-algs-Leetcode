package com.jasper.algs.leetcode.tree.qu0107.solu1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 107. 二叉树的层次遍历 II
 * 
 * <p> BFS + 头插
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

    	if(root==null) return new LinkedList<>();
    	
    	List<List<Integer>> ans = new LinkedList<>();
    	
    	Queue<TreeNode> queue = new LinkedList<>();
    	queue.offer(root);
    	
    	while(!queue.isEmpty()) {
    		List<Integer> level = new ArrayList<Integer>();
    		
    		int size = queue.size();
    		for (int i = 0; i < size; i++) {
				// 出队
    			TreeNode poll = queue.poll();
    			
    			// 入队
    			if(poll.left!=null)
    				queue.offer(poll.left);
    			if(poll.right!=null)
    				queue.offer(poll.right);
    			
    			// 构造答案
    			level.add(poll.val);
			}
    		
    		// 头插
    		ans.add(0, level);
    	}
    	
    	return ans;
    }
    
    public static void main(String[] args) {
    	// [[15, 7], [9, 20], [3]]
    	TreeNode root = new TreeNode(3);
    	root.left = new TreeNode(9);
    	root.right = new TreeNode(20);
    	root.right.left = new TreeNode(15);
    	root.right.right = new TreeNode(7);
    	
		System.out.println(new Solution().levelOrderBottom(root));
	}
}
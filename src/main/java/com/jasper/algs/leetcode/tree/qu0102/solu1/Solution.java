package com.jasper.algs.leetcode.tree.qu0102.solu1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 0102. 二叉树的层序遍历
 * 
 * <p> BFS
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

    	if(root==null) return new ArrayList<List<Integer>>();
    	
    	List<List<Integer>> ans = new ArrayList<List<Integer>>();
    	
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.add(root);
    	while(!queue.isEmpty()) {
    		int size = queue.size();
    		List<Integer> level = new ArrayList<Integer>();
    		for (int i = 0; i < size; i++) {
    			// 出队
				TreeNode node = queue.poll();
				
				// 构造答案
				level.add(node.val);
				
				// 入队
				if(node.left!=null)
					queue.offer(node.left);
				if(node.right!=null)
					queue.offer(node.right);
			}
    		ans.add(level);
    	}
    		
    	return ans;
    }
    
    public static void main(String[] args) {
    	// [[3], [9, 20], [15, 7]]
    	TreeNode root = new TreeNode(3);
    	root.left = new TreeNode(9);
    	root.right = new TreeNode(20);
    	root.right.left = new TreeNode(15);
    	root.right.right = new TreeNode(7);
    	
		System.out.println(new Solution().levelOrder(root));
		
	}
}
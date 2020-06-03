package com.jasper.algs.leetcode.tree.qu0104.solu1;

import java.util.LinkedList;
import java.util.Queue;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 0104. 二叉树的最大深度
 * 
 * <p> DFS
 */
class Solution {
    public int maxDepth(TreeNode root) {

    	if(root==null) 
    		return 0;
    	
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.offer(root);
    	
    	int ans = 0;
    	while(!queue.isEmpty()) {
    		ans++;
    		
    		int size = queue.size();
    		for (int i = 0; i < size; i++) {
    			// 出队
    			TreeNode node = queue.poll();
    			
    			// 入队
    			if(node.left!=null)
    				queue.offer(node.left);
    			if(node.right!=null)
    				queue.offer(node.right);
			}
    	}
    	
    	return ans;
    }
    
    public static void main(String[] args) {
    	// 3
    	TreeNode root = new TreeNode(3);
    	root.left = new TreeNode(9);
    	root.right = new TreeNode(20);
    	root.right.left = new TreeNode(15);
    	root.right.right = new TreeNode(7);
    	
		System.out.println(new Solution().maxDepth(root));
	}
}
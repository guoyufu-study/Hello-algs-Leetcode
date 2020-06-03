package com.jasper.algs.leetcode.tree.qu0111.solu1;

import java.util.LinkedList;
import java.util.Queue;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 0111. 二叉树的最小深度
 * 
 * <p> DFS
 */
class Solution {
    public int minDepth(TreeNode root) {

    	if(root==null) return 0;
    	
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.offer(root);
    	int ans = 0;
    	while(!queue.isEmpty()) {
    		int size = queue.size();
    		ans++;
    		for (int i = 0; i < size; i++) {
    			// 出队
				TreeNode node = queue.poll();
				
				// 叶子节点
				if(node.left==null && node.right==null)
					return ans;
				
				// 入队
				if(node.left!=null){
					queue.offer(node.left);
				} 
				if(node.right!=null) {
					queue.offer(node.right);
				}
			}
    	}
    	
    	return -1;
    }
    
    public static void main(String[] args) {
    	// 2
    	TreeNode root = new TreeNode(3);
    	root.left = new TreeNode(9);
    	root.right = new TreeNode(20);
    	root.right.left = new TreeNode(15);
    	root.right.right = new TreeNode(7);
    	
		System.out.println(new Solution().minDepth(root));
	}
}
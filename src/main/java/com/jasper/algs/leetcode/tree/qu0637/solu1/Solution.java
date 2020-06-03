package com.jasper.algs.leetcode.tree.qu0637.solu1;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 0637. 二叉树的层平均值
 * 
 * <p> 层序遍历
 */
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {

    	List<Double> ans = new LinkedList<Double>();
    	
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.add(root);
    	while(!queue.isEmpty()) {
    		double sum = 0;
    		int size = queue.size();
    		
    		for (int i = 0; i < size; i++) {
    			// 出队
    			TreeNode node = queue.poll();
    			
    			// 入队
    			if(node.left!=null)
    				queue.offer(node.left);
    			if(node.right!=null)
    				queue.offer(node.right);
    			
    			// 求和
				sum += node.val;
			}
    		
    		// 求平均值
    		ans.add(sum/size);
    		
    	}
    	
    	return ans;
    }
    
    public static void main(String[] args) {
    	// [3, 14.5, 11]
    	TreeNode root = new TreeNode(3);
    	root.left = new TreeNode(9);
    	root.right = new TreeNode(20);
    	root.right.left = new TreeNode(15);
    	root.right.right = new TreeNode(7);
    	
		System.out.println(new Solution().averageOfLevels(root));
	}
}
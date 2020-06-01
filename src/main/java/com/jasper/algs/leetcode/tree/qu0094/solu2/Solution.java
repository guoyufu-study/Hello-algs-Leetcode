package com.jasper.algs.leetcode.tree.qu0094.solu2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.jasper.algs.leetcode.tree.TreeNode;


/**
 * 0094. 二叉树的中序遍历
 * 
 * <p> 迭代实现
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {

    	// 中序遍历
    	List<Integer> ans = new ArrayList<Integer>();
    	
    	// 辅助栈
    	Stack<TreeNode> helper = new Stack<TreeNode>();
    	while(root!=null || !helper.isEmpty()) {
    		while(root!=null) {
    			// 中节点
    			helper.push(root);
    			// 左子节点
    			root = root.left;
    		}
    		
    		// 中节点
    		root = helper.pop();
    		ans.add(root.val);
    		
    		// 右子节点
    		root = root.right;
    	}
    	
    	return ans;
    }

}
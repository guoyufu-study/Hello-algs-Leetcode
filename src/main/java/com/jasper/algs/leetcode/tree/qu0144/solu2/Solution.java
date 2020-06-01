package com.jasper.algs.leetcode.tree.qu0144.solu2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 0144. 二叉树的前序遍历
 * 
 * <p> 迭代实现
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {

    	ArrayList<Integer> ans = new ArrayList<Integer>();
    	
    	// 辅助栈
    	Stack<TreeNode> helper = new Stack<TreeNode>();
    	while(root!=null || !helper.isEmpty()) {
    		while(root!=null) {
    			// 中节点
    			ans.add(root.val);
    			helper.push(root);
    			
    			// 左子节点
    			root = root.left;
    		}
    		// 右子节点
    		root = helper.pop().right;
    	}
    	
    	return ans;
    }

}
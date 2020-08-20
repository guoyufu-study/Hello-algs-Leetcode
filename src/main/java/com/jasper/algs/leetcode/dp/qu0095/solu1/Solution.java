package com.jasper.algs.leetcode.dp.qu0095.solu1;

import java.util.LinkedList;
import java.util.List;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 0095. 不同的二叉搜索树 II
 * 
 * <p> 递归
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
    	if(n==0)
    		return new LinkedList<TreeNode>();
    	
    	return generateTrees(1, n);
    }

	private List<TreeNode> generateTrees(int start, int end) {
		LinkedList<TreeNode> ans = new LinkedList<TreeNode>();
		if(start>end) {
			ans.add(null);
			return ans;
		}
		
		for(int i=start; i<=end; i++) {
			List<TreeNode> leftTrees = generateTrees(start, i-1);
			List<TreeNode> rightTrees = generateTrees(i+1, end);
			for (TreeNode left : leftTrees) {
				for (TreeNode right : rightTrees) {
					TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    ans.add(node);
				}
			}
		}
		
		return ans;
	}
}
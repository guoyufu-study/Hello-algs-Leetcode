package com.jasper.algs.leetcode.dp.qu0337.solu1;

import java.util.HashMap;
import java.util.Map;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 0337. 打家劫舍 III
 * 
 * <p> 动态规划
 */
class Solution {
	
	private Map<TreeNode, Integer> memo = new HashMap<>();
    public int rob(TreeNode root) {
    	// 边界
    	if(root==null)
    		return 0;
    	if(memo.containsKey(root))
    		return memo.get(root);
    	int max = Math.max(rob(root.left)+rob(root.right), 
    			root.val 
    			+ (root.left==null ? 0 : (rob(root.left.left) + rob(root.left.right)))
    			+ (root.right==null ? 0 : (rob(root.right.left)+ rob(root.right.right))));
    	memo.put(root, max);
    	return max;
    }
}
package com.jasper.algs.leetcode.tree.qu0108.solu1;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 0108. 将有序数组转换为二叉搜索树
 * 
 * <p> 中序遍历：总是选择中间位置左边的数字作为根节点
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {

    	return sortedArrayToBST(nums, 0, nums.length-1);
    }

	private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
		if(left>right) 
			return null;
		int mid = (right-left)/2 + left;
    	TreeNode node = new TreeNode(nums[mid]);
    	node.left = sortedArrayToBST(nums, left, mid-1);
    	node.right = sortedArrayToBST(nums, mid+1, right);
		return node;
	}
}
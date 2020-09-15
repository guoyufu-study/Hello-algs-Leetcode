package com.jasper.algs.interview.qu0402.solu1;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 面试题 04.02. 最小高度树
 * 
 * <p> 二分查找 + 前序遍历
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        
        return sortedArrayToBST(nums, 0, n-1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if(start>end) return null;
        
        int mid = (end - start)/2 + start;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, start, mid-1);
        root.right = sortedArrayToBST(nums, mid+1, end);
        return root;
    }
}
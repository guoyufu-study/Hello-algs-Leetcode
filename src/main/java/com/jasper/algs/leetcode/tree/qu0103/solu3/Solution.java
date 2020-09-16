package com.jasper.algs.leetcode.tree.qu0103.solu3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * 
 * <p> 层序遍历 + 倒序
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> ans = new ArrayList<>();
    	Deque<TreeNode> queue = new LinkedList<TreeNode>();
    	if(root!=null) queue.offer(root);
    	while(!queue.isEmpty()) {
    		int len = queue.size();
    		List<Integer> tmp = new ArrayList<Integer>();
    		for (int i = 0; i < len; i++) {
				TreeNode node = queue.poll();
				tmp.add(node.val);
				if(node.left!=null) queue.offer(node.left);
				if(node.right!=null) queue.offer(node.right);
			}
    		ans.add(tmp);
    	}
    	
    	int level = ans.size();
    	for (int i = 0; i < level; i++) {
			if(i%2==1) Collections.reverse(ans.get(i));
		}
    	
    	return ans;
    }
}
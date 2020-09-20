package com.jasper.algs.leetcode.tree.qu0314.solu2;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 0314. 二叉树的垂直遍历
 * 
 * <p> DFS 找边界 + BFS 层序遍历
 */
class Solution {
    List<List<Integer>> ans;
    int min = 0, max = 0;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        ans = new LinkedList<>();
        if(root==null) return ans;

        // DFS 找边界
        getMaxMin(0, root);
        for(int i=min; i<=max; i++) {
            ans.add(new ArrayList<Integer>());
        }
        
        // BFS 构造答案
        Deque<TreeNode> nodes = new LinkedList<>();
        if(root!=null) nodes.offer(root);
        Deque<Integer> indexs = new LinkedList<>();
        if(root!=null) indexs.offer(-min); // 根节点索引 -min
        while(!nodes.isEmpty()) {
            int index = indexs.poll();
            TreeNode node = nodes.poll();
            if(node.left!=null) {
                nodes.offer(node.left);
                indexs.offer(index-1);
            }
            if(node.right!=null) {
                nodes.offer(node.right);
                indexs.offer(index+1);
            }
            
            ans.get(index).add(node.val);
        }

        return ans;
    }

    void getMaxMin(int index, TreeNode root) {
        if(root==null) return ;
        if(index < min) min = index;
        if(index > max) max = index;
        getMaxMin(index-1, root.left);
        getMaxMin(index+1, root.right);
    }

	public static void main(String[] args) {
		// [[15, 7], [9, 20], [3]]
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		System.out.println(new Solution().verticalOrder(root));
	}
}
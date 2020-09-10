package com.jasper.algs.leetcode.tree.qu0513.solu1;

import java.util.Deque;
import java.util.LinkedList;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 0513. 找树左下角的值
 * 
 * <p> 层序遍历
 */
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root); // 假设给定的根结点不为null
        int ans = 0;
        while(!queue.isEmpty()) {
            int len = queue.size();
            ans = queue.peek().val;
            for(int i=0; i<len; i++) {
                TreeNode node = queue.poll();
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
        }

        return ans;
    }
}
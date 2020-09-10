package com.jasper.algs.leetcode.tree.qu0515.solu1;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 0515. 在每个树行中找最大值
 *
 * <p> 层序遍历
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        if(root!=null) queue.offer(root);
        while(!queue.isEmpty()) {
            int len = queue.size();
            int max = queue.peek().val;
            for(int i=0; i<len; i++) {
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            ans.add(max);
        }

        return ans;
    }
}
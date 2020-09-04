package com.jasper.algs.leetcode.tree.qu1469.solu1;

import java.util.LinkedList;
import java.util.List;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 1469. 寻找所有的独生节点
 * 
 * <p> DFS 前序遍历 递归
 */
class Solution {
    List<Integer> ans = new LinkedList<>();
    public List<Integer> getLonelyNodes(TreeNode root) {
        if(root.left!=null) {
            if(root.right==null) ans.add(root.left.val);
            getLonelyNodes(root.left);
        }
        if(root.right!=null) {
            if(root.left==null) ans.add(root.right.val);
            getLonelyNodes(root.right);
        }

        return ans;
    }
}
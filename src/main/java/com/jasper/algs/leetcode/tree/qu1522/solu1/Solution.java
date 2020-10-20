package com.jasper.algs.leetcode.tree.qu1522.solu1;

import com.jasper.algs.leetcode.tree.Node;

/**
 * 1522. N 叉树的直径
 * 
 * <p> DFS 后序遍历
 */
class Solution {
	int ans;
    public int diameter(Node root) {
        lrd(root);
        return ans;
    }

    int lrd(Node root) {
        if(root==null) return 0;
        if(root.children.size()==0) return 1;
        int maxH = 0, secondH = 0;
        for(Node node : root.children) {
            int h = lrd(node);
            if(h>=maxH) {
                secondH = maxH;
                maxH = h;
            } else if(h>secondH) 
                secondH = h;
        }
        
        ans = Math.max(ans, maxH+secondH);
        return maxH+1;
    }
}
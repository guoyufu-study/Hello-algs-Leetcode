package com.jasper.algs.leetcode.tree.qu0559.solu1;

import java.util.ArrayList;

import com.jasper.algs.leetcode.tree.Node;

/**
 * 0559. N叉树的最大深度
 * 
 * <p> 递归
 */
class Solution {
    public int maxDepth(Node root) {
    	
    	if(root==null)
    		return 0;
    	
    	if(root.children==null)
    		return 1;
    	
    	int mc = 0;
    	for (Node node : root.children) {
			mc = Math.max(mc, maxDepth(node));
		}
    	
    	return mc + 1;
    }
    
    public static void main(String[] args) {
    	// 3
    	Node root = new Node(1);
		ArrayList<Node> children = new ArrayList<Node>();
		root.children = children;
		Node n3 = new Node(3);
		children.add(n3);
		children.add(new Node(2));
		children.add(new Node(4));
		
		children = new ArrayList<Node>();
		children.add(new Node(5));
		children.add(new Node(6));
		
		n3.children = children;
    	
		System.out.println(new Solution().maxDepth(root));
	}
}
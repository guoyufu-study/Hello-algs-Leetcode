package com.jasper.algs.leetcode.tree.qu0590.solu;

import java.util.ArrayList;
import java.util.List;

import com.jasper.algs.leetcode.tree.Node;

/**
 * 0590. N叉树的后序遍历
 * 
 * <p> 2刷
 */
class Solution {
    public List<Integer> postorder(Node root) {
        
    	return null;
    }
    
    public static void main(String[] args) {
    	// [5,6,3,2,4,1]
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
    	
		System.out.println(new Solution().postorder(root));
	}
}
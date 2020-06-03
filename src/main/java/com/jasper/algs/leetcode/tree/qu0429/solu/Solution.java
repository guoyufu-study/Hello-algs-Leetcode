package com.jasper.algs.leetcode.tree.qu0429.solu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.jasper.algs.leetcode.tree.Node;

/**
 * 0429. N叉树的层序遍历
 * 
 * <p> 2刷
 */
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
    	
    	List<List<Integer>> ans = new LinkedList<>();
    	
    	return ans;
    }
    
    public static void main(String[] args) {
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
		
		new Solution().levelOrder(root);
		
	}
}
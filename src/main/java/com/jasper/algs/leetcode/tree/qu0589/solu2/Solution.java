package com.jasper.algs.leetcode.tree.qu0589.solu2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import com.jasper.algs.leetcode.tree.Node;

/**
 * 0589. N叉树的前序遍历
 * 
 * <p> DFS 迭代
 */
class Solution {
    public List<Integer> preorder(Node root) {
        
    	if(root==null)
    		return new ArrayList<Integer>();
    	
    	List<Integer> ans = new ArrayList<Integer>();
    	
    	Stack<Node> stack = new Stack<Node>();
    	stack.push(root);
    	while(!stack.isEmpty()) {
    		// 出栈
    		Node node = stack.pop();
    		
    		ans.add(node.val);
    		
    		// 入栈
    		if(node.children==null) continue;
    		Collections.reverse(node.children);
    		stack.addAll(node.children);
    	}
    	
    	return ans;
    }
    
    public static void main(String[] args) {
    	// [1,3,5,6,2,4]
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
    	
		System.out.println(new Solution().preorder(root));
	}
}
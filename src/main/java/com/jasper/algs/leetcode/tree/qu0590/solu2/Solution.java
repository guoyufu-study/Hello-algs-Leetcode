package com.jasper.algs.leetcode.tree.qu0590.solu2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import com.jasper.algs.leetcode.tree.Node;

/**
 * 0590. N叉树的后序遍历
 * 
 * <p> DFS 迭代
 */
class Solution {
    public List<Integer> postorder(Node root) {
        
    	if(root==null)
    		return new ArrayList<Integer>();
    	
    	List<Integer> ans = new LinkedList<Integer>();
    	Stack<Node> stack = new Stack<>();
    	stack.push(root);
    	
    	while(!stack.isEmpty()) {
    		// 出栈
    		Node node = stack.pop();
    		
    		// 头插
    		ans.add(0, node.val);
    		
    		// 入栈
    		if(node.children!=null) {
    			stack.addAll(node.children);
    		}
    	}
    	
    	return ans;
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
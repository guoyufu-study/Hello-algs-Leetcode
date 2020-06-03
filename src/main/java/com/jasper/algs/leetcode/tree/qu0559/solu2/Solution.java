package com.jasper.algs.leetcode.tree.qu0559.solu2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.jasper.algs.leetcode.tree.Node;

/**
 * 0559. N叉树的最大深度
 * 
 * <p> DFS
 */
class Solution {
    public int maxDepth(Node root) {
    	
    	if(root==null)
    		return 0;
    	
    	Queue<Node> queue = new LinkedList<Node>();
    	queue.offer(root);
    	int ans = 0;
    	while(!queue.isEmpty()) {
    		ans++;
    		int size = queue.size();
    		for (int i = 0; i < size; i++) {
				Node node = queue.poll();
				if(node.children!=null)
					queue.addAll(node.children);
			}
    	}
    	
    	return ans;
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
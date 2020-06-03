package com.jasper.algs.leetcode.tree.qu0429.solu1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.jasper.algs.leetcode.tree.Node;

/**
 * 0429. N叉树的层序遍历
 * 
 * <p> 利用队列实现广度优先搜索
 */
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
    	
        // 边界
    	if(root==null) 
    		return new ArrayList<List<Integer>>();
    	
    	List<List<Integer>> ans = new LinkedList<>();
    	
    	Queue<Node> queue = new LinkedList<Node>();
    	queue.offer(root);
    	while(!queue.isEmpty()) {
    		List<Integer> level = new ArrayList<Integer>();
    		int size = queue.size();
    		for (int i = 0; i < size; i++) {
    			Node poll = queue.poll();
    			level.add(poll.val);
    			if(poll.children!=null)
    				queue.addAll(poll.children);
			}
    		ans.add(level);
    	}
    	
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
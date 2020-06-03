package com.jasper.algs.leetcode.tree.qu0590.solu1;

import java.util.ArrayList;
import java.util.List;

import com.jasper.algs.leetcode.tree.Node;

/**
 * 0590. N叉树的后序遍历
 * 
 * <p> DFS 递归
 */
class Solution {
    public List<Integer> postorder(Node root) {
        
    	if(root==null)
    		return new ArrayList<Integer>();
    	
    	List<Integer> ans = new ArrayList<Integer>();
    	postorder(root, ans);
    	return ans;
    }
    
    private void postorder(Node root, List<Integer> ans) {
    	// 叶子节点
    	if(root.children==null) {
    		ans.add(root.val);
    		return ;
    	}
    	
    	// 子节点
    	for (Node node : root.children) {
			postorder(node, ans);
		}
    	
    	// 后序
    	ans.add(root.val);
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
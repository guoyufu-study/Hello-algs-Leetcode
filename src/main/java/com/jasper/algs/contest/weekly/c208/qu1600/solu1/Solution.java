package com.jasper.algs.contest.weekly.c208.qu1600.solu1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1600. 皇位继承顺序
 * 
 * <p> 多叉树+前序遍历
 */
class ThroneInheritance {
	
	class TreeNode {
		String name;
		List<TreeNode> children;
		boolean death;
		
		TreeNode(String name) {
			this.name = name;
			children = new ArrayList<ThroneInheritance.TreeNode>();
		}
	}
	
	TreeNode root;
	Map<String, TreeNode> map;
    public ThroneInheritance(String kingName) {
    	root = new TreeNode(kingName);
    	map = new HashMap<String, ThroneInheritance.TreeNode>();
    	map.put(kingName, root);
    }
    
    public void birth(String parentName, String childName) {
    	TreeNode parent = map.get(parentName);
    	TreeNode child = new TreeNode(childName);
    	parent.children.add(child);
    	map.put(childName, child);
    }
    
    public void death(String name) {
    	map.get(name).death = true;
    }
    
    public List<String> getInheritanceOrder() {
    	// 前序遍历
    	List<String> ans = new ArrayList<String>();
    	DLR(root, ans);
    	return ans;
    }

	private void DLR(TreeNode parent, List<String> memo) {
		if(!parent.death) memo.add(parent.name);
		for (TreeNode child : parent.children) 
			DLR(child, memo);
	}
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */
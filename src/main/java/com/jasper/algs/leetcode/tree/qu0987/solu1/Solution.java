package com.jasper.algs.leetcode.tree.qu0987.solu1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.jasper.algs.leetcode.tree.TreeNode;

/**
 * 0987. 二叉树的垂序遍历
 * 
 * <p> DFS 记录坐标 + 排序
 */
class Solution {
	
	List<Location> locations;
	
    public List<List<Integer>> verticalTraversal(TreeNode root) {
    	// 边界
    	if(root==null)
    		return new ArrayList<List<Integer>>();
    	
    	// DFS 组织数据
    	locations = new ArrayList<Solution.Location>();
    	dfs(root, 0, 0);
    	
    	// 排序
    	Collections.sort(locations);
    	
    	// 构造答案
    	List<List<Integer>> ans = new ArrayList<List<Integer>>();
    	int x = 1;
    	List<Integer> list = null;
    	for (Location location : locations) {
			if(location.x!=x) {
				list = new ArrayList<Integer>();
				ans.add(list);
				x = location.x;
			}
			
			list.add(location.val);
		}
    	return ans;
    }
    
    private void dfs(TreeNode root, int x, int y) {
		
		locations.add(new Location(x, y, root.val));
		
		if(root.left!=null)
			dfs(root.left, x-1, y-1);
		if(root.right!=null)
			dfs(root.right, x+1, y-1);
	}
    
    class Location implements Comparable<Location>{
        int x, y, val;
        Location(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Location that) {
            if (this.x != that.x)
                return Integer.compare(this.x, that.x);
            else if (this.y != that.y)
                return Integer.compare(that.y, this.y);
            else
                return Integer.compare(this.val, that.val);
        }
    }

	public static void main(String[] args) {
    	// [[9], [3, 15], [20], [7]]
    	TreeNode root = new TreeNode(3);
    	root.left = new TreeNode(9);
    	root.right = new TreeNode(20);
    	root.right.left = new TreeNode(15);
    	root.right.right = new TreeNode(7);
    	
		System.out.println(new Solution().verticalTraversal(root));
	}
}
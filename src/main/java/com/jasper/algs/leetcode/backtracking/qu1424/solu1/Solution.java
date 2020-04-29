package com.jasper.algs.leetcode.backtracking.qu1424.solu1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1424. 对角线遍历 II
 * 
 * <p>1. 聚类重构
 */
class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
    	// 边界处理
    	if(nums==null || nums.size()==0)
    		return new int[0];
    	
    	int rows = nums.size();
    	
    	// 聚类缓存
    	Map<Integer, List<Integer>> helper = new HashMap<Integer, List<Integer>>();
    	int count = 0;
    	for (int r = 0; r < rows; r++) {
    		List<Integer> list = nums.get(r);
    		int cols = list.size();
			for (int c = 0; c < cols; c++) {
				int k = r+c;
				if(!helper.containsKey(k)) helper.put(k, new ArrayList<Integer>());
				helper.get(k).add(nums.get(r).get(c));
				count++;
			}
		}
    	
    	// 构造答案
		int[] ans = new int[count];
		int i = 0;
		int keys = helper.size(); // 聚类大小
		for (int k = 0; k < keys; k++) {
			List<Integer> list = helper.get(k);
			for (int j = list.size()-1; j >=0; j--)//翻转
				ans[i++] = list.get(j);
		}
		
		return ans;
    }
}
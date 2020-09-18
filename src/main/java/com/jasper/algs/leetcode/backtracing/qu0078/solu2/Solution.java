package com.jasper.algs.leetcode.backtracing.qu0078.solu2;

import java.util.ArrayList;
import java.util.List;

/**
 * 0078. 子集
 * 
 * <p> 逐个添加元素：迭代
 */
class Solution {
	
	@SuppressWarnings("serial")
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
    	ans.add(new ArrayList<Integer>()); // 空子集
    	
    	for (int num : nums) {
			int len = ans.size();
			for (int i = 0; i < len; i++) {
				ans.add(new ArrayList<Integer>(ans.get(i)) {{add(num);}});
			}
		}
    	
    	return ans;
    }

}
package com.jasper.algs.leetcode.backtracing.qu0090.solu2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 0090. 子集 II
 * 
 * <p> 逐渐添加元素：迭代
 */
class Solution {
    @SuppressWarnings("serial")
	public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<Integer>());
        
        int start = 0;
        for (int i = 0; i < n; i++) {
        	final int num = nums[i];
        	if(i==0 || num!=nums[i-1]) start = 0; // 非重复元素，从0开始
        	int len = ans.size();
			for (int j = start; j < len; j++) {
				ans.add(new ArrayList<Integer>(ans.get(j)) {{add(num);}});
			}
			
			start = len; // 重复元素时，只考虑上一步的新解。
		}

        return ans;
    }

}
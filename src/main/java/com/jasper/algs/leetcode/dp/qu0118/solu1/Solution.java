package com.jasper.algs.leetcode.dp.qu0118.solu1;

import java.util.ArrayList;
import java.util.List;

/**
 * 0118. 杨辉三角
 * 
 * <p> 动态规划
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> triangle = new ArrayList<List<Integer>>();
    	if(numRows==0) return triangle;
    	
    	triangle.add(new ArrayList<Integer>());
    	triangle.get(0).add(1);
    	for (int i = 1; i < numRows; i++) {
			List<Integer> prev = triangle.get(i-1);
			List<Integer> list = new ArrayList<Integer>();
			list.add(1);
			for (int j = 1; j < i; j++) {
				list.add(prev.get(j) + prev.get(j-1));
			}
			list.add(1);
			triangle.add(list);
		}
    	return triangle;
    }
}
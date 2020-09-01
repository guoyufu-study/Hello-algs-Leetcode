package com.jasper.algs.leetcode.dp.qu0119.solu1;

import java.util.ArrayList;
import java.util.List;

/**
 * 0119. 杨辉三角 II
 * 
 * <p> 动态规划
 */
class Solution {
    public List<Integer> getRow(int rowIndex) {

    	List<Integer> ans = new ArrayList<Integer>();
    	ans.add(1);
    	for (int i = 1; i <= rowIndex; i++) {
    		int prev = 1;
			for (int j = 1; j < i; j++) {
				int num = ans.get(j)+prev;
				prev = ans.get(j);
				ans.set(j, num);
			}
			ans.add(1);
		}
    	
    	return ans;
    }
}
package com.jasper.algs.leetcode.dynamicprogramming.qu0830.solu2;

import java.util.ArrayList;
import java.util.List;

/**
 * 0830. 较大分组的位置
 *
 * <p>动态规划
 */
class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
    	
    	int N = S.length();
    	
    	List<List<Integer>> ans = new ArrayList<>();
    	char c = S.charAt(0);
    	List<Integer> positions = new ArrayList<>();
    	int count = 1;
    	for (int i = 1; i < N; i++) {
			if(c==S.charAt(i))
				count++;
			else {
				if(count>=3) {// 记录
					positions.add(i-count);
					positions.add(i-1);
					ans.add(positions);
					positions = new ArrayList<>();
				}
				// 更新跟踪变量
				c = S.charAt(i);
				count = 1;
			}
		}
    	if(count>=3) {
    		positions.add(N-count);
			positions.add(N-1);
			ans.add(positions);
    	}
    	
    	return ans;
    }
}
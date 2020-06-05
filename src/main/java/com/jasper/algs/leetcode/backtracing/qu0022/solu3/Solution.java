package com.jasper.algs.leetcode.backtracing.qu0022.solu3;

import java.util.ArrayList;
import java.util.List;

/**
 * 0022. 括号生成
 * 
 * <p> 动态规划
 *
 */
class Solution {
    public List<String> generateParenthesis(int n) {
    	// 边界
    	if(n<=0) return new ArrayList<String>();
    	
    	List<List<String>> ans = new ArrayList<>();
    	ans.add(new ArrayList<String>());
    	ans.get(0).add("");
    	ans.add(new ArrayList<String>());
    	ans.get(1).add("()");
    	
    	for (int i = 2; i <= n; i++) {
    		ans.add(new ArrayList<String>());
			List<String> list = ans.get(i);
			for (int j = 0; j < i; j++) {
				List<String> tmp = ans.get(j);
				List<String> tmp2 = ans.get(i-1-j);
				for (int k = 0; k < tmp.size(); k++) {
					for (int k2 = 0; k2 < tmp2.size(); k2++) {
						list.add("(" + tmp2.get(k2)+")" + tmp.get(k));
					}
				}
			}
		}
    	
    	return ans.get(n);
    }

}
package com.jasper.algs.leetcode.backtracking.qu0022.solu1;

import java.util.ArrayList;
import java.util.List;

/**
 * 0022. 括号生成
 * 
 * <p>暴力求解
 *
 * <p> 尝试所有可能的括号组合，只记录有效的括号组合
 */
class Solution {
    public List<String> generateParenthesis(int n) {
    	// 边界
    	if(n<=0) return new ArrayList<String>();
    	
    	List<String> ans = new ArrayList<String>();
    	
    	generateParenthesis(0, new char[2*n], ans);
    	
    	
    	return ans;
    }

    /**
     * 生成有效括号组合
     * @param n			括号数
     * @param path		括号组合
     * @param ans		缓存
     */
	private void generateParenthesis(int n, char[] path, List<String> ans) {
		// 终止
		if(n==path.length) {
			if(valid(path)) // 记录有效组合
				ans.add(new String(path));
			return ;
		}
		
		// 尝试所有可能的组合
		path[n] = '(';
		generateParenthesis(n+1, path, ans);
		path[n] = ')';
		generateParenthesis(n+1, path, ans);
	}

	/**
	 * 验证有效括号组合
	 * 
	 */
	private boolean valid(char[] path) {
		int balance = 0;
		for (int i = 0; i < path.length; i++) {
			if(path[i]=='(') // 开括号
				balance++;
			else  // 闭括号，抵消开括号
				balance--;
			
			// 闭括号打头
			if(balance<0) return false;
		}
		
		// 开括号 vs 闭括号 成对出现
		return balance==0;
	}
}
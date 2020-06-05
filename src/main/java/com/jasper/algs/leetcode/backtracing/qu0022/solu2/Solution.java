package com.jasper.algs.leetcode.backtracing.qu0022.solu2;

import java.util.ArrayList;
import java.util.List;

/**
 * 0022. 括号生成
 * 
 * <p>回溯
 *
 * <p> 及时剪枝
 */
class Solution {
    public List<String> generateParenthesis(int n) {
    	// 边界
    	if(n<=0) return new ArrayList<String>();
    	
    	List<String> ans = new ArrayList<String>();
    	
    	backtrack(0, n, n, new char[2*n], ans);
    	
    	
    	return ans;
    }

    /**
     * 生成有效括号组合
     * 
     * @param n			括号数
     * @param open		开括号剩余可用数量
     * @param close		闭括号剩余可用数量
     * @param path		括号组合
     * @param ans		缓存
     */
	private void backtrack(int n, int open, int close, char[] path, List<String> ans) {
		// 终止
		if(n==path.length) {
			ans.add(new String(path));
			return ;
		}
		
		// 尝试所有可能的有效组合
		if(open>0) {
			path[n] = '(';
			backtrack(n+1, open-1, close, path, ans);
		}
		
		if(open<close) {
			path[n] = ')';
			backtrack(n+1, open, close-1, path, ans);
		}
		
	}

}
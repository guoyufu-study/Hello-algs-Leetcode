package com.jasper.algs.leetcode.backtracing.qu0017.solu1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 0017. 电话号码的字母组合
 * 
 * <p> 回溯
 */
class Solution {
	@SuppressWarnings("serial")
	static final Map<Character, String> phoneMap = new HashMap<Character, String>() {{
		put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
	}};
	
	int n;
	char[] digits;
	List<String> ans;
	
    public List<String> letterCombinations(String digits) {
    	n = digits.length();
    	this.digits = digits.toCharArray();
    	ans = new ArrayList<String>();
    	
    	if(n > 0)
    		dfs(0, new char[n]);
    	
    	return ans;
    }

	private void dfs(int index, char[] memo) {
		if(index==n) {
			ans.add(new String(memo));
			return ;
		}
		
		for (char c : phoneMap.get(digits[index]).toCharArray()) {
			memo[index] = c;
			dfs(index+1, memo);
		}
	}
}
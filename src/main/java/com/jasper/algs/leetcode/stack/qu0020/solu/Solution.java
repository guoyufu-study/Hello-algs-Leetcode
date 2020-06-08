package com.jasper.algs.leetcode.stack.qu0020.solu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 0020. 有效的括号
 * 
 * <p> 4刷
 */
class Solution {

	public boolean isValid(String s) {
		
		
		return false;
	}
	
	public static void main(String[] args) {
		
		// [true, true, false, false, true]
		String[] ss = new String[] {
				"()", // true
				"()[]{}", // true
				"(]", // false
				"([)]", // false
				"{[]}"  // true
				};
		
		final Solution solution = new Solution();
		List<Boolean> ans = Arrays.stream(ss)
			.map(solution::isValid)
			.collect(Collectors.toList());
		System.out.println(ans);
	}
	
}

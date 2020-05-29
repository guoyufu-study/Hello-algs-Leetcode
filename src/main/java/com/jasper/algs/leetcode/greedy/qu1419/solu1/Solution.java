package com.jasper.algs.leetcode.greedy.qu1419.solu1;

import java.util.HashMap;
import java.util.Map;

/**
 * 1419. 数青蛙
 * 
 * <p>
 * 贪心算法
 */
class Solution {
	private static final String CROAK = "croak";

	public int minNumberOfFrogs(String croakOfFrogs) {
		

		// 辅助数组
		int length = CROAK.length();
		int[] helper = new int[length];

		// 字典：字符 -> 辅助数组索引
		Map<Character, Integer> croak = new HashMap<Character, Integer>();
		for (int i = 0; i < length; i++) {
			croak.put(CROAK.charAt(i), i);
		}

		// 数青蛙
		int ans = 0;
		length = croakOfFrogs.length();
		for (int i = 0; i < length; i++) {
			char c = croakOfFrogs.charAt(i);
			int index = croak.get(c);
			// 遇到 c
			if (index == 0) {
				helper[0] += 1;
				ans = Math.max(ans, helper[0]);
			}

			// 遇到 r o a
			else if (index != 4) {
				// 错误
				if (helper[index] >= helper[index - 1])
					return -1;
				// 正确
				helper[index] += 1;
			}

			// 遇到k，清理
			else {
				// 错误
				if (helper[index] >= helper[index - 1])
					return -1;
				// 正确
				for (int j = 0; j < helper.length - 1; j++)
					helper[j] -= 1;
			}

		}

		// 未正确结束
		if (helper[0] != 0)
			return -1; 

		return ans;
	}

	public static void main(String[] args) {
		// 1
    	String croakOfFrogs = "croakcroak";
		
    	//2
//    	String croakOfFrogs = "crcoakroak";
    	
    	// -1
//    	String croakOfFrogs = "croakcrooak";
    	
    	// -1
//    	String croakOfFrogs = "aoocrrackk";

		System.out.println(new Solution().minNumberOfFrogs(croakOfFrogs));
	}
}
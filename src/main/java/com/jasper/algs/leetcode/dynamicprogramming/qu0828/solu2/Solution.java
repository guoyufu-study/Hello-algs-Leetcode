package com.jasper.algs.leetcode.dynamicprogramming.qu0828.solu2;

import java.util.ArrayList;
import java.util.List;

/**
 * 0828. 统计子串中的唯一字符
 * 
 * <p> 动态规划：字母分别计数
 */
class Solution {
    public int uniqueLetterString(String s) {
    	
    	int N = s.length();
    	int letters = 26;
    	
    	// 辅助数组
    	@SuppressWarnings("unchecked")
		List<Integer>[] helper = new List[letters];
    	// 初始化
    	for (int i = 0; i < letters; i++) {
			helper[i] = new ArrayList<Integer>();
		}
    	// 记录字母位置索引
    	for (int i = 0; i < N; i++) {
			helper[s.charAt(i)-'A'].add(i);
		}
    	
    	// 分别计数每个字母
    	long ans = 0;
    	for (int i = 0; i < letters; i++) {// 逐个字母计数
    		// 所有子字符串中，某个字符c，是独特字符的子串的个数。
			List<Integer> tmp = helper[i];
			int size = tmp.size();
			int start = 0;
			if(size!=0) start = tmp.get(0)+1;
			for (int j = 0; j < size; j++) { 
				int end = (j<size-1) ? tmp.get(j+1)-tmp.get(j) : N-tmp.get(j);
				ans += start*end;
				start = end;
			}
		}
    	
    	return (int)ans % (1_000_000_007);
    }
    
    public static void main(String[] args) {
//		String s = "AA";
		String s = "LEETCODE";
//		String s = "ABA";
//		String s = "ABC";
		
		System.out.println(new Solution().uniqueLetterString(s));
	}
}
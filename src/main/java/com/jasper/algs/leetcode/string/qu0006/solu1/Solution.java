package com.jasper.algs.leetcode.string.qu0006.solu1;

/**
 * 0006. Z字形变换
 *
 * <p> 按行排序
 */
public class Solution {

	public String convert(String s, int numRows) {
		
		// 边界
		if(numRows==1) return s;
		
		// 初始化
		numRows = Math.min(numRows, s.length());
		StringBuilder[] rows = new StringBuilder[numRows];
		for (int i = 0; i < numRows; i++) 
			rows[i] = new StringBuilder();
		
		// 按行排序
		int row=0;
		boolean goingDown = false;
		for (char c : s.toCharArray()) {
			rows[row].append(c);
			if(row==0 || row==numRows-1) goingDown = !goingDown;
			row += goingDown ? 1 : -1;
		}
		
		// 构造答案
		StringBuilder ans = new StringBuilder();
		for (StringBuilder sb : rows) 
			ans.append(sb);
		
		return ans.toString();
    }
}

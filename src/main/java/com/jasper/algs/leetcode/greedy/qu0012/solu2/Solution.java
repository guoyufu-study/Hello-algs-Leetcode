package com.jasper.algs.leetcode.greedy.qu0012.solu2;

/**
 * 0012. 整数转罗马数字
 * 
 * <p> 贪心算法
 */
class Solution {
	
	//  13 个符号序列
	int[] number = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
	String[] roman = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
	
	public String intToRoman(int num) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < number.length && num > 0; i++) {
			while (num >= number[i]) {
				num -= number[i];
				sb.append(roman[i]);
			}
		}
		
		return sb.toString();
	}
}
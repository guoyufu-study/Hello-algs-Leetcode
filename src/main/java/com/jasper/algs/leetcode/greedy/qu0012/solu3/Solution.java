package com.jasper.algs.leetcode.greedy.qu0012.solu3;

/**
 * 0012. 整数转罗马数字
 * 
 * <p> 硬编码数字
 */
class Solution {
	
	String[] thousands = {"", "M", "MM", "MMM"};
    String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}; 
    String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    
    public String intToRoman(int num) {
        
        return thousands[num / 1000] + hundreds[num % 1000 / 100] + tens[num % 100 / 10] + ones[num % 10];
    }
    
    
    public static void main(String[] args) {
    	// IX
    	int num = 9;
    	
		System.out.println(new Solution().intToRoman(num));
	}
}
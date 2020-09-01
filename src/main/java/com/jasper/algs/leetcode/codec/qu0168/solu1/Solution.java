package com.jasper.algs.leetcode.codec.qu0168.solu1;

/**
 * 0168. Excel表列名称
 * 
 * <p> 进制转换
 */
class Solution {
    public String convertToTitle(int n) {
    	StringBuilder ans = new StringBuilder();
    	while(n > 0) {
    		n--;
    		char c = (char) ((n) % 26 + 'A');
    		ans.append(c);
    		n /= 26;
    	}
    	
    	return ans.reverse().toString();
    }
}
package com.jasper.algs.leetcode.maths.qu0258.solu2;

/**
 * 0258. 各位相加
 * 
 * <p> 模9同余
 *
 */
class Solution {
    public int addDigits(int num) {
    	// 边界
    	if(num==0) return 0;
    	
    	// 模9同余，并改变取值范围[0,8] => [1,9]
    	return (num-1)%9 +1;
    }
}
package com.jasper.algs.leetcode.maths.qu0029.solu1;

class Solution {
    public int divide(int dividend, int divisor) {
    	// 处理溢出情况
    	if(divisor==Integer.MIN_VALUE) {//除数
    		if(dividend==Integer.MIN_VALUE) return 1;
    		return 0;
    	}
    	if(dividend==Integer.MIN_VALUE && divisor == -1)//被除数
    		return Integer.MAX_VALUE;
    	
    	int ans = 0;
    	
    	// 负数转正
    	boolean positive = true;// 结果正负号
    	if(dividend<0)  {
    		if(dividend==Integer.MIN_VALUE) {//被除数
    			dividend += divisor>0?divisor:-divisor;
        		ans += 1;
        	}
    		positive = !positive;
    		dividend = -dividend;
    	}
    	if(divisor<0) {
    		positive = !positive;
    		divisor = -divisor;
    	}
    	
    	// 正整数相除
    	// 位运算+泰勒展式
    	while(divisor <= dividend) {
    		int n = 0;
        	while(divisor<<n <= dividend>>1) { // 为确保(divisor<<n)不溢出，使其与(dividend>>1)比较
        		n++;
        	}
        	dividend -= divisor<<n;
        	ans+=1<<n;
    	}
    	
    	return positive? ans:-ans;
    }
    
    
    
    public static void main(String[] args) {
//    	int dividend = 6, divisor = 3;
    	int dividend = 7, divisor = -3;
    	
    	int ans = new Solution().divide(dividend, divisor);
    	System.out.println(ans);
	}
}
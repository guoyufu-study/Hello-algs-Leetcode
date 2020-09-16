package com.jasper.algs.sword2offer.qu064.solu2;

/**
 * 剑指 Offer 64. 求1+2+…+n
 * 
 * <p> 使用递归，使用 && 短路来终止递归
 */
class Solution {
    public int sumNums(int n) {
    	int sum = n;
    	
    	@SuppressWarnings("unused")
		boolean b = (n>1) && (sum += sumNums(n-1))>0;
    	
    	return sum;
    }
    
    public static void main(String[] args) {
		int n = 10000;
		System.out.println(new Solution().sumNums(n ));
	}
}
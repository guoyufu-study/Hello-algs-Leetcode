package com.jasper.algs.leetcode.sorting.qu0440.solu2;

/**
 * 0440. 字典序的第K小数字
 *
 * <p> 数学
 */
class Solution {
    public int findKthNumber(int n, int k) {
    	
    	int p = 1, //作为一个指针，指向当前所在位置，当p==k时，也就是到了排位第k的数
    		prefix = 1; // 前缀
    	while(p < k) {
    		int count = countNodes(prefix, n);
    		if(p+count>k) {// 在树下
    			p++;
    			prefix *= 10;
    		}  else {
    			p+=count;
    			prefix++;
    		}
    	}
    	return (int)prefix;
    }

	private int countNodes(long prefix, int n) {
		int count = 0;
		long next = prefix + 1;
		while(prefix <= n) {
			count += Math.min(n+1, next) - prefix;
			prefix *= 10;
			next *= 10;
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
	}
}
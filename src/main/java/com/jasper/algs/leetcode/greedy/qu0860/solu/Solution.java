package com.jasper.algs.leetcode.greedy.qu0860.solu;


/**
 * 0860. 柠檬水找零
 * 
 * <p> 2 刷
 */
class Solution {
    public boolean lemonadeChange(int[] bills) {

    	return false;
    }
    
    public static void main(String[] args) {
    	// true
//		int[] bills = new int[] {5,5,5,10,20};
		
		// true
//		int[] bills = new int[] {5,5,10};
		
		// false
//		int[] bills = new int[] {10,10};
		
		// false
		int[] bills = new int[] {5,5,10,10,20};
		
		
		System.out.println(new Solution().lemonadeChange(bills));
	}
}
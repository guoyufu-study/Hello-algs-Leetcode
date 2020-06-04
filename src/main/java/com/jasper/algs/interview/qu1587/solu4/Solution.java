package com.jasper.algs.interview.qu1587.solu4;

/**
 * 1587. 面试题 17.19. 消失的两个数字
 * 
 * <p>4. 位运算
 * 
 * <p>关键在于，如何排除其中一个缺失数字，将问题转变成求消失的一个数问题
 */
class Solution {
    public int[] missingTwo(int[] nums) {
    	
    	// 求x^y
    	int xor = 0;
    	for (int i = 0; i < nums.length; i++) {
    		xor ^= nums[i];
		}
    	int N = nums.length+2;
		for (int i = 1; i <= N; i++) {
			xor ^= i;
		}
		
		//求xy不同:最右侧的1
    	int diff = xor & -xor; 
    	
		// 排除y，求x
    	int x = 0;
		for (int i = 0; i < nums.length; i++) {
			if((diff & nums[i]) == 0)
				x ^= nums[i];
		}
		for (int i = 1; i <= N; i++) {
			if((diff & i) == 0) x ^= i;
		}
		
    	
    	return new int[] {x, xor^x};
    }
    
    
    public static void main(String[] args) {
    	
	}
}
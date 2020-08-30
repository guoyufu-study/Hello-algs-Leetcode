package com.jasper.algs.leetcode.maths.qu0264.solu;

/**
 * 0264. 丑数 II
 * 
 * <p> 4 刷
 */
class Solution {
	
	private static final Ugly u = new Ugly();
	
    public int nthUglyNumber(int n) {
    	
    	return u.nums[n-1];
    }
    
    static class Ugly {
    	
    	int[] nums = new int[1690];
    	
		Ugly() {
    		
    		nums[0] = 1;
    		int i2 = 0, i3 = 0, i5 = 0;
    		for (int i = 1; i < 1690; i++) {
    			nums[i] = Math.min(Math.min(nums[i2]*2, nums[i3]*3), nums[i5]*5);
    			if(nums[i]==nums[i2]*2) i2++;
    			if(nums[i]==nums[i3]*3) i3++;
    			if(nums[i]==nums[i5]*5) i5++;
			}
		}
    }
    
    public static void main(String[] args) {
    	// 12
		int n = 10;
		
		System.out.println(new Solution().nthUglyNumber(n));
	}
}
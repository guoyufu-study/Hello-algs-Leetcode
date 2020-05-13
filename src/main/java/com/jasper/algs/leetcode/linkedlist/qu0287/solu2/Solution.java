package com.jasper.algs.leetcode.linkedlist.qu0287.solu2;

/**
 * 位统计
 * 
 * <p>
 * 重复值某一位为1，则数组元素某一位上1的个数一定多于正常值；
 * 重复值某一位为0，则数组元素某一位上1的个数一定不多于正常值；
 */
class Solution {
    public int findDuplicate(int[] nums) {
    	
    	int ans = 0;
    	
    	int n = nums.length-1;
    	for (int i = 0; i < 31; i++) {
    		int count = 0;
    		for (int j = 0; j < nums.length; j++) {//数组元素某一位上1的个数
				if((nums[j]>>i & 1) ==1)
					count++;
			}
    		for (int j = 1; j <= n; j++) {//抵消某一位上1的个数
    			if((j>>i & 1) ==1)
					count--;
			}
    		
    		if(count>0) // 没有完全抵消，说明重复值在此位上是1
    			ans |= 1<<i;
		}
    	
    	
		return ans;
    }
    
    
    
    
    public static void main(String[] args) {
//    	int[] nums = new int[] {1,3,4,2,2};
    	int[] nums = new int[] {1,1};
    	
    	System.out.println(new Solution().findDuplicate(nums));
    	
	}
}
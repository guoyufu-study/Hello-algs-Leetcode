package com.jasper.algs.leetcode.maths.qu0169.solu3;

/**
 * 0169.求众数I
 * 
 * <p> 摩尔投票
 */
class Solution {
	
	public int majorityElement(int[] nums) {
		
        int ans = 0, // 候选人
        		votes = 0;// 计票
        for(int num : nums) {
        	// 尝试更换候选人
            if(votes==0) ans = num;
            votes += ans==num ? 1 // 投票
            		: -1;// 再抵消投票
        }
        return ans;
    }
	
    public int majorityElement2(int[] nums) {
    	
    	int candidate = nums[0], // 候选人
    			count = 1; // 计票
    	for (int i = 1; i < nums.length; i++) {
			if(count == 0) { // 先尝试更换候选人
				candidate = nums[i];
			}
			
			if(candidate != nums[i]) // 再抵消投票
				count--;
			else {// 投票
				count++;
			}
		}
    	
    	return candidate;
    }
}
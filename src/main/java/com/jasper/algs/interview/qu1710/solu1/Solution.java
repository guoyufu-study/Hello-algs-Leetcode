package com.jasper.algs.interview.qu1710.solu1;

/**
 * 面试题 17.10. 主要元素
 * 
 * <p> 摩尔投票
 */
class Solution {
    public int majorityElement(int[] nums) {
    	
    	int candidate = 0, // 候选人
        		votes = 0;// 计票
        for(int num : nums) {
        	// 尝试更换候选人
            if(votes==0) candidate = num;
            votes += candidate==num ? 1 // 投票
            		: -1;// 再抵消投票
        }
        
        int count = 0;
        for(int num : nums) 
        	if(num==candidate) count++;
        
        return count > nums.length/2 ? candidate : -1;
    }
}
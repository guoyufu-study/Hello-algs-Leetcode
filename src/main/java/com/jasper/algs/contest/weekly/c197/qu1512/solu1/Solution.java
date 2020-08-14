package com.jasper.algs.contest.weekly.c197.qu1512.solu1;

import java.util.HashMap;
import java.util.Map;

/**
 * 1512. 好数对的数目
 * 
 * <p> 辅助字典计数 + 组合公式
 */
class Solution {

	public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> helper = new HashMap<>();
        for(int num : nums) {
            helper.put(num, helper.getOrDefault(num, 0)+1);
        }
        
        int ans = 0;
        for (int count : helper.values()) {
			ans += (count-1) * count/2;
		}
        
        return ans;
    }
	
	
	public static void main(String[] args) {
		int[] nums = new int[] {1,2,3,1,1,3};
		System.out.println(new Solution().numIdenticalPairs(nums));
	}
}

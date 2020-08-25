package com.jasper.algs.contest.weekly.c197.qu1512.solu;

/**
 * 1512. 好数对的数目
 * 
 * <p> 3 刷
 */
class Solution {

	public int numIdenticalPairs(int[] nums) {
        int[] helper = new int[101];
        for(int num : nums) {
        	helper[num]++;
        }
        
        int ans = 0;
        for (int num : helper) {
			if(num>=2) {
				ans += num * (num - 1) / 2;
			}
		}
        return ans;
    }
	
	public static void main(String[] args) {
		int[] nums = new int[] {1,2,3,1,1,3};
		System.out.println(new Solution().numIdenticalPairs(nums));
	}
}

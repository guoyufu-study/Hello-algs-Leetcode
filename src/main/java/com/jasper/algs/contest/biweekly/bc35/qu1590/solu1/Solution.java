package com.jasper.algs.contest.biweekly.bc35.qu1590.solu1;

import java.util.HashMap;
import java.util.Map;

/**
 * 1590. 使数组和能被 P 整除
 * 
 * <p> 前缀和 + 辅助字典
 */
class Solution {
    public int minSubarray(int[] nums, int p) {
        
    	// 前缀和
        int n = nums.length;
        long[] prefixSum = new long[n+1];
        for(int i=0; i<n; i++) {
            prefixSum[i+1] = prefixSum[i] + nums[i];
        }
        if(prefixSum[n] % p==0) return 0;
        
        // 辅助字典：余数 -> 索引
        int target = p - (int)(prefixSum[n] % p), ans = n;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i=0; i<n; i++) {
            int key = (int)((prefixSum[i+1]+target)%p);
            if(map.containsKey(key)) 
                ans = Math.min(ans, i - map.get(key));
            map.put((int)(prefixSum[i+1]%p), i);
        }
        
        return ans==n ? -1 : ans;
    }
    
    public static void main(String[] args) {
    	
    	// 2
		int[] nums = new int[] {6,3,5,2};
		int p = 9;
//		int[] nums = new int[] {26,19,11,14,18,4,7,1,30,23,19,8,10,6,26,3};
//		int p = 26;
		
		System.out.println(new Solution().minSubarray(nums, p));
	}
}
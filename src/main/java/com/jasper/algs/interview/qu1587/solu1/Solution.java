package com.jasper.algs.interview.qu1587.solu1;

/**
 * 暴力求解：逐个比较
 */
class Solution {
    public int[] missingTwo(int[] nums) {
    	int[] ans = new int[2];
    	
    	int count = 0;
    	boolean missing = true;
		for (int i = 1; i <= ans.length + 2; i++) {
			for (int j = 0; j < ans.length; j++) { // 逐个比较
				if(i==nums[j]) {
					missing = false;//存在，不缺失
					break;
				}
			}
			if(missing) ans[count++] = i; // 记录缺失的数字
			if(count==2) break; // 全部找到
			missing = true;
		}
    	
    	return ans;
    }
}
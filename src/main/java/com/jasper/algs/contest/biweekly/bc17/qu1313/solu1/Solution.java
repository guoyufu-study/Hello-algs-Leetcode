package com.jasper.algs.contest.biweekly.bc17.qu1313.solu1;

/**
 * 1313. 解压缩编码列表
 * 
 * <p> 模拟
 */
class Solution {
    public int[] decompressRLElist(int[] nums) {
        int n = nums.length;
        // 长度
        int len = 0;
        for(int i=0; i<n; i+=2) 
            len += nums[i];
        
        // 解码
        int[] ans = new int[len];
        int ptr = 0;
        for(int i=0; i<n; i+=2) {
            for(int j=1; j<=nums[i]; j++) {
                ans[ptr++] = nums[i+1];
            }
        }

        return ans;
    }
}

package com.jasper.algs.contest.weekly.c182.qu1395.solu2;

/**
 * 1395. 统计作战单位数
 * 
 * <p> 暴力枚举：枚举中间元素
 */
class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int ans = 0;
        for(int j=0; j<n; j++) {
            int iless=0, imore=0,
            	kless=0, kmore=0;
            for (int i = 0; i < j; i++) {
				if(rating[i]<rating[j]) iless++;
				else imore++;
			}
            for (int k = j+1; k < n; k++) {
				if(rating[j]<rating[k]) kmore++;
				else kless++;
			}
            
            ans += iless*kmore + imore*kless;
        }
        
        return ans;
    }
}
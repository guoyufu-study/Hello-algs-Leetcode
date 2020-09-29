package com.jasper.algs.contest.weekly.c138.qu1052.solu1;

/**
 * 1052. 爱生气的书店老板
 * 
 * <p> 滑动窗口
 */
class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int n = customers.length;
        int ans = 0;
        // 不生气时，满意顾客
        for(int i=0; i<n; i++) 
            if(grumpy[i]==0) 
                ans += customers[i];
        
        // 抑制自己情绪时，最多能增加多少满意顾客
        int s = 0, e = 0, sum = ans;
        for(; e<X; e++) ans = sum += grumpy[e] * customers[e];
        while(e<n) {
            sum += grumpy[e] * customers[e++] - grumpy[s] * customers[s++];
            ans = Math.max(ans, sum);
        }

        return ans;
    }
}
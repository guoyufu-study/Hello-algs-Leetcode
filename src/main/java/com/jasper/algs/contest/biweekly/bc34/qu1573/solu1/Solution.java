package com.jasper.algs.contest.biweekly.bc34.qu1573.solu1;

/**
 * 1573. 分割字符串的方案数
 * 
 * <p> 数学
 */
class Solution {
	
    static final int mod = 1_000_000_007;
    
    public int numWays(String s) {
        int n = s.length();
        // 计数 1
        int k = 0;
        for(char c : s.toCharArray()) 
            if(c=='1') k++;
        
        // 全是0
        if(k==0) return (int)(1L * (n-2) * (n-1) / 2  % mod);
        
        // 1 不够分
        if(k%3!=0) return 0;

        // 找到第 k/3 k/3+1, k/3*2, k/3*2+1 个 1 的位置
        int count = 0, l2=0, l1=0, r1=0, r2=0;
        for(int i=0; i<n; i++) {
            if(s.charAt(i)=='1') {
                count++;
                if(count==k/3) l2 = i;
                else if(count==k/3*2+1) r2 = i;
                else {
                    if(count==k/3+1) l1 = i;
                    if(count==k/3*2) r1 = i;
                }
            }
        }
        return (int)(1L * (l1 - l2) * (r2 - r1) % mod);
    }
}
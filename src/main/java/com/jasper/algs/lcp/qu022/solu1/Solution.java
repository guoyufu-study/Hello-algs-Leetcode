package com.jasper.algs.lcp.qu022.solu1;

/**
 * LCP 22. 黑白方格画
 * 
 * <p> 数学
 */
class Solution {
    public int paintingPlan(int n, int k) {
        if(k==n*n) return 1;
        
        int ans = 0;
        for(int a=0; a<n; a++) 
            for(int b=0; b<n; b++) 
                if(a*n + b*n - a*b==k) 
                    ans += combination(n, a)*combination(n, b);
        
        return ans;
    }

    int combination(int n, int m) {
        int ans = 1;
        for(int i=n; i>m; i--) ans *= i;
        for(int i=n-m; i>0; i--) ans /= i;
        return ans;
    }
}
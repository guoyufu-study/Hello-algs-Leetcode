package com.jasper.algs.leetcode.maths.qu0204.solu1;

/**
 * 0204. 计数质数
 * 
 * <p> 埃氏筛法
 */
class Solution {
    public int countPrimes(int n) {
        boolean[] isNotPrime = new boolean[n];
        for(int i=2; i*i<n; i++) {
            if(!isNotPrime[i])
                for(int j=i*i; j<n; j+=i) {
                    isNotPrime[j] = true;
                }
        }

        int ans = 0;
        for(int i=2; i<n; i++) {
            if(!isNotPrime[i]) ans++;
        }
        return ans;
    }
}
package com.jasper.algs.leetcode.hashmap.qu0781.solu1;

/**
 * 0781. 森林中的兔子
 * 
 * <p> 字典计数 + 凑整
 */
class Solution {
    public int numRabbits(int[] answers) {
        int[] count = new int[1000];
        for (int x: answers) count[x]++;

        int ans = 0;
        for (int k = 0; k < 1000; ++k)
            ans += Math.floorMod(-count[k], k+1) + count[k]; // 凑整
        return ans;
    }
    
}

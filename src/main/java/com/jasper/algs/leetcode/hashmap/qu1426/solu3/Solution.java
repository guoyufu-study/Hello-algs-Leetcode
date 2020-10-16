package com.jasper.algs.leetcode.hashmap.qu1426.solu3;

/**
 * 1426. 数元素
 * 
 * <p> 辅助字典
 */
class Solution {
    public int countElements(int[] arr) {
        boolean[] map = new boolean[1002];
        for(int num : arr) map[num]=true;

        int ans = 0;
        for(int num : arr) 
            if(map[num+1]) ++ans;
        return ans;
    }
}
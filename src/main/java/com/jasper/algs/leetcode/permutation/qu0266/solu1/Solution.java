package com.jasper.algs.leetcode.permutation.qu0266.solu1;

/**
 * 0266. 回文排列
 * 
 *  <p> 辅助数组记数
 */
class Solution {
    public boolean canPermutePalindrome(String s) {

    	int[] helper = new int[128];
        for (int i = 0; i < s.length(); i++) {
            helper[s.charAt(i)]++;
        }
        
        int count = 0;
        for (int key = 0; key < helper.length && count <= 1; key++) {
            count += helper[key] % 2;
        }
        return count <= 1;

    }
    
}
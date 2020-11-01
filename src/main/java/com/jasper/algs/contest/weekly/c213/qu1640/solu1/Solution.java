package com.jasper.algs.contest.weekly.c213.qu1640.solu1;

import java.util.Arrays;

/**
 * 1640. 能否连接形成数组
 * 
 * <p> 辅助字典
 */
class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int n = arr.length;

        // 辅助字典：记录索引
        int[] indexs = new int[101];
        Arrays.fill(indexs, n);
        for(int i=0; i<n; i++) indexs[arr[i]] = i;

        // 逐一判断
        for(int[] piece : pieces) {
            int i = indexs[piece[0]], j=0;
            while(j<piece.length) {
                if(i>=n || piece[j++]!=arr[i++]) return false;
            }
        }

        return true;
    }
    
}
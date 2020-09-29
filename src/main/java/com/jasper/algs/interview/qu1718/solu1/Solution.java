package com.jasper.algs.interview.qu1718.solu1;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 17.18. 最短超串
 * 
 * <p> 滑动窗口
 */
class Solution {
    public int[] shortestSeq(int[] big, int[] small) {
        // 滑动窗口
        int n = big.length, m = small.length;
        Map<Integer, Integer> helper = new HashMap<>();
        for(int num : small) helper.put(num, 0);
        int start = 0, end = -1;
        int s = 0, e = 0, count = 0;
        for(; e < n; e++) { // 扩展窗口
            Integer feq = helper.get(big[e]);
            if(feq==null) continue; // 跳过不匹配数字
            if(feq==0) count++; // 增加匹配数字
            helper.put(big[e], feq+1);

            // 收缩窗口
            for(; count == m; s++) {
                feq = helper.get(big[s]);
                if(feq==null) continue; // 跳过不匹配数字
                helper.put(big[s], feq-1); // 减少匹配数字
                if(feq==1) { // 更新答案
                    if(end==-1 || e-s+1 < end-start+1) {
                        start = s;
                        end = e;
                        if(e-s+1==m) return new int[] {start, end}; // 剪枝
                    }
                    count--;
                }
            }
        }
        return end==-1 ? new int[0] : new int[] {start, end};
    }
}
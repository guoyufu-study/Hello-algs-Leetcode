package com.jasper.algs.leetcode.sorting.qu0056.solu3;

/**
 * 0056. 合并区间
 * 
 * <p>不排序，两两合并
 */
class Solution {
    public int[][] merge(int[][] intervals) {
    	
    	// 边界 []
    	if(intervals==null || intervals.length<=1)
    		return intervals;
    	
    	//逐个合并, 为了保证合并后的范围仍然保持能够继续合并的能力, 合并时总是合并到后边的集合中.
        int changes = 0;
        for (int i = 0; i < intervals.length; i++) {
            int[] cur = intervals[i];
            for (int j = i + 1; j < intervals.length; j++) {
                int[] next = intervals[j];
                // [[3,4],[1,2]] [[1,2],[3,4]]
                if (!(next[1] < cur[0] || cur[1] < next[0])) {
                    intervals[j][0] = Math.min(cur[0], next[0]);
                    intervals[j][1] = Math.max(cur[1], next[1]);
                    //被合并了, 置空, 后面构建返回时用
                    intervals[i] = null;
                    changes++;
                    //合并过了, 不要再和后面的合并了
                    break;
                }
            }
        }
        
        // 构造答案
        int[][] ans = new int[intervals.length - changes][2];
        int c = 0;
        for (int[] interval : intervals) {
            if (interval != null) {
                ans[c++] = interval;
            }
        }
        return ans;
    }
    
}
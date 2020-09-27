package com.jasper.algs.contest.weekly.c208.qu1601.solu1;

/**
 * 1601. 最多可达成的换楼请求数目
 * 
 * <p> 暴力枚举
 */
class Solution {
    public int maximumRequests(int n, int[][] requests) {
        // 暴力枚举
        int len = requests.length;
        int[] degrees = new int[n];
        int ans = 0;
        for(int i=0; i<(1<<len); i++) {
            int count = Integer.bitCount(i);
            if(count <= ans) continue;

            // 出度入度相同
            degrees = new int[n];
            for(int j=0; j<len; j++) // 计算
                if(((i>>j) & 1) == 1) {
                    degrees[requests[j][0]]--;// 出
                    degrees[requests[j][1]]++;// 入
                }
            
            boolean isOk = true;// 默认相同
            for(int degree : degrees) 
                if(degree!=0) {
                    isOk = false;// 其实不同
                    break;
                }
            if(isOk) ans = count;// 相同，则更新
        }

        return ans;
    }
}
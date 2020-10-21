package com.jasper.algs.contest.weekly.c172.qu1326.solu2;

/**
 * 1326. 灌溉花园的最少水龙头数目
 * 
 * <p> 贪心算法
 */
class Solution {
    public int minTaps(int n, int[] ranges) {
    	
    	// 能到达的最远位置
    	int[] next = new int[n+1];
    	for (int i = 0; i <= n; i++) next[i] = i;
    	for (int i = 0; i <= n; i++) {
			int l = Math.max(0, i-ranges[i]);
			int r = Math.min(n, i+ranges[i]);
			next[l] = Math.max(next[l], r);
		}
    	
    	int ans = 1;
    	int index = 0;
    	int right = next[0];
    	while (index <= n) {
    		// 无法到达
    		if(index > right) return -1; 
    		
    		// 最右边界能到终点
    		if(right==n) break;
    		
    		// 添加一个水龙头
    		ans++;
    		// 新水龙头最右边界
    		int most = right;
    		while(index<=right)
    			most = Math.max(most, next[index++]);
    		right = most;
    	}
    	
        return ans;
    }
    
    public static void main(String[] args) {
    	// -1
    	int n = 3;
    	int[] ranges = new int[] {0,0,0,0};
    	
    	// 3
//    	int n = 7;
//    	int[] ranges = new int[] {1,2,1,0,2,1,0,1};
    	
    	// -1
//    	int n = 3;
//    	int[] ranges = new int[] {0,0,0,0};
    	
    	// 1
//    	int n = 5;
//    	int[] ranges = new int[] {3,4,1,1,0,0};
    	
    	
    	System.out.println(new Solution().minTaps(n, ranges));
	}
}
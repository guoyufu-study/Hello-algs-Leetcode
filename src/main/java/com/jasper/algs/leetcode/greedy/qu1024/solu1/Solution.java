package com.jasper.algs.leetcode.greedy.qu1024.solu1;

/**
 * 1024. 视频拼接
 * 
 * <p> 贪心算法
 */
class Solution {
    public int videoStitching(int[][] clips, int T) {
    	// 边界
    	if(T==0) return 0;
    	
    	// 构造数据
    	int[] nexts = new int[T+1];
    	for (int i = 0; i < clips.length; i++) {
    		// 跳过无效值
    		if(clips[i][0]>T) continue;
    		// 索引：左边界 -> 值：右边界
			nexts[clips[i][0]] = Math.min(Math.max(nexts[clips[i][0]], clips[i][1]), T);
		}
    	
    	int ans=0;
    	int index=0, right=nexts[0];
    	while(index<=T) {
    		// 越界
    		if(index>right) return -1;
    		
    		// 视频片段
    		ans++;
    		
    		// 到达终点
    		if(right>=T) break;
    		
    		// 未到终点：更新下一个边界
    		int most = right;
    		while(index<=right)
    			most = Math.max(most, nexts[index++]);
    		right = most;
    	}
    	
    	return ans;
    }
    
    public static void main(String[] args) {
    	// 3
//    	int T = 10;
//    	int[][] clips = new int[][] {{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}};
    	
    	// -1
//    	int T = 5;
//    	int[][] clips = new int[][] {{0,1},{0,2}};
    	
    	// 3
//    	int T = 9;
//    	int[][] clips = new int[][] {{0,1},{6,8},{0,2},{5,6},{0,4},{0,3},{6,7},{1,3},{4,7},{1,4},{2,5},{2,6},{3,4},{4,5},{5,7},{6,9}};
    	
    	// 2
//    	int T = 5;
//    	int[][] clips = new int[][] {{0,4},{2,8}};
    	
    	// 1  无效的左边界
    	int T = 5;
    	int[][] clips = new int[][] {{5,7},{1,8},{0,0},{2,3},{4,5},{0,6},{5,10},{7,10}};

    	System.out.println(new Solution().videoStitching(clips, T));
	}
}
package com.jasper.algs.leetcode.st.qu0218.solu2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * 0218. 天际线问题
 * 
 * <p> 扫描线法
 */
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
    	// 小顶堆
    	PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0]!=b[0] ? a[0]-b[0] : a[1]-b[1]);
    	for (int[] building : buildings) {
			pq.offer(new int[] {building[0], -building[2]});
			pq.offer(new int[] {building[1], building[2]});
		}
    	
    	List<List<Integer>> ans = new ArrayList<List<Integer>>();
    	
    	// 降序排列
    	TreeMap<Integer,Integer> heights = new TreeMap<Integer, Integer>((a, b) -> b - a);
    	heights.put(0, 1);
    	int height = 0;
    	while(!pq.isEmpty()) {
    		int[] p = pq.poll();

    		// 高度计数
    		if(p[1] < 0)  // 左端点
    			heights.put(-p[1], heights.getOrDefault(-p[1], 0)+1); // 高度入堆
    		else { // 右端点
    			heights.put(p[1], heights.get(p[1])-1);
    			if(heights.get(p[1])==0) heights.remove(p[1]); // 移除高度
    		}
    		
    		// 当前关键点，最大高度
    		int maxHeight = heights.firstKey();
    		if(maxHeight != height) { // x 坐标
    			height = maxHeight;
    			ans.add(Arrays.asList(p[0], maxHeight));
    		}
    			
    	}
    	
    	return ans;
    }
}
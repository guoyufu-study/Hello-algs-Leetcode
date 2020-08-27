package com.jasper.algs.contest.weekly.c203.qu1560.solu1;

import java.util.ArrayList;
import java.util.List;

/**
 * 1560. 圆形赛道上经过次数最多的扇区
 * 
 * <p> 模拟
 */
class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
    	// 暴力模拟
    	int start = 0, m = rounds.length - 1, end = 0;
    	int[] helper = new int[n+1];
    	for (int i = 0; i < m; i++) {
			start = rounds[i];
			end = rounds[i+1];
			if(start<end) {
				while(start<end) helper[start++]++;
			} else {
				for(int k=start; k<=n; k++) helper[k]++;
				for(int k=1; k<end; k++) helper[k]++;
			}
		}
    	helper[rounds[m]]++;
    	
    	// 找出最大频次
    	int max = 0;
    	for(int num : helper) max = Math.max(max, num);
    	// 将拥有最大频次的元素组成答案
    	ArrayList<Integer> ans = new ArrayList<Integer>();
    	for (int i = 1; i <= n; i++) {
			if(helper[i]==max)
				ans.add(i);
		}
    	return ans;
    }
}

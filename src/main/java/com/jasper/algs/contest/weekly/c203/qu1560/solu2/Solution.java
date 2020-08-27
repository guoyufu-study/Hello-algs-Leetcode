package com.jasper.algs.contest.weekly.c203.qu1560.solu2;

import java.util.ArrayList;
import java.util.List;

/**
 * 1560. 圆形赛道上经过次数最多的扇区
 * 
 * <p> 省略中间过程
 */
class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
    	int start = rounds[0], m = rounds.length-1, end = rounds[m];
    	
    	ArrayList<Integer> ans = new ArrayList<Integer>();
    	if(start<=end) {
    		for(int i=start; i<=end; i++) ans.add(i);
    	} else {
    		for(int i=1; i<=end; i++) ans.add(i);
    		for(int i=start; i<=n; i++) ans.add(i);
    	}
    	
    	return ans;
    }
}
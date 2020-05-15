package com.jasper.algs.leetcode.hashmap.qu1436.solu1;

import java.util.List;

/**
 * 1436. 旅行终点站
 *
 * <p>模拟旅行路线，暴力求解
 */
class Solution {
    public String destCity(List<List<String>> paths) {
    	
    	int N = paths.size();
    	String start = paths.get(0).get(1);
    	while(true) {
    		int i = 1;
			for (; i < N; i++) {
				if(start.equals(paths.get(i).get(0))) {
					start = paths.get(i).get(1);
					break;
				}
			}
    		
    		if(i==N) return start;
    	}
    	
    }
}
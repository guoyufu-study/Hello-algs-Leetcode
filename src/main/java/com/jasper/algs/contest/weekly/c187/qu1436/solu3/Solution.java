package com.jasper.algs.contest.weekly.c187.qu1436.solu3;

import java.util.List;

/**
 * 1436. 旅行终点站
 *
 * <p>抽象数据，暴力求解
 */
class Solution {
    public String destCity(List<List<String>> paths) {
    	
    	int N = paths.size();
    	// 终点 -> 起点
    	for (int i = 0; i < N; i++) {
			String start = paths.get(i).get(1);
			int j = 0;
			for (; j < N; j++) {
				if(start.equals(paths.get(j).get(0)))
					break;
			}
			if(j==N) return start;
		}
    	
    	throw new IllegalArgumentException("无终点，请检查输入是否正确！！");
    }
}
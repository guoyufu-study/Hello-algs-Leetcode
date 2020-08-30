package com.jasper.algs.contest.weekly.c187.qu1436.solu4;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1436. 旅行终点站
 *
 * <p>抽象数据，辅助字典
 */
class Solution {
    public String destCity(List<List<String>> paths) {
    	
    	// 构造辅助字典：起点
    	int N = paths.size();
    	Set<String> helper = new HashSet<String>();
    	for (int i = 0; i < N; i++) {
			helper.add(paths.get(i).get(0));
		}
    	
    	// 终点 -> 起点
    	for (int i = 0; i < N; i++) {
			if(helper.contains(paths.get(i).get(1)))
				continue;
			return paths.get(i).get(1);
		}
    	
    	throw new IllegalArgumentException("无终点，请检查输入是否正确！！");
    }
}
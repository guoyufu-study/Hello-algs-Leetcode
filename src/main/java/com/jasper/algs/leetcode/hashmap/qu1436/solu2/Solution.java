package com.jasper.algs.leetcode.hashmap.qu1436.solu2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1436. 旅行终点站
 *
 * <p>模拟旅行路线，辅助字典
 */
class Solution {
    public String destCity(List<List<String>> paths) {
    	
    	// 构造辅助字典
    	int N = paths.size();
    	Map<String, String> helper = new HashMap<String, String>();
    	for (int i = 0; i < N; i++) {
			helper.put(paths.get(i).get(0), paths.get(i).get(1));
		}
    	
    	// 模拟旅行线路
    	String start = paths.get(0).get(1);
    	while(true) {
			if(helper.get(start)==null) {
				return start;
			}
    		start = helper.get(start);
    	}
    	
    }
}
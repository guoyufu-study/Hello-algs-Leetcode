package com.jasper.algs.leetcode.greedy.qu1282.solu1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1282. 用户分组
 * 
 * <p> 贪心算法
 */
class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {

    	int N = groupSizes.length;
    	
    	List<List<Integer>> ans = new ArrayList<>();
    	// 辅助字典： 用户组大小 -> 未满用户组
    	Map<Integer,List<Integer>> helper = new HashMap<>();
    	for (int i = 0; i < N; i++) {
    		// 用户组大小为1
    		if(groupSizes[i]==1) {
    			ans.add(Arrays.asList(i));
    			continue;
    		}
    		
    		// 用户组
    		List<Integer> group = 
    				helper.getOrDefault(groupSizes[i], new ArrayList<>());
    		// 用户入组
    		group.add(i);
    		
    		// 用户组新建
    		if(group.size()==1) {
    			helper.put(groupSizes[i], group);
    			ans.add(group);
    		} 
    		// 用户组已满
    		else if(group.size()==groupSizes[i]) {
    			helper.remove(groupSizes[i]);
    		}
		}
    	
		return ans;
    }
    
    public static void main(String[] args) {
		
    	// [[5],[0,1,2],[3,4,6]]
    	int[] groupSizes = new int[] {3,3,3,3,3,1,3};
    	
    	// [[1],[0,5],[2,3,4]]
//    	int[] groupSizes = new int[] {2,1,3,3,3,2};
    	
    	System.out.println(new Solution().groupThePeople(groupSizes));
	}
}
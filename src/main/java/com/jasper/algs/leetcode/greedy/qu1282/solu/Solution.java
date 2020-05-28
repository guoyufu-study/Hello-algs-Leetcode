package com.jasper.algs.leetcode.greedy.qu1282.solu;

import java.util.ArrayList;
import java.util.List;

/**
 * 1282. 用户分组
 * 
 * <p> 2刷
 */
class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {

    	return new ArrayList<List<Integer>>();
    }
    
    public static void main(String[] args) {
		
    	// [[5],[0,1,2],[3,4,6]]
//    	int[] groupSizes = new int[] {3,3,3,3,3,1,3};
    	
    	// [[1],[0,5],[2,3,4]]
    	int[] groupSizes = new int[] {2,1,3,3,3,2};
    	
    	System.out.println(new Solution().groupThePeople(groupSizes));
	}
}
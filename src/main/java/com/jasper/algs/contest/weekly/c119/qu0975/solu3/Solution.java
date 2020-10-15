package com.jasper.algs.contest.weekly.c119.qu0975.solu3;

import java.util.Map;
import java.util.TreeMap;

/**
 * 0975. 奇偶跳
 * 
 * <p> TreeMap + 动态规划
 */
class Solution {
    public int oddEvenJumps(int[] A) {
        int n = A.length;
        boolean[] odd = new boolean[n]; // 奇跳
        boolean[] even = new boolean[n]; // 偶跳
        odd[n-1] = even[n-1] = true;

        // TreeMap 递增
        TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
        tm.put(A[n-1], n-1);
        for(int i=n-2; i>=0; i--) {
        	// 奇跳
        	Map.Entry<Integer, Integer> oddnext = tm.ceilingEntry(A[i]);
        	if(oddnext!=null) odd[i] = even[oddnext.getValue()];
        	
        	// 偶跳
        	Map.Entry<Integer, Integer> evennext = tm.floorEntry(A[i]);
        	if(evennext!=null) even[i] = odd[evennext.getValue()];
        	
        	// 更新
        	tm.put(A[i], i);
        }
        
        // 统计
        int ans = 0;
        for(boolean canReach : odd) {
        	if(canReach) ++ans;
        }
        return ans;
    }
}
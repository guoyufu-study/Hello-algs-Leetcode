package com.jasper.algs.contest.weekly.c149.qu1156.solu1;

import java.util.ArrayList;
import java.util.List;

/**
 * 1156. 单字符重复子串的最大长度
 * 
 * <p> 滑动窗口
 */
class Solution {
	@SuppressWarnings("unchecked")
	public int maxRepOpt1(String text) {
    	int n = text.length(), left = 0, right = 1;
    	if(n==1) return n;
    	
    	// 滑动窗口
    	char[] sc = text.toCharArray();
    	List<int[]>[] helper = new ArrayList[26];
    	while(right < n) {
    		if(sc[right]==sc[left]) right++;
    		else {
    			final int start = left, end = right-1;
    			int index = sc[left] - 'a';
				if(helper[index]==null) helper[index] = new ArrayList<int[]>();
    			helper[index].add(new int[] {start, end, end-start+1});
    			left = right;
    			right++;
    		}
    	}
    	final int start = left, end = n-1;
    	int index = sc[left] - 'a';
    	if(helper[index]==null) helper[index] = new ArrayList<int[]>();
		helper[index].add(new int[] {start, end, end-start+1});
    	
    	int ans = 0;
    	for ( List<int[]> list : helper) {
    		if(list==null) continue;
    		int m = list.size();
			for (int i = 0; i < m-1; i++) {
				int[] before = list.get(i);
				int[] after = list.get(i+1);
				ans = Math.max(ans, before[2]+1);// 交换
				if(after[0] - before[1]==2) { // 组合
					int count = after[1] - before[0];
					if(m>2) ans = Math.max(ans, count+1);
					else ans = Math.max(ans, count);
				}
			}
			ans = m>1 ? Math.max(ans, list.get(m-1)[2]+1) : Math.max(ans, list.get(m-1)[2]);// 不操作
		}
    	
    	return ans;
    }
}
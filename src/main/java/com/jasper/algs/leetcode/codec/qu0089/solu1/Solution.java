package com.jasper.algs.leetcode.codec.qu0089.solu1;

import java.util.ArrayList;
import java.util.List;

/**
 * 0089. 格雷编码
 * 
 * <p> 镜像反射法
 */
class Solution {
    public List<Integer> grayCode(int n) {
    	List<Integer> ans = new ArrayList<Integer>();
    	ans.add(0);
    	
    	int head = 1;
    	for (int i = 1; i <= n; i++) {
			for (int j = ans.size()-1; j >= 0; j--) {
				ans.add(head + ans.get(j));
			}
			head <<= 1;
		}
    	return ans;
    }
}
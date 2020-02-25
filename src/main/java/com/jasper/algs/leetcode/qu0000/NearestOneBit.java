package com.jasper.algs.leetcode.qu0000;

import java.util.HashMap;
import java.util.Map;

public class NearestOneBit {

	public int lastOneBitLength(int num) {
		
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();//字典
		for (int i = 0; i < 31; i++) {
			map.put(1<<i, i);
		}
		
		int maxLen=1;
		while(num!=0) {
			if(num%2==0) {
				num >>= map.get((-num) & num);
				continue;
			}
			int len = map.get((++num) & (-num));
			maxLen = Math.max(len, maxLen);
			num >>= len+1;
		}
		
		return maxLen;
	}
}
